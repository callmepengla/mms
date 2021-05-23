package com.fms.mms.dao;

import com.fms.mms.entity.ClassStudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fms.mms.vo.ClassStudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 *
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-23 18:58:41
 */
@Mapper
public interface ClassStudentDao extends BaseMapper<ClassStudentEntity> {
    /**
     * 获取学生分页集合
     * @param map
     * @return
     */
    List<ClassStudentVO> getClassStuPage(HashMap<String, Object> map);

    /**
     * 获取学生分页条数
     * @param map
     * @return
     */
    Integer getClassStuCount(HashMap<String, Object> map);
}
