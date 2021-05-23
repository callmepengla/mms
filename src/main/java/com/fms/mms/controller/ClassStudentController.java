package com.fms.mms.controller;

import com.fms.mms.service.ClassStudentService;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("classstudent")
@CrossOrigin
public class ClassStudentController {

    @Autowired
    private ClassStudentService classStudentService;

    /**
     * 获取学生分页
     * @param params
     * @return
     */
    @GetMapping("page")
    public R getClassStuPage(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = classStudentService.getClassStuPage(params);
        return R.ok().data("pageData",pageUtils);
    }

}
