package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.entity.po.QuestionOptionPO;
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
public interface QuestionOptionService extends IService<QuestionOptionPO> {

    List<QuestionOptionPO> selectByQuestionId(Integer questionId);
}
