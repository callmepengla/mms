package com.fms.mms.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.fms.mms.entity.TeacherTableEntity;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.vo.TeacherInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 教师信息表
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
public interface TeacherTableService extends IService<TeacherTableEntity> {
    /**
     * 通过课程名称获取对应的教师
     * @param subject
     * @return
     */
    List<TeacherInfoVO> getTeaBySub(Long subject);
}

