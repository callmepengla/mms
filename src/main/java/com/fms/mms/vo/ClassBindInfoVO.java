package com.fms.mms.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 班级教师学生绑定表VO
 */
@Data
public class ClassBindInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 年级
     */
    private Long grade;
    /**
     * 年级
     */
    private String gradeName;
    /**
     * 班级编号
     */
    private Integer classNumber;
    /**
     * 教师姓名
     */
    private String teacherName;
    /**
     * 教师职位
     */
    private Long teacherPosition;
    /**
     * 教师职位
     */
    private String teacherPositionName;
    /**
     * 任教科目
     */
    private Long subject;
    /**
     * 任教科目
     */
    private String subjectName;
}
