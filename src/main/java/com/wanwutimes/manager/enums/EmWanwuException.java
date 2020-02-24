package com.wanwutimes.manager.enums;

import lombok.Getter;

/**
 *
 * @author yxp
 * @CreateDate: 2020-02-15 21:06
 */
@Getter
public enum EmWanwuException {


	/**
	 * 系统错误
	 */
	BUSINESS_ERROR(-1,"系统错误!"),
	/**
	 * 未知错误
	 */
	UNKNOWN_ERROR(10001,"未知错误"),

	/**
	 * 访问路径未找到
	 */
	NO_HANDLER_FOUND(404,"访问路径未找到"),

	/**
	 * 参数错误
	 */
	BIND_EXCEPTION(10002,"参数错误");




	private Integer code;
	private String message;
	EmWanwuException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
