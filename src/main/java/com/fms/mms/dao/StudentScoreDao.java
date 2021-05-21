package com.fms.mms.dao;

import com.fms.mms.entity.StudentScoreEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fms.mms.vo.StudentScoreVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 学生科目分数信息表
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
@Mapper
public interface StudentScoreDao extends BaseMapper<StudentScoreEntity> {

    /**
     * 根据条件获取学生成绩信息集合
     * @param params
     * @return
     */
    List<StudentScoreEntity> getScoreList(Map<String,Object> params);

    /**
     * 获取总条数
     * @param params
     * @return
     */
    Integer getCount(Map<String, Object> params);
}
