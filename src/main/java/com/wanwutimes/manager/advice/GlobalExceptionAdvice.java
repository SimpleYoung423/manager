package com.wanwutimes.manager.advice;

import com.wanwutimes.manager.exception.WanwuTimesException;
import com.wanwutimes.manager.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2020-02-15 20:55
 * @Version: 1.0
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

	/**
	 * WanwuTimesException 处理
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = WanwuTimesException.class)
	public CommonResponse<String> handleWanwutimesException(HttpServletRequest request, WanwuTimesException ex) {

		CommonResponse<String> response = new CommonResponse<>(-1, "系统错误！");
		response.setData(ex.getMessage());
		return response;
	}

}
