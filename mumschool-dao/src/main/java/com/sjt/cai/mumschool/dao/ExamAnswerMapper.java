package com.sjt.cai.mumschool.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjt.cai.mumschool.entity.po.ExamAnswerPO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-24
 */
public interface ExamAnswerMapper extends BaseMapper<ExamAnswerPO> {

    ExamAnswerPO selectOneByExamAndQuestion(@Param("examId") Integer examId, @Param("questionId") Integer questionId);
}
