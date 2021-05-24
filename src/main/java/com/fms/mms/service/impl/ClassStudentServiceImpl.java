package com.fms.mms.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fms.mms.dao.ClassStudentDao;
import com.fms.mms.dto.ClassBindTeacherDTO;
import com.fms.mms.entity.ClassStudentEntity;
import com.fms.mms.entity.ClassTableEntity;
import com.fms.mms.entity.StudentFilesEntity;
import com.fms.mms.enums.GradeNameEnum;
import com.fms.mms.service.ClassStudentService;
import com.fms.mms.service.ClassTableService;
import com.fms.mms.service.StudentFilesService;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;
import com.fms.mms.vo.ClassStudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("classStudentService")
public class ClassStudentServiceImpl extends ServiceImpl<ClassStudentDao, ClassStudentEntity> implements ClassStudentService {
    @Autowired
    private ClassTableService classTableService;
    @Autowired
    private StudentFilesService studentFilesService;

    @Override
    public PageUtils getClassStuPage(Map<String, Object> params) {
        //获取数据
        String page = (String) params.get("page");
        String limit = (String) params.get("limit");
        String gradeName = (String) params.get("gradeName");//年级
        String classNumber = (String) params.get("classNumber");//班级
        String scoreSchoolId = (String) params.get("scoreSchoolId");//学号
        // 获取起始长度
        Integer size = Integer.valueOf(limit);
        Integer index = Integer.valueOf(page);
        if (index > 0) {
            index = (index - 1) * size;
        }
        // 条件查询产品VO数组以及总条数
        HashMap<String, Object> map = new HashMap<>(7);
        map.put("gradeName", gradeName);
        map.put("scoreSchoolId", scoreSchoolId);
        map.put("classNumber", classNumber);
        map.put("size", size);
        map.put("index", index);
        //查询集合
        List<ClassStudentVO> classStudentVOList = this.baseMapper.getClassStuPage(map);
        for (ClassStudentVO classStudentVO : classStudentVOList){
            Long grade = classStudentVO.getGrade();
            classStudentVO.setGradeName(GradeNameEnum.getCnById(grade));
        }
        Integer count = this.baseMapper.getClassStuCount(map);
        PageUtils pageUtils = new PageUtils(classStudentVOList,count,size,index);
        return pageUtils;
    }

    @Override
    public R getInfoById(Long editId) {
        ClassStudentEntity classStudentEntity = this.baseMapper.selectById(editId);
        Long classTableId = classStudentEntity.getClassTableId();
        Long studentFilesId = classStudentEntity.getStudentFilesId();

        ClassTableEntity classTableEntity = classTableService.getById(classTableId);
        Integer classNumber = classTableEntity.getClassNumber();
        Long grade = classTableEntity.getGrade();

        StudentFilesEntity studentFilesEntity = studentFilesService.getById(studentFilesId);
        String scoreSchoolid = studentFilesEntity.getScoreSchoolid();
        String studentName = studentFilesEntity.getStudentName();
        Map<String, Object> map = new HashMap<>();
        map.put("grade",grade);
        map.put("classNumber",classNumber);
        map.put("studentName",studentName);
        map.put("scoreSchoolid",scoreSchoolid);
        return R.ok().data("map",map);
    }

    @Override
    public void editTeacher(Long editId, ClassBindTeacherDTO classBindTeacherDTO) {
        Integer classNumber = classBindTeacherDTO.getClassNumber();
        Long gradeName = classBindTeacherDTO.getGradeName();
        //根据年级id、班级查询班级表id
        Long id = classTableService.getIdByGradeAndClNum(gradeName, classNumber);
        UpdateWrapper<ClassStudentEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",editId);
        ClassStudentEntity classStudentEntity = new ClassStudentEntity();
        classStudentEntity.setClassTableId(id);
        this.baseMapper.update(classStudentEntity,updateWrapper);
    }
}
