package com.fms.mms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 班级绑定教师（id）以及学生（id）
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
@Data
@TableName("class_student_bind")
public class ClassStudentBindEntity implements Serializable {
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
	 * 教师表id
	 */
	private Long teacherTableId;
}
