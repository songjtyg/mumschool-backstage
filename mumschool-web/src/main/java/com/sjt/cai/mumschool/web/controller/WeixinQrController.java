package com.sjt.cai.mumschool.web.controller;


import com.sjt.cai.mumschool.biz.service.WeixinQrService;
import com.sjt.cai.mumschool.entity.po.WeixinQrPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-25
 */
@RestController
@RequestMapping("/weixinQr")
public class WeixinQrController {
    @Autowired
    private WeixinQrService weixinQrService;

    @RequestMapping(value="/generateQr")
    private WeixinQrPO generateQr(){
        WeixinQrPO weixinQrPO = new WeixinQrPO();
        weixinQrPO.setSnum((WeixinQrPO.MAX_BASE_SNUM+1) + new Random().nextInt(1000));
        weixinQrPO.setSnum(WeixinQrPO.EXAM);
        weixinQrPO.setType(WeixinQrPO.EXAM);
        weixinQrPO.setStatus(0);
        weixinQrPO.setName("扫码考试");
        weixinQrPO.setMsg("请狠戳我进入考试系统");
        weixinQrPO.setQrData("http://mumschool-front.ngrok.xiaomiqiu.cn/login");
//            weixinQrPO.setSnum(WeixinQrPO.SIGN_IN);
//            weixinQrPO.setType(WeixinQrPO.SIGN_IN);
//            weixinQrPO.setStatus(0);
//            weixinQrPO.setName("扫码签到");
//            weixinQrPO.setMsg("欢迎参加妈妈校园大讲堂!");
//            weixinQrPO.setQrData("http://mumschool-front.ngrok.xiaomiqiu.cn/login");
        return  weixinQrService.insertWeixinQr(weixinQrPO);
    }

}

