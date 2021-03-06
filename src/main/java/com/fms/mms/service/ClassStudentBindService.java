package com.fms.mms.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.fms.mms.dto.ClassBindTeacherDTO;
import com.fms.mms.entity.ClassStudentBindEntity;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;

import java.util.Map;

/**
 * 班级绑定教师（id）以及学生（id）
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
public interface ClassStudentBindService extends IService<ClassStudentBindEntity> {
    /**
     * 获取绑定班级教师学生分页
     * @param params
     * @return
     */
    PageUtils getClassStuBindPage(Map<String, Object> params);

    /**
     * 绑定班级教师
     * @param classBindTeacherDTO
     * @return
     */
    Integer bindStuTea(ClassBindTeacherDTO classBindTeacherDTO);

    /**
     * 编辑班级绑定教师
     * @param editId
     * @param classBindTeacherDTO
     * @return
     */
    void editTeacher(Long editId, ClassBindTeacherDTO classBindTeacherDTO);

    /**
     * 通过id获取班级教师信息
     * @param editId
     */
    R getInfoById(Long editId);
}

