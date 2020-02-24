package com.wanwutimes.manager.advice;

import com.wanwutimes.manager.annotation.IgnoreResponseAdvice;
import com.wanwutimes.manager.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description: 统一响应处理
 * @Author: yxp
 * @CreateDate: 2020-02-15 20:29
 * @Version: 1.0
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

	@Override
	@SuppressWarnings("all")
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

		//类上有 @IgnoreResponseAdvice 注解
		if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)){

			return false;
		}
		//方法上有注解
		else if (returnType.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
			return false;
		}
		return true;
	}

	@Override
	@SuppressWarnings("all")
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

		CommonResponse<Object> commonResponse = new CommonResponse<>(0,"");

		if (body == null){
			return response;
		} else if (body instanceof CommonResponse) {
			commonResponse = (CommonResponse<Object>) body;
		}else {
			commonResponse.setData(body);
		}

		return commonResponse;


	}
}
