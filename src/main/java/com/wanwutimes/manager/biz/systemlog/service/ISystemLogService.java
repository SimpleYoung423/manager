package com.wanwutimes.manager.biz.systemlog.service;

import com.wanwutimes.manager.biz.systemlog.entity.SystemLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxp
 * @since 2020-02-16
 */
public interface ISystemLogService extends IService<SystemLog> {

	/**
	 * 保存日志
	 * @param systemLog
	 */
	void saveSystemLog(SystemLog systemLog);

}
