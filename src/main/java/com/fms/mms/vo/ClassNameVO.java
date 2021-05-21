package com.fms.mms.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 班级名称VO类
 */
@Data
public class ClassNameVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer value;

    private String label;
}
