package com.fms.mms.dao;

import com.fms.mms.entity.ClassStudentBindEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fms.mms.vo.ClassBindInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班级绑定教师（id）以及学生（id）
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
@Mapper
public interface ClassStudentBindDao extends BaseMapper<ClassStudentBindEntity> {
    /**
     * 获取绑定表分页信息
     * @param map
     * @return
     */
    List<ClassBindInfoVO> getBingInfoPage(Map<String, Object> map);

    /**
     * 根据条件获取总数
     * @param map
     * @return
     */
    Integer getBindInfoCount(Map<String, Object> map);
}
