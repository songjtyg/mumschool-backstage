package com.sjt.cai.mumschool.web.controller;

import com.sjt.cai.mumschool.biz.service.WeixinMessageService;
import com.sjt.cai.mumschool.wechat.dto.WeChatContext;
import com.sjt.cai.mumschool.wechat.util.WeChatMessageKit;
import com.sjt.cai.mumschool.wechat.util.WeChatSecurityKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class PageControler {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
     /*

     */
    @GetMapping(value="/index")
    public String handlerPost()throws IOException{
        return "index";
    }
}
