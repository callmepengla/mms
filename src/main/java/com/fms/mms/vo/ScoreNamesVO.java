package com.fms.mms.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 课程名称VO类
 */
@Data
public class ScoreNamesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long value;

    private String label;
}
