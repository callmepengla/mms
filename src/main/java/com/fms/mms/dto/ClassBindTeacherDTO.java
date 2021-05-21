package com.fms.mms.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 分班管理DTO类
 */
@Data
public class ClassBindTeacherDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 班级
     */
    private Integer classNumber;
    /**
     * 年级
     */
    private Long gradeName;
    /**
     * 学科
     */
    private Long scoreName;
    /**
     * 教师表id
     */
    private Long teacherName;
}
