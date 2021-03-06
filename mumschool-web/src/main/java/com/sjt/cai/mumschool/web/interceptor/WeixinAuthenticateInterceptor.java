package com.sjt.cai.mumschool.web.interceptor;

import com.sjt.cai.mumschool.biz.service.WeixinUserService;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import com.sjt.cai.mumschool.wechat.dto.WeChatUser;
import com.sjt.cai.mumschool.wechat.service.WeChatUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeixinAuthenticateInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateInterceptor.class);

    // 需要拦截的静态页的URL
    private static final String[] EXCLUDED_URL = {"/first", "/login", "/scanToExam"};

    @Value("${other.Access-Control-Allow-Origin-url}")
    private String ACCESS_CONTROL_ALLOW_ORIGIN_URL;

    @Autowired
    private WeChatUserService weChatUserService;
    @Autowired
    private WeixinUserService weixinUserService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        boolean flag = false;
//        String requestedUrl = request.getRequestURI().toString();
//        // 检查请求的URL是否在过滤列表里
//        for (String url : EXCLUDED_URL) {
//            if (requestedUrl.contains(url)) {
//                flag = true;
//                request.getRequestDispatcher("/").forward(request, response);
//                return false;
//            }
//        }

        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", ACCESS_CONTROL_ALLOW_ORIGIN_URL);
//        response.setHeader("Access-Control-Allow-Origin", "*");
        if (1==1) return true;
        WeixinUserPO tu = (WeixinUserPO)request.getSession().getAttribute("weixinUserPO");
//        if (tu == null) {
//            return false;
//        }else if ( 1==1 )
//            return true;
        //todo 以下还需要不？
        if(tu==null){
            String agent = request.getHeader("User-Agent");
            if(agent != null && agent .toLowerCase().indexOf("micromessenger")>=0){
                String code = request.getParameter("code");
                String  state = request.getParameter("state");
                if(code != null && state != null && state.equals("1")){
                    //通过Code获取openid来进行授权
                    String openid = weChatUserService.queryOpenidByCode(code);
                    WeixinUserPO weixinUserPO = weixinUserService.loadByOpenid(openid);
                    if(weixinUserPO == null){
                        WeChatUser weChatUser = weChatUserService.queryByOpenid(openid);
                        weixinUserPO.setOpenid(weChatUser.getOpenid());//todo  一些系列吧？？？
                        weixinUserService.insert(weixinUserPO);
                    }else{
                        if(weixinUserPO.getStatus()==0){
                            weixinUserPO.setStatus(1);
                            weixinUserService.updateById(weixinUserPO);
                        }
                    }
                    request.getSession().setAttribute("user",weixinUserPO);
                    return true;
                }else{
//                    String path = request.getRequestURL().toString();
//                    String query = request.getQueryString();
//                    if (query!=null){
//                        path = path +"?"+query;
//                    }
//                    String uri = WeChatFinalValue.AUTH_URL;
//                    //path="http://www.baidu.com";
//                    uri = uri.replace("APPID", WeChatContext.getInstance().getAppId())
//                            .replace("REDIRECT_URI", URLEncoder.encode(path,"UTF-8"))
//                            .replace("SCOPE","snsapi_base")
//                            .replace("STATE","1");
//                    //response.sendRedirect(uri);
//
//                    response.setCharacterEncoding("UTF-8");
//                    response.setContentType("application/json; charset=utf-8");
//                    PrintWriter out = response.getWriter();
//                    out.print("{'A':'BB'}");
//                    return false;
                    return true;
                }
            }
        }
        return true;
    }

    private void addHeader(HttpServletRequest request, HttpServletResponse response) {
        if (request.getHeader(HttpHeaders.ORIGIN) != null) {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            response.addHeader("Access-Control-Max-Age", "3600");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
//        UserContext.remove();
    }
}
