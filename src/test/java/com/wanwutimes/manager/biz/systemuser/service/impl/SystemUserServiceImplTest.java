package com.wanwutimes.manager.biz.systemuser.service.impl;

import com.wanwutimes.manager.BaseApplicationTest;
import com.wanwutimes.manager.biz.systemuser.entity.SystemUser;
import com.wanwutimes.manager.biz.systemuser.service.ISystemUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class SystemUserServiceImplTest extends BaseApplicationTest {

	@Resource
	ISystemUserService systemUserService;

	@Test
	void getUserById(){


		SystemUser user = systemUserService.getById(1);
		System.out.println(user);
	}


}