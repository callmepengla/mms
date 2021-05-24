package com.fms.mms.dao;

import com.fms.mms.entity.StudentFilesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生档案信息表
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
@Mapper
public interface StudentFilesDao extends BaseMapper<StudentFilesEntity> {

    /**
     * 根据条件查询学员档案分页信息
     * @param params
     * @return
     */
    List<StudentFilesEntity> getPage(Map<String, Object> params);

    /**
     * 获取总条数
     * @param params
     * @return
     */
    Integer getCount(Map<String, Object> params);

    /**
     * 查询功能is_add = 0
     * @param map
     * @return
     */
    List<StudentFilesEntity> getFilePage(Map<String, Object> map);

    /**
     * 获取总条数
     * @return
     */
    int getTotal();
}
