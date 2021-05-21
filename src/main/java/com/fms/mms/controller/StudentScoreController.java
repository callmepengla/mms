package com.fms.mms.controller;


import com.fms.mms.dto.StudentScoreDTO;
import com.fms.mms.entity.StudentScoreEntity;
import com.fms.mms.service.StudentScoreService;
import com.fms.mms.utils.ConvertUtils;
import com.fms.mms.utils.R;
import com.fms.mms.vo.ScoreNamesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("studentscore")
@CrossOrigin
public class StudentScoreController {
    @Autowired
    private StudentScoreService studentScoreService;

    /**
     * 根据条件查询学生成绩
     * @param params
     * @return
     */
    @GetMapping("scorepage")
    public R getScorePage(@RequestParam Map<String, Object> params){
        R r = studentScoreService.getScorePage(params);
        return r;
    }

    /**
     * 获取所有的课程名称
     * @return
     */
    @GetMapping("allscorenames")
    public R getAllScoreNames(){
        List<ScoreNamesVO> namesVOList = studentScoreService.getAllScoreNames();
        return R.ok().data("options",namesVOList);
    }

    /**
     * 根据id获取分数信息
     * @param id
     * @return
     */
    @GetMapping("getscores/{id}")
    public R getScoresById(@PathVariable Long id){
        StudentScoreEntity scoreEntity = studentScoreService.getById(id);
        return R.ok().data("files",scoreEntity);
    }

    /**
     * 修改分数信息
     * @param studentScoreDTO
     * @return
     */
    @PostMapping("updatascores")
    public R updataFilesData(@RequestBody StudentScoreDTO studentScoreDTO){
        StudentScoreEntity entity = ConvertUtils.sourceToTarget(studentScoreDTO, StudentScoreEntity.class);
        boolean flag = studentScoreService.updateById(entity);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 添加分数信息接口
     * @param studentScoreDTO
     * @return
     */
    @PostMapping("addscores")
    public R addStudentFiles(@RequestBody StudentScoreDTO studentScoreDTO){
        R r = studentScoreService.addScoreInfo(studentScoreDTO);
        return r;
    }

    /**
     * 根据id删除接口
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R removeStudentFiles(@PathVariable Long id){
        boolean flag = studentScoreService.removeById(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }
}
