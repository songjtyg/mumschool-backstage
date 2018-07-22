package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.entity.po.QuestionChoicePO;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
public interface QuestionChoiceService extends IService<QuestionChoicePO> {

    List<QuestionChoicePO> selectByQuestionId(Integer questionId);
}
