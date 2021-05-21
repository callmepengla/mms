package com.fms.mms.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * 学生档案信息表DTO
 *
 * @author admin
 * @email sunlightcs@gmail.com
 * @date 2021-05-15 14:37:21
 */
@Data
public class StudentFilesDTO implements Serializable {
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
     * 性别
     */
    private String studentGender;
    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date studentBirthday;
    /**
     * 联系电话
     */
    private String phoneNumber;
    /**
     * 父亲姓名
     */
    private String fatherName;
    /**
     * 家庭状况
     */
    private String familyStatus;
    /**
     * 毕业去向
     */
    private String graduationWhere;
    /**
     * 家庭住址
     */
    private String address;
    /**
     * 照片
     */
    private String photo;

}
