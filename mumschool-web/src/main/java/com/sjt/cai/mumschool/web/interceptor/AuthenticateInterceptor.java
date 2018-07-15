package com.sjt.cai.mumschool.web.interceptor;

import com.sjt.cai.mumschool.biz.service.WeixinUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 用户验证拦截器
 *
 * @author taka
 * @since 2018-3-5
 */
public class AuthenticateInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateInterceptor.class);

    @Autowired
    private WeixinUserService weixinUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //todo 14章 5分
//
//        String headers = request.getHeader("Access-Control-Request-Headers");
//        if (headers == null || Stream.of(headers.split(",")).noneMatch(header ->
//                header.equalsIgnoreCase("token"))) {
//            String token = request.getHeader("token");
//            if (StringUtils.isEmpty(token)) {
//                token = request.getParameter("token");
//            }
//            if (StringUtils.hasText(token)) {
//                Result<UserInfoResponseDTO> result = weixinUserService.getUserInfoByToken(token);
//                if (result.getCode() == 0) {
//                    UserInfoResponseDTO data = result.getObject();
//                    UserContext.setUser(CommonTransform.convertToEntity(data, UserInfoBO.class));
//                    Optional.of(data.getSmRoleInfos()).ifPresent(smRoleInfoDTOS -> UserContext.setRoles(smRoleInfoDTOS.stream().map(smRoleInfoDTO -> smRoleInfoDTO.getRoleId()).collect(Collectors.toList())));
//                    //获取管理方信息
//                    try {
//                        String manageInfoDec = request.getHeader("managerInfo");
//                        if(!StringUtils.isEmpty(manageInfoDec)){
//                            String manageInfo = URLDecoder.decode(manageInfoDec, "utf-8");
//                            //如果管理方信息不为空
//                            if( !StringUtils.isEmpty(manageInfo) && !"null".equals(manageInfo)){
//                                JSONArray array = JSONArray.fromObject(manageInfo);
//                                List<ManagementInfo> managementInfoList = (List<ManagementInfo>) JSONArray.toCollection(array, ManagementInfo.class);
//                                UserContext.setManagementInfo(managementInfoList);
//                            }else{
//                                UserContext.setManagementInfo(null);
//                            }
//                        }
//                    } catch (UnsupportedEncodingException e) {
//                        logger.error("管理方转换异常!", e);
//                    }
//                } else {
//                    addHeader(request, response);
//                    throw new AuthException("token is not valid");
//                }
//            } else {
//                addHeader(request, response);
//                throw new AuthException("token is null");
//            }
//        }
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        //response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", "http://mumschool-front.ngrok.xiaomiqiu.cn");
        response.setHeader("Access-Control-Allow-Credentials", "true");
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
