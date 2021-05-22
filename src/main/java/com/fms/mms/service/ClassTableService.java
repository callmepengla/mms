package com.fms.mms.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.fms.mms.entity.ClassTableEntity;


/**
 * 班级表
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
public interface ClassTableService extends IService<ClassTableEntity> {

    /**
     * 根据年级id&班级获取班级表id
     * @param grade
     * @param classNuamber
     * @return
     */
    Long getIdByGradeAndClNum(Long grade,Integer classNuamber);
}

