package com.fms.mms.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 教师信息选择器VO类
 */
@Data
public class TeacherInfoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long value;

    private String label;
}
