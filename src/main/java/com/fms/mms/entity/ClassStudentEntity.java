package com.fms.mms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 *
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-23 18:58:41
 */
@Data
@TableName("class_student")
public class ClassStudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 班级表id
	 */
	private Long classTableId;
	/**
	 * 学生档案表id
	 */
	private Long studentFilesId;

}
