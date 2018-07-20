package com.sjt.cai.mumschool.web.controler;

import com.sjt.cai.mumschool.biz.service.WeixinMessageService;
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
import java.util.Arrays;
import java.util.Map;

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
