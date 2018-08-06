package com.sjt.cai.mumschool.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.dto.NextQuestionDTO;
import com.sjt.cai.mumschool.entity.po.QuestionPO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-24
 */
public interface QuestionMapper extends BaseMapper<QuestionPO> {

    QuestionBO selectNext(NextQuestionDTO nextQuestionDTO);

    QuestionBO selectFirst(Integer examId);
}
