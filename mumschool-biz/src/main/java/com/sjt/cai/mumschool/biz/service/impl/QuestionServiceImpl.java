package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjt.cai.mumschool.biz.service.ExamAnswerService;
import com.sjt.cai.mumschool.biz.service.ExamService;
import com.sjt.cai.mumschool.biz.service.QuestionService;
import com.sjt.cai.mumschool.dao.QuestionMapper;
import com.sjt.cai.mumschool.entity.bo.ExamAnswerBO;
import com.sjt.cai.mumschool.entity.bo.ExamBO;
import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.dto.NextQuestionDTO;
import com.sjt.cai.mumschool.entity.po.QuestionPO;
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
    private ExamService examService;

    @Autowired
    private ExamAnswerService examAnswerService;

    @Override
    public QuestionBO selectNext(NextQuestionDTO nextQuestionDTO) {
        QuestionBO questionBO = baseMapper.selectNext(nextQuestionDTO);
        Integer examId = nextQuestionDTO.getExamId();
        return setAnswer4Question(questionBO,examId);
    }

    @Override
    public QuestionBO selectFirst(Integer examId) {
        QuestionBO questionBO = baseMapper.selectFirst(examId);
        return setAnswer4Question(questionBO,examId);
    }
    private QuestionBO setAnswer4Question(QuestionBO questionBO,Integer examId){
        if (questionBO != null) {
            ExamBO examBO = examService.selectBoById(examId);
            questionBO.setExamBO(examBO);
            ExamAnswerBO examAnswerBO = examAnswerService.selectOneBO(examId, questionBO.getId());
            if (examAnswerBO == null){
                examAnswerBO = new ExamAnswerBO();
                examAnswerBO.setExamId(examId);
                examAnswerBO.setQuestionBankId(questionBO.getQuestionBankId());
                examAnswerBO.setQuestionId(questionBO.getId());
                examAnswerBO.setScore(questionBO.getScore());
            }
            questionBO.setExamAnswerBO(examAnswerBO);
        }
        return questionBO;
    }
}
