package com.fms.mms.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 教师信息VO类
 */
@Data
public class ClassTeacherVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 年级
     */
    private Long gradeName;
    /**
     * 班级
     */
    private Integer classNumber;
    /**
     * 教师职位
     */
    private Long positionName;
    /**
     * 教师姓名
     */
    private String teacherName;
}
