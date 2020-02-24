package com.wanwutimes.manager.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2020-02-15 20:28
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonResponse<T> implements Serializable {

	private Integer code;
	private String message;
	private T data;

	public CommonResponse(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public  CommonResponse creat(Integer code, String message){
		this.code = code;
		this.message = message;
		return new CommonResponse(code,message);
	}

}
