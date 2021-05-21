package com.fms.mms.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生科目分数信息表
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
@Data
@TableName("student_score")
public class StudentScoreEntity implements Serializable {
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
	 * 科目名称
	 */
	private Long scoreName;
	/**
	 * 科目分数
	 */
	private Integer scoreSubject;
	/**
	 * 年级
	 */
	private Long gradeName;
	/**
	 * 班级
	 */
	private int classNumber;
	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date createDate;
	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;

}
