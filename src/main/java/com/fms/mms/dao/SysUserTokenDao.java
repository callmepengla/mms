package com.fms.mms.dao;

import com.fms.mms.entity.SysUserTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fms.mms.utils.R;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户Token
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-17 09:51:05
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {
    /**
     * 获取用户token信息
     * @param userId
     * @return
     */
    SysUserTokenEntity getByUserId(Long userId);
}
