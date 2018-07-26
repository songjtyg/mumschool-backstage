package com.sjt.cai.mumschool.dao;

import com.sjt.cai.mumschool.entity.bo.QuestionOptionBO;
import com.sjt.cai.mumschool.entity.po.QuestionOptionPO;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-24
 */
public interface QuestionOptionMapper extends BaseMapper<QuestionOptionPO> {
    List<QuestionOptionBO> selectListByQuestionId(Integer questionId);
}
