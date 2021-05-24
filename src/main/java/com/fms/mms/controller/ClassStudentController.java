package com.fms.mms.controller;

import com.fms.mms.dto.ClassBindTeacherDTO;
import com.fms.mms.dto.DateFormDTO;
import com.fms.mms.entity.StudentFilesEntity;
import com.fms.mms.service.ClassStudentService;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    /**
     * 根据id删除接口
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R removeStudent(@PathVariable Long id){
        classStudentService.removeStuById(id);
        return R.ok();
    }

    /**
     * 通过id获取班级学生信息
     * @param editId
     * @return
     */
    @GetMapping("getInfoById/{editId}")
    public R getInfoById(@PathVariable Long editId){
        R r = classStudentService.getInfoById(editId);
        return r;
    }

    /**
     * 班级学生修改接口
     * @param editId
     * @param classBindTeacherDTO
     * @return
     */
    @PostMapping("edit/{editId}")
    public R updateTeacher(@PathVariable Long editId,@RequestBody ClassBindTeacherDTO classBindTeacherDTO){
        classStudentService.editTeacher(editId,classBindTeacherDTO);
        return R.ok();
    }

    /**
     * 学生班级分配
     * @param dateForm
     * @return
     */
    @PostMapping("addstulist")
    public R addStuList(@RequestBody DateFormDTO dateForm){
        Long gradeName = dateForm.getForm().getGradeName();
        Integer classNumber = dateForm.getForm().getClassNumber();
        List<StudentFilesEntity> multipleSelection = dateForm.getMultipleSelection();
        classStudentService.addStuList(gradeName,classNumber,multipleSelection);
        return R.ok();
    }

}
