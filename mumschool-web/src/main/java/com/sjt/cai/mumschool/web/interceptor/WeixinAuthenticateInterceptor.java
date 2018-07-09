package com.sjt.cai.mumschool.web.interceptor;

import com.sjt.cai.mumschool.biz.service.TUserService;
import com.sjt.cai.mumschool.common.constant.WeixinFinalValue;
import com.sjt.cai.mumschool.common.dto.WUser;
import com.sjt.cai.mumschool.common.dto.WeixinContext;
import com.sjt.cai.mumschool.common.service.UserService;
import com.sjt.cai.mumschool.entity.po.TUserPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class WeixinAuthenticateInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateInterceptor.class);

    @Autowired
    private UserService userService;
    @Autowired
    private TUserService tUserService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TUserPO tu = (TUserPO)request.getSession().getAttribute("user");
        if(tu==null){
            String agent = request.getHeader("User-Agent");
            if(agent != null && agent .toLowerCase().indexOf("micromessenger")>=0){
                String code = request.getParameter("code");
                String  state = request.getParameter("state");
                if(code != null && state != null && state.equals("1")){
                    //通过Code获取openId来进行授权
                    String openId = userService.queryOpenIdByCode(code);
                    if (openId != null){
                        TUserPO tUserPO = tUserService.loadByOpenId(openId);
                        if(tUserPO == null){
                            WUser wUser = userService.queryByOpenId(openId);
                            tUserPO.setOpenid(wUser.getOpenId());//todo  一些系列吧？？？
                            tUserService.insert(tUserPO);
                        }else{
                            if(tUserPO.getStatus()==0){
                                tUserPO.setStatus(1);
                                tUserService.updateById(tUserPO);
                            }
                        }
                        request.getSession().setAttribute("user",tUserPO);
                    }
                }else{
                    String path = request.getRequestURL().toString();
                    String query = request.getQueryString();
                    if (query!=null){
                        path = path +"?"+query;
                    }
                    String uri = WeixinFinalValue.AUTH_URL;
                    uri = uri.replace("APPID", WeixinContext.getInstance().getAppId())
                            .replace("REDIRECT_URI", URLEncoder.encode(path,"UTF-8"))
                            .replace("SCOPE","snsapi_base")
                            .replace("STATE","1");
                    response.sendRedirect(uri);
                    return true;
                }
            }
        }
        return false;
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
