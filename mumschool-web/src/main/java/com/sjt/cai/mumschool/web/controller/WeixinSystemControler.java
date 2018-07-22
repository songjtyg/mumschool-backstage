package com.sjt.cai.mumschool.web.controller;

import com.sjt.cai.mumschool.biz.service.WeixinMessageService;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.dto.SignPackage;
import com.sjt.cai.mumschool.wechat.dto.WeChatContext;
import com.sjt.cai.mumschool.wechat.util.WeChatMessageKit;
import com.sjt.cai.mumschool.wechat.util.WeChatSecurityKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

//@RestController
@Controller
@RequestMapping("/mumschool/sys")
public class WeixinSystemControler {
    @Autowired
    private WeixinMessageService weixinMessageService;
    private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    /**
     * token验证
     *
     */
    @RequestMapping(value="/handler",method= RequestMethod.GET)
    public void handlerGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        String[] arrs = {WeChatContext.getInstance().getToken(),nonce,timestamp};
        Arrays.sort(arrs);
        StringBuffer sb = new StringBuffer();
        for(String a:arrs) {
            sb.append(a);
        }
        String sha1 = WeChatSecurityKit.sha1(sb.toString());
//		System.out.println(sha1.equals(signature));
        if(sha1.equals(signature)) {
            resp.getWriter().println(echostr);
        }
    }
    /**
     * 计算sign
     *
     */
    @GetMapping(value="/getSignature")
    public @ResponseBody SignPackage getSignature(@RequestParam("pageUrl") String pageUrl) throws IOException {
        //利用UUID生成一个随机字符串
        SignPackage signPackage = new SignPackage();
        signPackage.setAppId(WeChatContext.getInstance().getAppId());
        signPackage.setNonceStr(UUID.randomUUID().toString().substring(25));
        signPackage.setTimestamp(new Timestamp(System.currentTimeMillis()).toString());

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("jsapi_ticket=");
        stringBuffer.append(WeChatContext.getInstance().getWeChatTicket().getTicket());
        stringBuffer.append("&noncestr=");
        stringBuffer.append(signPackage.getNonceStr());
        stringBuffer.append("&timestamp=");
        stringBuffer.append(signPackage.getTimestamp());
        stringBuffer.append("&url=");
        stringBuffer.append(pageUrl);
        String checkStr = stringBuffer.toString();
        String signature = WeChatSecurityKit.sha1(checkStr);

        signPackage.setSignature(signature);
        return signPackage;
    }
    /**
     * weChat消息接收
     * @param req
     * @param resp
     * @throws IOException
     */
    @PostMapping(value="/handler")
    public void handlerPost(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        req.setCharacterEncoding("utf-8");
        Map<String,String> msgMap = WeChatMessageKit.reqMsg2Map(req);
        System.out.println(msgMap);
        String respCon = weixinMessageService.handlerMsg(msgMap);
        resp.setContentType("application/xml;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println(respCon);
        if (respCon != null)
            resp.getWriter().write(respCon);

    }
    /*

     */
    @GetMapping(value="/index")
    public String handlerPost()throws IOException{
        return "index";
    }
}
