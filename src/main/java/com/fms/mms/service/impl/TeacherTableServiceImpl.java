package com.fms.mms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fms.mms.vo.TeacherInfoVO;
import org.springframework.stereotype.Service;
import com.fms.mms.dao.TeacherTableDao;
import com.fms.mms.entity.TeacherTableEntity;
import com.fms.mms.service.TeacherTableService;

import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.List;


@Service("teacherTableService")
public class TeacherTableServiceImpl extends ServiceImpl<TeacherTableDao, TeacherTableEntity> implements TeacherTableService {

    @Override
    public List<TeacherInfoVO> getTeaBySub(Long subject) {
        QueryWrapper<TeacherTableEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("subject",subject);
        List<TeacherTableEntity> teacherTableEntities = this.baseMapper.selectList(wrapper);
        List<TeacherInfoVO> teacherInfoVOList = new ArrayList<>();
        for (TeacherTableEntity tableEntity : teacherTableEntities){
            Long id = tableEntity.getId();
            String teacherName = tableEntity.getTeacherName();
            TeacherInfoVO teacherInfoVO = new TeacherInfoVO();
            teacherInfoVO.setValue(id);
            teacherInfoVO.setLabel(teacherName);
            teacherInfoVOList.add(teacherInfoVO);
        }
        return teacherInfoVOList;
    }
}
