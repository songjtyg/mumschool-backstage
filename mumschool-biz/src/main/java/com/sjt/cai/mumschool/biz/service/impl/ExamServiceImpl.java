package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjt.cai.mumschool.biz.service.ExamAnswerService;
import com.sjt.cai.mumschool.biz.service.ExamService;
import com.sjt.cai.mumschool.common.CommonTransform;
import com.sjt.cai.mumschool.dao.ExamMapper;
import com.sjt.cai.mumschool.entity.bo.ExamBO;
import com.sjt.cai.mumschool.entity.po.ExamAnswerPO;
import com.sjt.cai.mumschool.entity.po.ExamPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, ExamPO> implements ExamService {
    @Autowired
    private ExamAnswerService examAnswerService;

    @Override
    public Integer calculateScore(Integer examId) {
        List<ExamAnswerPO> examAnswerPOs = examAnswerService.selectList(new EntityWrapper<ExamAnswerPO>().where("exam_id = {0}",examId));
        //列表循环计算
        Integer totalScore = Optional.ofNullable(examAnswerPOs).orElse(Collections.emptyList()).stream().filter(i->i.getCorrect())
                .mapToInt(i->i.getScore()).sum();
        ExamPO examPO = selectById(examId);
        examPO.setScore(totalScore);
        updateById(examPO);
        return totalScore;
    }

    @Override
    public ExamBO selectBoById(Integer examId) {
        ExamPO examPO = selectById(examId);
        return CommonTransform.convertToDTO(examPO,ExamBO.class);
    }
}
