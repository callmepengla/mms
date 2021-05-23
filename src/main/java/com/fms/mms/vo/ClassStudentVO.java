package com.fms.mms.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 学生VO类
 */
@Data
public class ClassStudentVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 学号
     */
    private String scoreSchoolid;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 年级
     */
    private Long grade;
    /**
     * 年级
     */
    private String gradeName;
    /**
     * 班级
     */
    private Integer classNumber;
}
