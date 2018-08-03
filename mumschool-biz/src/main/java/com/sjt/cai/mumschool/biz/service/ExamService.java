package com.sjt.cai.mumschool.biz.service;

import com.baomidou.mybatisplus.service.IService;
import com.sjt.cai.mumschool.entity.bo.ExamBO;
import com.sjt.cai.mumschool.entity.po.ExamPO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
public interface ExamService extends IService<ExamPO> {

    Integer calculateScore(Integer examId);

    ExamBO selectBOById(Integer examId);
}
