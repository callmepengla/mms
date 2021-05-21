package com.fms.mms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fms.mms.entity.SysUserTokenEntity;
import com.fms.mms.utils.R;


/**
 * 系统用户Token
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-17 09:51:05
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {
    /**
     * 生成token
     * @param userId
     * @return
     */
    R createToken(Long userId);
}

