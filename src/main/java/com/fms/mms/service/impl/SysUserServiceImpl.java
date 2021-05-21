package com.fms.mms.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.fms.mms.dao.SysUserDao;
import com.fms.mms.entity.SysUserEntity;
import com.fms.mms.service.SysUserService;


@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
    @Override
    public SysUserEntity getByUserName(String userName) {
        SysUserEntity userEntity = this.baseMapper.getByUsername(userName);
        if (userEntity == null){
            return null;
        }
        return userEntity;
    }
}
