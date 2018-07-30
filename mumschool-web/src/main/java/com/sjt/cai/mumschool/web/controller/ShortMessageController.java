package com.sjt.cai.mumschool.web.controller;


import com.sjt.cai.mumschool.biz.service.ShortMessageService;
import com.sjt.cai.mumschool.biz.service.WeixinUserService;
import com.sjt.cai.mumschool.common.CommonUtils;
import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-29
 */
@Api
@RestController
@RequestMapping("/shortMessage")
public class ShortMessageController {
    @Autowired
    private ShortMessageService shortMessageService;
    @Autowired
    private WeixinUserService weixinUserService;

    @PostMapping("/sendSmsVerifyCode/{phone}")
    public JsonResult<Boolean> sendSmsVerifyCode(@PathVariable("phone") String phone) {
        //去掉手机号中的空格
        phone = (phone.replaceAll("\\s*", ""));
        //验证手机号格式
        JsonResult<Boolean> result = CommonUtils.isPhone(phone);
        if (!result.isSuccess()){
            return result;
        }
        //发送短信
        return shortMessageService.sendSmsVerifyCode(phone);
    }

    @PostMapping("/sendSmsVerifyCode/byRegPhone")
    public JsonResult<Boolean> sendSmsVerifyCodeByRegPhone(HttpSession session) {
        WeixinUserPO sessionWeixinUserPO = (WeixinUserPO)session.getAttribute("user");
        if (sessionWeixinUserPO == null || sessionWeixinUserPO.getOpenid() == null){
            return JsonResult.errorsInfo("1", "请在微信端打开");
        }
        //发送短信
        return shortMessageService.sendSmsVerifyCode(sessionWeixinUserPO.getPhone());
    }
}

