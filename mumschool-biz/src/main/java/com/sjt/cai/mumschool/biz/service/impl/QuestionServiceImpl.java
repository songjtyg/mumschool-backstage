package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.biz.service.ExamAnswerService;
import com.sjt.cai.mumschool.biz.service.ExamService;
import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.dto.NextQuestionDTO;
import com.sjt.cai.mumschool.entity.po.ExamAnswerPO;
import com.sjt.cai.mumschool.entity.po.QuestionPO;
import com.sjt.cai.mumschool.dao.QuestionMapper;
import com.sjt.cai.mumschool.biz.service.QuestionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, QuestionPO> implements QuestionService {

    @Autowired
    private ExamAnswerService examAnswerService;

    @Override
    public QuestionBO selectNext(NextQuestionDTO nextQuestionDTO) {
        QuestionBO questionBO = baseMapper.selectNext(nextQuestionDTO);
        if (questionBO != null) {
            ExamAnswerPO examAnswerPO = examAnswerService.selectOne(
                    new EntityWrapper<ExamAnswerPO>().where("exam_id = {0} and question_id = {1}", nextQuestionDTO.getExamId(), questionBO.getId()));
            questionBO.setExamAnswerPO(examAnswerPO);
        }
        return questionBO;
    }

    @Override
    public QuestionBO selectFirst(Integer examId) {
        QuestionBO questionBO = baseMapper.selectFirst(examId);
        if (questionBO != null) {
            ExamAnswerPO examAnswerPO = examAnswerService.selectOne(
                    new EntityWrapper<ExamAnswerPO>().where("exam_id = {0} and question_id = {1}", examId,questionBO.getId()));
            questionBO.setExamAnswerPO(examAnswerPO);
        }
        return questionBO;
    }
}
