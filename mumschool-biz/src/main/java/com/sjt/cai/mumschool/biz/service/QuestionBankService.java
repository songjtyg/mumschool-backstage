package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.entity.bo.QuestionBankBO;
import com.sjt.cai.mumschool.entity.po.QuestionBankPO;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
public interface QuestionBankService extends IService<QuestionBankPO> {

    Boolean ifExistByIdAndQrVerifyCode(Integer questionBankId, String qrVerifyCode);

    QuestionBankBO selectBoById(Integer questionBankId);
}
