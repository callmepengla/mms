package com.fms.mms.dao;

import com.fms.mms.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-17 09:51:05
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
    /**
     * 根据用户名称获取用户信息
     * @param username
     * @return
     */
    SysUserEntity getByUsername(String username);
}
