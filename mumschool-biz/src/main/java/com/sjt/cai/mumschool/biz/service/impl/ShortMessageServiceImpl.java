package com.sjt.cai.mumschool.biz.service.impl;

import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.common.SmsClient;
import com.sjt.cai.mumschool.entity.po.ShortMessagePO;
import com.sjt.cai.mumschool.dao.ShortMessageMapper;
import com.sjt.cai.mumschool.biz.service.ShortMessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-29
 */
@Service
public class ShortMessageServiceImpl extends ServiceImpl<ShortMessageMapper, ShortMessagePO> implements ShortMessageService {
    private String selectRecentVerifyCodeByPhone(String phone){
        ShortMessagePO shortMessagePO = baseMapper.selectRecentVerifyCodeByPhone(phone);
        return (shortMessagePO != null) ? shortMessagePO.getContent():null;
    }
    @Override
    public Boolean ifValidVerifyCode(String phone, String verifyCode){
         String dbContent = selectRecentVerifyCodeByPhone(phone);
        return Optional.ofNullable(dbContent).orElse("").equalsIgnoreCase(verifyCode);
    }
    @Override
    public JsonResult<Boolean> sendSmsVerifyCode(String phone) {
        String verifyCode = String.valueOf((int)(Math.random()*(9000))+1000);
        Result<SmsSingleSend> smsResult = SmsClient.getInstance().sendSms(phone,verifyCode);
        if (smsResult.isSucc()){
            ShortMessagePO shortMessagePO = new ShortMessagePO();
            shortMessagePO.setPhone(phone);
            shortMessagePO.setSmsType(1);
            shortMessagePO.setContent(verifyCode);
            shortMessagePO.setCreateTime(new Date());
            return JsonResult.success(insert(shortMessagePO),"发送验证码成功");
        }else{
            return JsonResult.faultMessage(smsResult.getDetail());
        }
    }

}
