package com.sjt.cai.mumschool.web.controler;

import com.sjt.cai.mumschool.biz.service.TUserService;
import com.sjt.cai.mumschool.biz.service.WeixinQrService;
import com.sjt.cai.mumschool.entity.po.TUserPO;
import com.sjt.cai.mumschool.entity.po.WeixinQr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

public class UserController {
    @Autowired
    TUserService tUserService;
    @Autowired
    private WeixinQrService weixinQrService;

    @PostMapping(value="login")
    public String login(String userName,String password,HttpSession session){
        TUserPO u = tUserService.login(userName,password);
        session.setAttribute("user",u);
        return "redirect:/user/list";
    }

    @PostMapping(value="bindNewUser")
    public String bindNewUser(String userName,String password,HttpSession session,HttpServletResponse resp) throws IOException {
        TUserPO u0 = (TUserPO)session.getAttribute("user");
        if(u0 == null) resp.sendRedirect("/user/login");
        TUserPO u = tUserService.selectById(u0.getId());
        u.setBind(1);
        u.setUsername(userName);
        u.setPassword(password);
        tUserService.updateById(u);//?add
        return "redirect:/user/list";
    }

    @PostMapping(value="bindExistUser")
    public String bindExistUser(String userName,String password,Model model,HttpSession session,HttpServletResponse resp) throws IOException {
        TUserPO u0 = (TUserPO)session.getAttribute("user");
        if(u0 == null) resp.sendRedirect("/user/login");
        TUserPO u = tUserService.loadByUserName(userName);
        if (u.getPassword().equals(password)) {
            u.setBind(1);
            u.setImgUrl(u.getImgUrl());
            u.setSex(u.getSex());
            u.setStatus(1);
            u.setNickname(u.getNickname());
            u.setOpenid(u.getOpenid());
            u.setUsername(userName);
            u.setPassword(password);
            tUserService.updateById(u);//?add
            tUserService.deleteById(u0.getId());
            session.setAttribute("user", u);
        }else{
            throw new RuntimeException("原始密码输入错误");
        }
        return "redirect:/user/bindExistUser";
    }
    @GetMapping(value="/forgetPwd")
    public String forgetPassword(HttpSession session,Model model){
        TUserPO tUserPO = (TUserPO)session.getAttribute("user");
        if(tUserPO.getBind() == 0){
            throw new RuntimeException("请绑定用户后才能在微信中修改密码！");
        }
        model.addAttribute("user",tUserPO);
        return "user/forgetPwd";
    }
    @PostMapping(value="/forgetPwd")
    public String forgetPassword(HttpSession session,String password){
        TUserPO tUserPO = (TUserPO)session.getAttribute("user");
        if(tUserPO.getBind() == 0){
            throw new RuntimeException("请绑定用户后才能在微信中修改密码！");
        }
        tUserPO.setPassword(password);
        tUserService.updateById(tUserPO);
        return "user/list";
    }
    @GetMapping(value="/qrlogin")
    public String qrlogin(Model model){
        WeixinQr wq = generateLoginQr();
        weixinQrService.add(wq);
        model.addAttribute("wq",wq);
        return "user/qrlogin";
    }
    @RequestMapping(value="checkqrlogin")
    public void checkqrlogin(int snum,HttpSession session,HttpServletResponse resp) throws IOException {
        WeixinQr wq = weixinQrService.loadBySnum(snum);
        resp.setContentType("text/txt");
        if(wq.getQrData()!=null && wq.getStatus() == 1){
            String openid = wq.getQrData();
            TUserPO u = tUserService.loadByOpenId(openid);
            session.setAttribute("user",u);
            resp.getWriter().println(1);
        }else{
            resp.getWriter().println(0);
        }
    }
    private WeixinQr generateLoginQr(){
        WeixinQr wq = new WeixinQr();
        wq.setName("扫码登陆");
        wq.setMsg("扫码登陆");
        wq.setSnum(new Random().nextInt()+(WeixinQr.MAX_BASE_SNUM+1));
        wq.setStatus(0);
        wq.setType(WeixinQr.TEMP_LOGIN);
        return wq;
    }

}
