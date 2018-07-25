package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.entity.po.QuestionBankPO;
import com.sjt.cai.mumschool.dao.QuestionBankMapper;
import com.sjt.cai.mumschool.biz.service.QuestionBankService;
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
public class QuestionBankServiceImpl extends ServiceImpl<QuestionBankMapper, QuestionBankPO> implements QuestionBankService {
    @Override
    public Boolean ifExistByIdAndQrVerifyCode(Integer questionBankId,String qrVerifyCode){
        return (null != selectOne(new EntityWrapper<QuestionBankPO>().where("id = {0} and qr_verify_code = {1}",questionBankId,qrVerifyCode)));
    }
}
