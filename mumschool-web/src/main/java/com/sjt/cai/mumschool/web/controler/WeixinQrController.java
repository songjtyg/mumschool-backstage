package com.sjt.cai.mumschool.web.controller;


import com.sjt.cai.mumschool.biz.service.WeixinQrService;
import com.sjt.cai.mumschool.entity.po.WeixinQr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-25
 */
@Controller
@RequestMapping("/mumschool/weixinQr")
public class WeixinQrController {
    @Autowired
    private WeixinQrService weixinQrService;

    @RequestMapping(value="qrlogin")
    public String qrlogin(Model model){
        WeixinQr wq = generateLoginQr();
        weixinQrService.add(wq);
        model.addAttribute("wq",wq);
        return "user/qrlogin";
    }
    private WeixinQr generateLoginQr(){
        WeixinQr wq = new WeixinQr();
        wq.setName("扫码登录");
        wq.setMsg("扫码登陆");
        wq.setSnum(new Random().nextInt()+(WeixinQr.MAX_BASE_SNUM+1));
        wq.setStatus(0);
        wq.setType(WeixinQr.TEMP_LOGIN);
        return wq;
    }
}

