package com.fms.mms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fms.mms.entity.ClassTableEntity;
import com.fms.mms.service.ClassTableService;
import com.fms.mms.utils.R;
import com.fms.mms.vo.ClassNameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("classtable")
@CrossOrigin
public class ClassTableController {
    @Autowired
    private ClassTableService classTableService;

    @GetMapping("queryclass/{grade}")
    public R queryClass(@PathVariable Long grade){
        QueryWrapper<ClassTableEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("grade",grade);
        List<ClassTableEntity> list = classTableService.list(wrapper);
        List<ClassNameVO> classNameVOList = new ArrayList<>();
        for (ClassTableEntity classTableEntity : list){
            ClassNameVO classNameVO = new ClassNameVO();
            classNameVO.setLabel(classTableEntity.getClassNumber() + "班");
            classNameVO.setValue(classTableEntity.getClassNumber());
            classNameVOList.add(classNameVO);
        }
        return R.ok().data("list",classNameVOList);
    }
}
