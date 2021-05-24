package com.fms.mms.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.fms.mms.dto.ClassBindTeacherDTO;
import com.fms.mms.entity.ClassStudentEntity;
import com.fms.mms.entity.StudentFilesEntity;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;

import java.util.List;
import java.util.Map;


/**
 *
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-23 18:58:41
 */
public interface ClassStudentService extends IService<ClassStudentEntity> {
    /**
     * 获取学生分页
     * @param params
     * @return
     */
    PageUtils getClassStuPage(Map<String, Object> params);

    /**
     * 通过id获取班级学生信息
     * @param editId
     * @return
     */
    R getInfoById(Long editId);

    /**
     * 班级学生修改接口
     * @param editId
     * @param classBindTeacherDTO
     */
    void editTeacher(Long editId, ClassBindTeacherDTO classBindTeacherDTO);

    /**
     * 学生班级分配
     * @param gradeName
     * @param classNumber
     * @param multipleSelection
     */
    void addStuList(Long gradeName, Integer classNumber, List<StudentFilesEntity> multipleSelection);

    /**
     * 根据id删除接口
     * @param id
     * @return
     */
    void removeStuById(Long id);
}

