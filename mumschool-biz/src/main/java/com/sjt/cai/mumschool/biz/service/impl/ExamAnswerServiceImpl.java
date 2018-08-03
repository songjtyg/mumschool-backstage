package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.common.CommonTransform;
import com.sjt.cai.mumschool.entity.bo.ExamAnswerBO;
import com.sjt.cai.mumschool.entity.po.ExamAnswerPO;
import com.sjt.cai.mumschool.dao.ExamAnswerMapper;
import com.sjt.cai.mumschool.biz.service.ExamAnswerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
public class ExamAnswerServiceImpl extends ServiceImpl<ExamAnswerMapper, ExamAnswerPO> implements ExamAnswerService {


    @Override
    public ExamAnswerBO selectBOByExamAndQuestion(Integer examId, Integer questionId) {
        ExamAnswerPO po = baseMapper.selectOneByExamAndQuestion(examId, questionId);
        ExamAnswerBO bo = new ExamAnswerBO();
        if (po != null) {
            BeanUtils.copyProperties(po, bo, "choices");
            if (StringUtils.isEmpty(po.getChoices())) {
                bo.setChoices(java.util.Arrays.asList(po.getChoices().split(",")));
            }
        }
        return bo;

    }
}
