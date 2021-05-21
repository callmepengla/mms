package com.fms.mms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据字典
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
@Data
@TableName("sys_dict")
public class SysDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 上级ID,一级为0,默认为0
	 */
	private Long pid;
	/**
	 * 字典类型
	 */
	private String dictType;
	/**
	 * 字典名称
	 */
	private String dictName;
	/**
	 * 字典值
	 */
	private String dictValue;
	/**
	 * 排序,默认为0
	 */
	private Integer sort;

}
