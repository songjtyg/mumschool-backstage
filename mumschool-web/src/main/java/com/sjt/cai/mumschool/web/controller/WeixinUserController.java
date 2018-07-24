package com.sjt.cai.mumschool.web.controller;

import com.sjt.cai.mumschool.biz.service.PhoneIdentifyService;
import com.sjt.cai.mumschool.biz.service.WeixinQrService;
import com.sjt.cai.mumschool.biz.service.WeixinUserService;
import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.entity.dto.LoginDTO;
import com.sjt.cai.mumschool.entity.dto.RegisterDTO;
import com.sjt.cai.mumschool.entity.dto.ResetDTO;
import com.sjt.cai.mumschool.entity.po.WeixinQrPO;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import com.sjt.cai.mumschool.wechat.dto.WeChatUser;
import com.sjt.cai.mumschool.wechat.service.WeChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping("/weixinUser")
public class WeixinUserController {
    @Autowired
    WeixinUserService weixinUserService;
    @Autowired
    private WeixinQrService weixinQrService;
    @Autowired
    private PhoneIdentifyService phoneIdentifyService;
    @Autowired
    private WeChatUserService weChatUserService;

    @RequestMapping(value="/ifOpenid")
    public Boolean ifOpenid(HttpSession httpSession){
        System.out.println(httpSession.getId());
        WeixinUserPO po = (WeixinUserPO)httpSession.getAttribute("user");
        return (po != null && po.getOpenid() != null);
    }
    @RequestMapping(value="/setOpenid/{code}")
    public Boolean setOpenid(@PathVariable String code,HttpSession httpSession) throws IOException {
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
        httpSession.setAttribute("user",weixinUserPO);
        return true;
    }

    @PostMapping(value="/register")
    public JsonResult register(@RequestBody RegisterDTO registerDTO, HttpSession session){
        System.out.println("----------------------------");
        //去掉电话中的空格
        registerDTO.setPhone(registerDTO.getPhone().replaceAll("\\s*", ""));
        WeixinUserPO weixinUserPO = weixinUserService.loadByPhone(registerDTO.getPhone());
        if (weixinUserPO != null) {
            session.setAttribute("user", weixinUserPO);
            session.setAttribute("logined", true);

            return JsonResult.errorsInfo("1","手机号已经注册");
        }else {
            weixinUserPO = (WeixinUserPO)session.getAttribute("user");
            if (weixinUserPO != null){
                weixinUserPO.setUserName(registerDTO.getUserName());
                weixinUserPO.setPassword(registerDTO.getPassword());
                weixinUserPO.setHospital(registerDTO.getHospital());
                weixinUserPO.setDepartment(registerDTO.getDepartment());
                weixinUserPO.setPhone(registerDTO.getPhone());

                weixinUserService.updateById(weixinUserPO);
                session.setAttribute("user", weixinUserPO);
                session.setAttribute("logined", true);
                return JsonResult.success(null,"注册成功");
            }else{
                session.setAttribute("user", null);
                session.setAttribute("logined", false);
                return JsonResult.errorsInfo("1","请使用微信客户端自首页进入注册！");
            }
        }
    }

    @PostMapping(value="login")
    public JsonResult login(@RequestBody LoginDTO loginDTO, HttpSession session){
        WeixinUserPO sessionWeixinUserPO = (WeixinUserPO)session.getAttribute("user");
        if (sessionWeixinUserPO == null){
            return JsonResult.errorsInfo("1", "请在微信端打开");
        }
        WeixinUserPO weixinUserPO = weixinUserService.loadByloginWordAndPassword(loginDTO.getLoginWord(), loginDTO.getPassword());
        if (weixinUserPO == null) {
            session.setAttribute("logined", false);
            return JsonResult.errorsInfo("1","登录失败，登录名和密码错误！");
        }
        if (!weixinUserPO.getOpenid().equalsIgnoreCase(sessionWeixinUserPO.getOpenid())) {
            session.setAttribute("logined", false);
            return JsonResult.success(1, "登录用户和当前微信用户不一致");
        }
        session.setAttribute("logined", true);
        return JsonResult.success(1, "登录成功");

    }

    @PostMapping(value="resetPassword")
    public JsonResult resetPassword(@RequestBody ResetDTO resetDTO, HttpSession session){
        WeixinUserPO weixinUserPO = weixinUserService.loadByloginWord(resetDTO.getLoginWord());
        if (weixinUserPO == null) {
            return JsonResult.errorsInfo("1", "无此用户，请检查登录名/手机号！");
        }
        String phone = weixinUserPO.getPhone();
        if (phone == null) {
            return JsonResult.errorsInfo("1", "用户无注册手机号，请检查登录名/手机号！");
        }
        if (resetDTO.getIdentifyingCode()!= phoneIdentifyService.selectByPhone(phone)){
            return JsonResult.errorsInfo("1", "验证码不正确或已过期，请重新发送验证码！");
        }
        weixinUserPO.setPassword(resetDTO.getPassword());
        weixinUserService.updateById(weixinUserPO);
        session.setAttribute("user",weixinUserPO);
        session.setAttribute("logined", true);
        return JsonResult.success(null,"修改密码成功");
    }

    @PostMapping(value="bindNewUser")
    public String bindNewUser(String userName,String password,HttpSession session,HttpServletResponse resp) throws IOException {
        WeixinUserPO u0 = (WeixinUserPO)session.getAttribute("user");
        if(u0 == null) resp.sendRedirect("/user/loadByloginWordAndPassword");
        WeixinUserPO u = weixinUserService.selectById(u0.getId());
        u.setBind(1);
        u.setUserName(userName);
        u.setPassword(password);
        weixinUserService.updateById(u);//?insert
        return "redirect:/user/list";
    }

    @PostMapping(value="bindExistUser")
    public String bindExistUser(String userName,String password,Model model,HttpSession session,HttpServletResponse resp) throws IOException {
        WeixinUserPO u0 = (WeixinUserPO)session.getAttribute("user");
        if(u0 == null) resp.sendRedirect("/user/loadByloginWordAndPassword");
        WeixinUserPO u = weixinUserService.loadByUserName(userName);
        if (u.getPassword().equals(password)) {
            u.setBind(1);
            u.setHeadimgurl(u.getHeadimgurl());
            u.setSex(u.getSex());
            u.setStatus(1);
            u.setNickname(u.getNickname());
            u.setOpenid(u.getOpenid());
            u.setUserName(userName);
            u.setPassword(password);
            weixinUserService.updateById(u);//?insert
            weixinUserService.deleteById(u0.getId());
            session.setAttribute("user", u);
        }else{
            throw new RuntimeException("原始密码输入错误");
        }
        return "redirect:/user/bindExistUser";
    }
    @GetMapping(value="/forgetPwd")
    public String forgetPassword(HttpSession session,Model model){
        WeixinUserPO weixinUserPO = (WeixinUserPO)session.getAttribute("user");
        if(weixinUserPO.getBind() == 0){
            throw new RuntimeException("请绑定用户后才能在微信中修改密码！");
        }
        model.addAttribute("user",weixinUserPO);
        return "user/forgetPwd";
    }
    @PostMapping(value="/forgetPwd")
    public String forgetPassword(HttpSession session,String password){
        WeixinUserPO weixinUserPO = (WeixinUserPO)session.getAttribute("user");
        if(weixinUserPO.getBind() == 0){
            throw new RuntimeException("请绑定用户后才能在微信中修改密码！");
        }
        weixinUserPO.setPassword(password);
        weixinUserService.updateById(weixinUserPO);
        return "user/list";
    }
    @GetMapping(value="/qrlogin")
    public String qrlogin(Model model){
        WeixinQrPO wq = generateLoginQr();
        weixinQrService.insert(wq);
        model.addAttribute("wq",wq);
        return "user/qrlogin";
    }
    @RequestMapping(value="checkqrlogin")
    public void checkqrlogin(int snum,HttpSession session,HttpServletResponse resp) throws IOException {
        WeixinQrPO wq = weixinQrService.selectBySnum(snum);
        resp.setContentType("text/txt");
        if(wq.getQrData()!=null && wq.getStatus() == 1){
            String openid = wq.getQrData();
            WeixinUserPO u = weixinUserService.loadByOpenid(openid);
            session.setAttribute("user",u);
            resp.getWriter().println(1);
        }else{
            resp.getWriter().println(0);
        }
    }
    private WeixinQrPO generateLoginQr(){
        WeixinQrPO wq = new WeixinQrPO();
        wq.setName("扫码登陆");
        wq.setMsg("扫码登陆");
        wq.setSnum(new Random().nextInt()+(WeixinQrPO.MAX_BASE_SNUM+1));
        wq.setStatus(0);
        wq.setType(WeixinQrPO.TEMP_LOGIN);
        return wq;
    }

}
