package com.fms.mms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fms.mms.utils.R;
import com.fms.mms.utils.TokenGenerator;
import org.springframework.stereotype.Service;
import com.fms.mms.dao.SysUserTokenDao;
import com.fms.mms.entity.SysUserTokenEntity;
import com.fms.mms.service.SysUserTokenService;

import java.util.HashMap;
import java.util.Map;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {

    /**
     * 12小时后过期
     */
    private final static int EXPIRE = 3600 * 12;

    @Override
    public R createToken(Long userId) {
        //用户token
        String token;

        //过期时间
        Long expireTime = System.currentTimeMillis() + EXPIRE * 1000;

        //判断是否生成过token
        SysUserTokenEntity tokenEntity = this.baseMapper.getByUserId(userId);
        if(tokenEntity == null){
            //生成一个token
            token = TokenGenerator.generateValue();

            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setExpireDate(expireTime);

            //保存token
            this.baseMapper.insert(tokenEntity);
        }else{
            //判断token是否过期
            if(tokenEntity.getExpireDate() < System.currentTimeMillis()){
                //token过期，重新生成token
                token = TokenGenerator.generateValue();
            }else {
                token = tokenEntity.getToken();
            }

            tokenEntity.setToken(token);
            tokenEntity.setExpireDate(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }

        Map<String, Object> map = new HashMap<>(2);
        map.put("token", token);
        map.put("expire", EXPIRE);
        return R.ok().data("map",map);
    }
}
