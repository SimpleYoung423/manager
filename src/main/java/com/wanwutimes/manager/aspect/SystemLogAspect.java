package com.wanwutimes.manager.aspect;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.StrUtil;
import com.wanwutimes.manager.annotation.SysLog;
import com.wanwutimes.manager.biz.systemlog.entity.SystemLog;
import com.wanwutimes.manager.biz.systemlog.service.ISystemLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Description: 系统日志记录切面类
 * @Author: yxp
 * @CreateDate: 2020-02-15 21:06
 * @Version: 1.0
 */

@Aspect
@Component
@Slf4j
public class SystemLogAspect {

	@Resource
	private ISystemLogService systemLogService;

	@Pointcut("@annotation(com.wanwutimes.manager.annotation.SysLog)")
	public void pointCut() {
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) {

		try {
			TimeInterval timeInterval = new TimeInterval();
			long startTime = timeInterval.start();
			//获取当前请求对象
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();

			Object result = joinPoint.proceed();
			Signature signature = joinPoint.getSignature();
			MethodSignature methodSignature = (MethodSignature) signature;
			Method method = methodSignature.getMethod();
			String operation = method.getAnnotation(SysLog.class).value();
			long speedTime = timeInterval.intervalMs();
			SystemLog systemLog = new SystemLog();

			systemLog.setUserId(111);

			//记录日志时间
			systemLog.setCreateTime(DateUtil.date(startTime));
			//ip
			systemLog.setIpAddress(request.getRemoteAddr());
			//获取url
			systemLog.setUrl(String.valueOf(request.getRequestURL()));
			//获取uri
			systemLog.setUri(request.getRequestURI());
			//获取请求方法
			systemLog.setHttpMethod(request.getMethod());
			//参数
			if (StrUtil.isNotEmpty(operation)) {
				systemLog.setOperation(operation);
			}
			String parameter = Arrays.toString(joinPoint.getArgs());
			systemLog.setParameter(parameter);
			systemLog.setResult(result);
			systemLog.setSpeedTime((int) speedTime);

			systemLogService.saveSystemLog(systemLog);

		} catch (Throwable ex) {
			ex.printStackTrace();
		}

		return "保存日志成功!";
	}


}
