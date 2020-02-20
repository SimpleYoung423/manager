package com.wanwutimes.manager.biz.systemlog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yxp
 * @since 2020-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
public class SystemLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志ID
     */
    @TableId(value = "log_id", type = IdType.AUTO)
    private Integer logId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 登录的用户名
     */
    private String userName;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 操作
     */
    private String operation;

    /**
     * 请求参数
     */
    private Object parameter;

    /**
     * 请求的方法，get，post
     */
    private String httpMethod;

    /**
     * uri
     */
    private String uri;

    private String url;

    /**
     * 返回结果
     */
    private Object result;

    /**
     * 生成日志的时间
     */
    private Date createTime;

    /**
     * 执行时长
     */
    private Integer speedTime;


}
