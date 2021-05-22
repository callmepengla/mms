package com.fms.mms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


import com.fms.mms.dao.ClassTableDao;
import com.fms.mms.entity.ClassTableEntity;
import com.fms.mms.service.ClassTableService;


@Service("classTableService")
public class ClassTableServiceImpl extends ServiceImpl<ClassTableDao, ClassTableEntity> implements ClassTableService {

    @Override
    public Long getIdByGradeAndClNum(Long grade, Integer classNuamber) {
        QueryWrapper<ClassTableEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("grade",grade);
        wrapper.eq("class_number",classNuamber);
        ClassTableEntity classTableEntity = this.baseMapper.selectOne(wrapper);
        return classTableEntity.getId();
    }
}
