package com.wanwutimes.manager.advice;

import com.wanwutimes.manager.enums.EmWanwuException;
import com.wanwutimes.manager.exception.WanwuTimesException;
import com.wanwutimes.manager.vo.CommonResponse;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 全局异常处理
 * @Author: yxp
 * @CreateDate: 2020-02-15 20:55
 * @Version: 1.0
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

	/**
	 *  将异常处理为json格式
	 *
	 * @param request
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public CommonResponse<String> handleException(HttpServletRequest request, Exception ex) {

		CommonResponse<String> response = new CommonResponse<>();

		if (ex instanceof WanwuTimesException) {
			response.creat(EmWanwuException.BUSINESS_ERROR.getCode(), EmWanwuException.BUSINESS_ERROR.getMessage());
		} else if (ex instanceof NoHandlerFoundException) {
			response.creat(EmWanwuException.NO_HANDLER_FOUND.getCode(), EmWanwuException.NO_HANDLER_FOUND.getMessage());
		} else if (ex instanceof ServletRequestBindingException) {
			response.creat(EmWanwuException.BIND_EXCEPTION.getCode(), EmWanwuException.BIND_EXCEPTION.getMessage());
		} else {
			response.creat(EmWanwuException.UNKNOWN_ERROR.getCode(), EmWanwuException.UNKNOWN_ERROR.getMessage());
		}
		response.setData(ex.getMessage());
		return response;
	}

}
