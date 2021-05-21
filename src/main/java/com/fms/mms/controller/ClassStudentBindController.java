package com.fms.mms.controller;

import com.fms.mms.dto.ClassBindTeacherDTO;
import com.fms.mms.service.ClassStudentBindService;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("classstudentbind")
public class ClassStudentBindController {

    @Autowired
    private ClassStudentBindService classStudentBindService;
    /**
     * 获取绑定班级教师学生分页
     * @param params
     * @return
     */
    @GetMapping("page")
    public R getClassStuBindPage(@RequestParam Map<String, Object> params){
        PageUtils pageUtils = classStudentBindService.getClassStuBindPage(params);
        return R.ok().data("pageData",pageUtils);
    }

    /**
     * 根据id删除接口
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R removeStudentFiles(@PathVariable Long id){
        boolean flag = classStudentBindService.removeById(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 绑定教师班级接口
     * @param classBindTeacherDTO
     * @return
     */
    @PostMapping("bindstutea")
    public R bindStuTea(@RequestBody ClassBindTeacherDTO classBindTeacherDTO){
        return null;
    }
}