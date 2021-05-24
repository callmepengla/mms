package com.fms.mms.controller;

import com.fms.mms.dto.StudentFilesDTO;
import com.fms.mms.entity.StudentFilesEntity;
import com.fms.mms.service.StudentFilesService;
import com.fms.mms.utils.ConvertUtils;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentFilesController {
    @Autowired
    private StudentFilesService studentFilesService;

    /**
     * 分页查询功能
     * @param params
     * @return
     */
    @GetMapping("filesPage")
    public R getStudentFilesPage(@RequestParam Map<String, Object> params){
        PageUtils studentFilesPage = studentFilesService.getStudentFilesPage(params);
        return R.ok().data("filespage",studentFilesPage);
    }

    /**
     * 根据id删除接口
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R removeStudentFiles(@PathVariable Long id){
        boolean flag = studentFilesService.removeById(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 添加档案接口
     * @param studentFilesDTO
     * @return
     */
    @PostMapping("addfiles")
    public R addStudentFiles(@RequestBody StudentFilesDTO studentFilesDTO){
        R result = studentFilesService.addStudentFiles(studentFilesDTO);
        return result;
    }

    /**
     * 根据id获取档案信息
     * @param id
     * @return
     */
    @GetMapping("getfiles/{id}")
    public R getFilesById(@PathVariable Long id){
        StudentFilesEntity entity = studentFilesService.getById(id);
        return R.ok().data("files",entity);
    }

    /**
     * 修改档案信息
     * @param studentFilesDTO
     * @return
     */
    @PostMapping("updatafiles")
    public R updataFilesData(@RequestBody StudentFilesDTO studentFilesDTO){
        StudentFilesEntity entity = ConvertUtils.sourceToTarget(studentFilesDTO, StudentFilesEntity.class);
        boolean flag = studentFilesService.updateById(entity);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 查询功能is_add = 0
     * @param params
     * @return
     */
    @GetMapping("stuPage")
    public R getFilesPage(@RequestParam Map<String, Object> params){
        PageUtils studentFilesPage = studentFilesService.getFilesPage(params);
        return R.ok().data("filespage",studentFilesPage);
    }
}
