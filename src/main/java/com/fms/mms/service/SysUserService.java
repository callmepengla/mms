package com.fms.mms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fms.mms.entity.SysUserEntity;

/**
 * 系统用户
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-17 09:51:05
 */
public interface SysUserService extends IService<SysUserEntity> {
    /**
     * 根据用户名称获取用户信息
     * @param userName
     * @return
     */
    SysUserEntity getByUserName(String userName);
}

