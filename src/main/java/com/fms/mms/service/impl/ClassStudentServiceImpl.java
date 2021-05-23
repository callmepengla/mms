package com.fms.mms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fms.mms.dao.ClassStudentDao;
import com.fms.mms.entity.ClassStudentEntity;
import com.fms.mms.enums.GradeNameEnum;
import com.fms.mms.service.ClassStudentService;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.vo.ClassStudentVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("classStudentService")
public class ClassStudentServiceImpl extends ServiceImpl<ClassStudentDao, ClassStudentEntity> implements ClassStudentService {
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
}
