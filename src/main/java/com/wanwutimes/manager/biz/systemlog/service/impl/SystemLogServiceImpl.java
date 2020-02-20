package com.wanwutimes.manager.biz.systemlog.service.impl;

import com.wanwutimes.manager.biz.systemlog.entity.SystemLog;
import com.wanwutimes.manager.biz.systemlog.mapper.SystemLogMapper;
import com.wanwutimes.manager.biz.systemlog.service.ISystemLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxp
 * @since 2020-02-16
 */
@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog> implements ISystemLogService {

	@Autowired
	private SystemLogMapper systemLogMapper;


	@Override
	public void saveSystemLog(SystemLog systemLog) {

		systemLogMapper.insert(systemLog);
	}
}
