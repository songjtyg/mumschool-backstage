package com.sjt.cai.mumschool.web.controler;

import com.sjt.cai.mumschool.biz.service.PhoneIdentifyService;
import com.sjt.cai.mumschool.biz.service.WeixinQrService;
import com.sjt.cai.mumschool.biz.service.WeixinUserService;
import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.entity.dto.LoginDto;
import com.sjt.cai.mumschool.entity.dto.RegisterDto;
import com.sjt.cai.mumschool.entity.dto.ResetDto;
import com.sjt.cai.mumschool.entity.po.WeixinQr;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
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


    @PostMapping(value="/register")
    public JsonResult register(@RequestBody RegisterDto registerDto, HttpSession session){
        WeixinUserPO weixinUserPO = weixinUserService.loadByPhone(registerDto.getPhone());
        if (weixinUserPO != null) {
            session.setAttribute("user", weixinUserPO);
            session.setAttribute("logined", true);

            return JsonResult.errorsInfo("1","手机号已经注册");
        }else {
            weixinUserPO = (WeixinUserPO)session.getAttribute("user");
            if (weixinUserPO != null){
                weixinUserPO.setUserName(registerDto.getUserName());
                weixinUserPO.setPassword(registerDto.getPassword());
                weixinUserPO.setHospital(registerDto.getHospital());
                weixinUserPO.setDepartment(registerDto.getDepartment());
                weixinUserPO.setPhone(registerDto.getPhone());

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
    public JsonResult login(@RequestBody LoginDto loginDto, HttpSession session){
        WeixinUserPO weixinUserPO = weixinUserService.loadByloginWordAndPassword(loginDto.getLoginWord(),loginDto.getPassword());
        if (weixinUserPO != null) {
            System.out.println(session.getAttribute("user"));
            session.setAttribute("logined", true);
            return JsonResult.success(null,"登录成功");
        }else {
            session.setAttribute("logined", false);
            return JsonResult.errorsInfo("1","登录失败，请检查用户名和密码！");
        }
    }

    @PostMapping(value="resetPassword")
    public JsonResult resetPassword(@RequestBody ResetDto resetDto, HttpSession session){
        WeixinUserPO weixinUserPO = weixinUserService.loadByloginWord(resetDto.getLoginWord());
        if (weixinUserPO == null) {
            return JsonResult.errorsInfo("1", "无此用户，请检查登录名/手机号！");
        }
        String phone = weixinUserPO.getPhone();
        if (phone == null) {
            return JsonResult.errorsInfo("1", "用户无注册手机号，请检查登录名/手机号！");
        }
        if (resetDto.getIdentifyingCode()!= phoneIdentifyService.selectByPhone(phone)){
            return JsonResult.errorsInfo("1", "验证码不正确或已过期，请重新发送验证码！");
        }
        weixinUserPO.setPassword(resetDto.getPassword());
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
        weixinUserService.updateById(u);//?add
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
            weixinUserService.updateById(u);//?add
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
            WeixinUserPO u = weixinUserService.loadByOpenid(openid);
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
