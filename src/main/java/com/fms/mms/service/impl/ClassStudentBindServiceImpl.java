package com.fms.mms.service.impl;


import com.fms.mms.dto.ClassBindTeacherDTO;
import com.fms.mms.enums.GradeNameEnum;
import com.fms.mms.enums.ScoreNameEnum;
import com.fms.mms.enums.TeacherPositionEnum;
import com.fms.mms.service.ClassTableService;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.vo.ClassBindInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fms.mms.dao.ClassStudentBindDao;
import com.fms.mms.entity.ClassStudentBindEntity;
import com.fms.mms.service.ClassStudentBindService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("classStudentBindService")
public class ClassStudentBindServiceImpl extends ServiceImpl<ClassStudentBindDao, ClassStudentBindEntity> implements ClassStudentBindService {

    @Autowired
    private ClassTableService classTableService;
    @Override
    public PageUtils getClassStuBindPage(Map<String, Object> params) {
        //获取数据
        String page = (String) params.get("page");
        String limit = (String) params.get("limit");
        String subject = (String) params.get("subject");
        String teacherName = (String) params.get("teacherName");//教师姓名
        String grade = (String) params.get("grade");//年级
        String classNumber = (String) params.get("classNumber");//班级

        // 获取起始长度
        Integer size = Integer.valueOf(limit);
        Integer index = Integer.valueOf(page);
        if (index > 0) {
            index = (index - 1) * size;
        }
        // 条件查询产品VO数组以及总条数
        HashMap<String, Object> map = new HashMap<>(7);
        map.put("subject", subject);
        map.put("teacherName", teacherName);
        map.put("grade", grade);
        map.put("classNumber", classNumber);
        map.put("size", size);
        map.put("index", index);
        //根据条件获取集合
        List<ClassBindInfoVO> classBindInfoVOList = this.baseMapper.getBingInfoPage(map);
        for (ClassBindInfoVO classBindInfoVO : classBindInfoVOList){
            //年级
            Long grade1 = classBindInfoVO.getGrade();
            classBindInfoVO.setGradeName(GradeNameEnum.getCnById(grade1));
            //教师职位
            Long teacherPosition = classBindInfoVO.getTeacherPosition();
            classBindInfoVO.setTeacherPositionName(TeacherPositionEnum.getCnById(teacherPosition));
            //科目
            Long subject1 = classBindInfoVO.getSubject();
            classBindInfoVO.setSubjectName(ScoreNameEnum.getCnById(subject1));
        }
        //获取总条数
        Integer bindInfoCount = this.baseMapper.getBindInfoCount(map);
        PageUtils pageUtils = new PageUtils(classBindInfoVOList,bindInfoCount,size,index);
        return pageUtils;
    }

    @Override
    public Integer bindStuTea(ClassBindTeacherDTO classBindTeacherDTO) {
        //获取教师表id
        Long teacherName = classBindTeacherDTO.getTeacherName();
        //获取年级id
        Long gradeName = classBindTeacherDTO.getGradeName();
        //获取班级
        Integer classNumber = classBindTeacherDTO.getClassNumber();
        //根据年级id、班级查询班级表id
        Long id = classTableService.getIdByGradeAndClNum(gradeName, classNumber);

        ClassStudentBindEntity classStudentBindEntity = new ClassStudentBindEntity();
        classStudentBindEntity.setClassTableId(id);
        classStudentBindEntity.setTeacherTableId(teacherName);
        int insert = this.baseMapper.insert(classStudentBindEntity);
        return insert;
    }
}
