package com.fms.mms.controller;

import com.fms.mms.service.TeacherTableService;
import com.fms.mms.utils.R;
import com.fms.mms.vo.TeacherInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachertable")
@CrossOrigin
public class TeacherTableController {

    @Autowired
    private TeacherTableService teacherTableService;

    @GetMapping("getTea/{subject}")
    public R getTeaBySub(@PathVariable Long subject){
        List<TeacherInfoVO> teacherInfoVOList = teacherTableService.getTeaBySub(subject);
        return R.ok().data("teaInfo",teacherInfoVOList);
    }

}
