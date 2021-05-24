package com.fms.mms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import com.fms.mms.dto.StudentFilesDTO;
import com.fms.mms.entity.StudentFilesEntity;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;

import java.util.Map;

/**
 * 学生档案信息表
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
public interface StudentFilesService extends IService<StudentFilesEntity> {

    /**
     * 获取学生档案管理分页
     * @param params
     * @return
     */
    PageUtils getStudentFilesPage(Map<String,Object> params);

    /**
     * 添加学生档案
     * @param studentFilesDTO
     */
    R addStudentFiles(StudentFilesDTO studentFilesDTO);

    /**
     * 根据学生学号查询是否存在
     * @param scoreSchoolid
     * @return
     */
    Boolean selectStudent(String scoreSchoolid);

    /**
     * 查询功能is_add = 0
     * @param params
     * @return
     */
    PageUtils getFilesPage(Map<String, Object> params);
}

