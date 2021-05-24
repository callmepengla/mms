package com.fms.mms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.fms.mms.dto.StudentFilesDTO;
import com.fms.mms.utils.ConvertUtils;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fms.mms.dao.StudentFilesDao;
import com.fms.mms.entity.StudentFilesEntity;
import com.fms.mms.service.StudentFilesService;


@Service("studentFilesService")
public class StudentFilesServiceImpl extends ServiceImpl<StudentFilesDao, StudentFilesEntity> implements StudentFilesService {

    @Override
    public PageUtils getStudentFilesPage(Map<String, Object> params) {
        //获取数据
        String page = (String) params.get("page");
        String limit = (String) params.get("limit");
        String scoreSchoolId = (String) params.get("scoreSchoolId");//学号
        String studentName = (String) params.get("studentName");//学生姓名
        // 获取起始长度
        Integer size = Integer.valueOf(limit);
        Integer index = Integer.valueOf(page);
        if (index > 0) {
            index = (index - 1) * size;
        }
        // 条件查询产品VO数组以及总条数
        HashMap<String, Object> map = new HashMap<>(7);
        map.put("scoreSchoolId", scoreSchoolId);
        map.put("studentName", studentName);
        map.put("size", size);
        map.put("index", index);
        //根据条件获取集合
        List<StudentFilesEntity> entityList = this.baseMapper.getPage(map);
        //获取总条数
        int size1 = this.baseMapper.getCount(map);
        PageUtils pageUtils = new PageUtils(entityList,size1,size,index);
        return pageUtils;
    }

    @Override
    public R addStudentFiles(StudentFilesDTO studentFilesDTO) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
        String format1 = format.format(date);
        int i = (int) (Math.random() * 10000);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(format1);
        stringBuffer.append("567");
        stringBuffer.append(i);
        studentFilesDTO.setScoreSchoolid(stringBuffer.toString());
        StudentFilesEntity studentFilesEntity = ConvertUtils.sourceToTarget(studentFilesDTO, StudentFilesEntity.class);
        int insert = this.baseMapper.insert(studentFilesEntity);
        if (insert > 0){
            return R.ok();
        }else {
            return R.error().data("messgae","添加失败！");
        }
    }

    @Override
    public Boolean selectStudent(String scoreSchoolid) {
        QueryWrapper<StudentFilesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("score_schoolid",scoreSchoolid);
        Integer integer = this.baseMapper.selectCount(wrapper);
        if (integer > 0){
            return true;
        }
        return false;
    }

    @Override
    public PageUtils getFilesPage(Map<String, Object> params) {
        //获取数据
        String page = (String) params.get("page");
        String limit = (String) params.get("limit");
        // 获取起始长度
        Integer size = Integer.valueOf(limit);
        Integer index = Integer.valueOf(page);
        if (index > 0) {
            index = (index - 1) * size;
        }
        // 条件查询产品VO数组以及总条数
        HashMap<String, Object> map = new HashMap<>(7);
        map.put("size", size);
        map.put("index", index);
        //获取分页集合
        List<StudentFilesEntity> filesEntityList = this.baseMapper.getFilePage(map);
        //获取总条数
        int size1 = this.baseMapper.getTotal();
        PageUtils pageUtils = new PageUtils(filesEntityList,size1,size,index);
        return pageUtils;
    }

}
