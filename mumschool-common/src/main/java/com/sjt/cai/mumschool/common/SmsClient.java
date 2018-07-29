package com.sjt.cai.mumschool.common;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;

import java.util.Map;

/**
 * 单例模式改造
 * @author songjiangtao
 */
public class SmsClient extends YunpianClient{

    private static class SingletonHolder {

        private static final SmsClient INSTANCE = new SmsClient("f6336aa7b4fb1c4a60b00e05abd6d99f");

    }

    private SmsClient (String apikey){
        super(apikey);
        init();
    }
    public static final SmsClient getInstance() {

        return SingletonHolder.INSTANCE;

    }
    public Result<SmsSingleSend> sendSms(String phone,String verifyCode) {
        //发送短信API
        Map<String, String> param = newParam(2);
        param.put(YunpianClient.MOBILE, phone);
        param.put(YunpianClient.TEXT, "【希元文化】验证号"+verifyCode);
        Result<SmsSingleSend> r = sms().single_send(param);
        //获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable()
        //账户:clnt.user().* 签名:clnt.sign().* 模版:clnt.tpl().* 短信:clnt.sms().* 语音:clnt.voice().* 流量:clnt.flow().* 隐私通话:clnt.call().*
        return r;
    }
}
