package com.fms.mms.dto;

import com.fms.mms.entity.StudentFilesEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DateFormDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private ClassBindTeacherDTO form;

    private List<StudentFilesEntity> multipleSelection;
}
