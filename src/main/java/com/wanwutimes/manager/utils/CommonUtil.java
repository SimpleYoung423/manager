package com.wanwutimes.manager.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @Description: 常用工具类
 * @Author: yxp
 * @CreateDate: 2020-02-23 16:24
 * @Version: 1.0
 */

public class CommonUtil {

	/**
	 * 对校验错误信息拼串
	 * @param bindingResult
	 * @return 所有校验未通过的字段
	 */
	public static String processErrorString(BindingResult bindingResult){

		if ( ! bindingResult.hasErrors()){
			return "";
		}

		StringBuilder strBuilder = new StringBuilder();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		fieldErrors.forEach(item-> strBuilder.append(item.getDefaultMessage()));
		return strBuilder.substring(0,strBuilder.length()-1);
	}

}
