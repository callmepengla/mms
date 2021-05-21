package com.fms.mms.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.fms.mms.dto.StudentScoreDTO;
import com.fms.mms.entity.StudentScoreEntity;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;
import com.fms.mms.vo.ScoreNamesVO;

import java.util.List;
import java.util.Map;

/**
 * 学生科目分数信息表
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
public interface StudentScoreService extends IService<StudentScoreEntity> {
    /**
     * 根据条件查询学生成绩
     * @param params
     * @return
     */
    R getScorePage(Map<String, Object> params);

    /**
     * 所有课程名称的集合
     * @return
     */
    List<ScoreNamesVO> getAllScoreNames();

    /**
     * 新增分数信息
     * @param studentScoreDTO
     * @return
     */
    R addScoreInfo(StudentScoreDTO studentScoreDTO);
}

