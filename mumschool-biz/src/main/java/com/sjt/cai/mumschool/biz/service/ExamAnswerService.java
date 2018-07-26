package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.entity.bo.ExamAnswerBO;
import com.sjt.cai.mumschool.entity.po.ExamAnswerPO;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
public interface ExamAnswerService extends IService<ExamAnswerPO> {

    ExamAnswerBO selectOneBO(Integer examId, Integer questionId);
}
