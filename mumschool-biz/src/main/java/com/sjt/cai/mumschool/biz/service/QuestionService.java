package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.dto.NextQuestionDTO;
import com.sjt.cai.mumschool.entity.po.QuestionPO;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
public interface QuestionService extends IService<QuestionPO> {

    QuestionBO selectNext(NextQuestionDTO nextQuestionDTO);

    QuestionBO selectFirst(Integer examId);
}
