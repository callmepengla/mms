package com.fms.mms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fms.mms.dto.StudentScoreDTO;
import com.fms.mms.enums.GradeNameEnum;
import com.fms.mms.enums.ScoreNameEnum;
import com.fms.mms.service.StudentFilesService;
import com.fms.mms.utils.ConvertUtils;
import com.fms.mms.utils.PageUtils;
import com.fms.mms.utils.R;
import com.fms.mms.vo.ScoreNamesVO;
import com.fms.mms.vo.StudentScoreVO;
import org.springframework.stereotype.Service;
import com.fms.mms.dao.StudentScoreDao;
import com.fms.mms.entity.StudentScoreEntity;
import com.fms.mms.service.StudentScoreService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("studentScoreService")
public class StudentScoreServiceImpl extends ServiceImpl<StudentScoreDao, StudentScoreEntity> implements StudentScoreService {
    @Resource
    private StudentFilesService studentFilesService;
    @Override
    public R getScorePage(Map<String, Object> params) {
        //获取数据
        String page = (String) params.get("page");
        String limit = (String) params.get("limit");
        String scoreSchoolId = (String) params.get("scoreSchoolId");//学号
        String studentName = (String) params.get("studentName");//学生姓名
        String gradeName = (String) params.get("gradeName");//年级
        String classNumber = (String) params.get("classNumber");//年级
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
        map.put("gradeName", gradeName);
        map.put("classNumber", classNumber);
        map.put("size", size);
        map.put("index", index);
        //根据条件获取集合
        List<StudentScoreEntity> scoreList = this.baseMapper.getScoreList(map);
        //获取总条数
        Integer count = this.baseMapper.getCount(map);
        int sum = scoreList.stream().mapToInt(StudentScoreEntity::getScoreSubject).sum();

        List<StudentScoreVO> scoreVOList = new ArrayList<>();
        for (StudentScoreEntity scoreEntity : scoreList){
            //课程id
            Long scoreNameId = scoreEntity.getScoreName();
            String scoreName = ScoreNameEnum.getCnById(scoreNameId);
            //年级id
            Long gradeNameId = scoreEntity.getGradeName();
            String gradeNames = GradeNameEnum.getCnById(gradeNameId);

            StudentScoreVO studentScoreVO = ConvertUtils.sourceToTarget(scoreEntity, StudentScoreVO.class);
            studentScoreVO.setScoreName(scoreName);
            studentScoreVO.setGradeName(gradeNames);
            scoreVOList.add(studentScoreVO);
        }
        PageUtils pageUtils = new PageUtils(scoreVOList,count,size,index);
        return R.ok().data("pageUtils",pageUtils).data("sum",sum);
    }

    @Override
    public List<ScoreNamesVO> getAllScoreNames() {
        List<ScoreNamesVO> namesVOList = new ArrayList<>();
        ScoreNameEnum[] values = ScoreNameEnum.values();
        for (ScoreNameEnum scoreNameEnum : values){
            ScoreNamesVO namesVO = new ScoreNamesVO();
            Long id = scoreNameEnum.id;
            String cn = scoreNameEnum.cn;
            namesVO.setValue(id);
            namesVO.setLabel(cn);
            namesVOList.add(namesVO);
        }
        return namesVOList;
    }

    @Override
    public R addScoreInfo(StudentScoreDTO studentScoreDTO) {
        String scoreSchoolid = studentScoreDTO.getScoreSchoolid();
        Boolean aBoolean = studentFilesService.selectStudent(scoreSchoolid);
        if (aBoolean){
            StudentScoreEntity entity = ConvertUtils.sourceToTarget(studentScoreDTO, StudentScoreEntity.class);
            int insert = this.baseMapper.insert(entity);
            if (insert > 0){
                return R.ok();
            }else {
                return R.error();
            }
        }
        return R.error().data("message","该学号不存在！添加成绩失败！");
    }
}
