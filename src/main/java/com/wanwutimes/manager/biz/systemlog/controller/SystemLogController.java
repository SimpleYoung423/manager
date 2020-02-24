package com.wanwutimes.manager.biz.systemlog.controller;


import com.wanwutimes.manager.annotation.SysLog;
import com.wanwutimes.manager.biz.systemlog.entity.SystemLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxp
 * @since 2020-02-16
 */
@RestController
@RequestMapping("/systemlog")
public class SystemLogController {

	@GetMapping("/hello")
	@SysLog("hello接口")
	public String hello(String message){

		return "hello world "+ message;
	}

	@GetMapping("/test")
	public String test( Long number){

		return "test===> " + number;
	}

}
