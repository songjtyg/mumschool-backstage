package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.common.CommonTransform;
import com.sjt.cai.mumschool.entity.bo.ExamAnswerBO;
import com.sjt.cai.mumschool.entity.po.ExamAnswerPO;
import com.sjt.cai.mumschool.dao.ExamAnswerMapper;
import com.sjt.cai.mumschool.biz.service.ExamAnswerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
    public ExamAnswerBO selectOneBO(Integer examId, Integer questionId) {
        ExamAnswerPO po = selectOne(new EntityWrapper<ExamAnswerPO>().where("exam_id = {0} and question_id = {1}", examId, questionId));
        if (po != null)
            return CommonTransform.convertToDTO(po,ExamAnswerBO.class);
        else return null;
    }
}
