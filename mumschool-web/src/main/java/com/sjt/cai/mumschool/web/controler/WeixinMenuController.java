package com.sjt.cai.mumschool.web.controler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.biz.service.WeixinMenuService;
import com.sjt.cai.mumschool.biz.service.WeixinUserService;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import com.sjt.cai.mumschool.wechat.dto.WeChatMenuDto;
import com.sjt.cai.mumschool.wechat.dto.WeChatUser;
import com.sjt.cai.mumschool.wechat.service.WeChatMenuService;
import com.sjt.cai.mumschool.entity.po.WeixinMenuPO;
import com.sjt.cai.mumschool.wechat.service.WeChatUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-13
 */
@Api
@RestController
@RequestMapping("/weixinMenu")
public class WeixinMenuController {
    @Inject
    private WeixinMenuService weixinMenuService;
    @Inject
    private WeChatMenuService weChatMenuService;
    @Autowired
    private WeChatUserService weChatUserService;
    @Autowired
    private WeixinUserService weixinUserService;

    @RequestMapping(value="/ifOpenid")
    public Boolean ifOpenid(HttpSession httpSession){
        System.out.println(httpSession.getId());
        WeixinUserPO po = (WeixinUserPO)httpSession.getAttribute("weixinUserPO");
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
        httpSession.setAttribute("weixinUserPO",weixinUserPO);
        return true;
    }

    @GetMapping("/publishMenu")
    public void publishMenu() throws JsonProcessingException {
        List<WeixinMenuPO> wmps = weixinMenuService.listAll();
        List<WeChatMenuDto> wmds = weixinMenuService.generateWeixinMenuDto(wmps);
        weChatMenuService.publishMenu(wmds);
    }
//    @RequestMapping("/list")
//    public String list(Model model) {
//        model.addAttribute("menus", weixinMenuService.listAll());
//        model.addAttribute("wmds", weixinMenuService.generateWeixinMenuDto());
//        return "weixinMenu/list";
//    }
//
//    @RequestMapping(value="/add",method= RequestMethod.GET)
//    public String add(Model model) {
//        model.addAttribute("menu", new WeixinMenuPO());
//        return "weixinMenu/add";
//    }
//
//    @RequestMapping(value="/add",method=RequestMethod.POST)
//    public String add(WeixinMenuPO menu) {
//        weixinMenuService.add(menu);
//        return "redirect:/weixinMenu/list";
//    }
//
//    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
//    public String update(@PathVariable int id, Model model) {
//        model.addAttribute("menu", weixinMenuService.load(id));
//        return "weixinMenu/add";
//    }
//
//    @RequestMapping(value="/update/{id}",method=RequestMethod.POST)
//    public String update(@PathVariable int id,WeixinMenuPO menu) {
//        WeixinMenuPO twm = weixinMenuService.load(id);
//        twm.setContent(menu.getContent());
//        twm.setMenuKey(menu.getMenuKey());
//        twm.setName(menu.getName());
//        twm.setRespType(menu.getRespType());
//        twm.setType(menu.getType());
//        twm.setUrl(menu.getUrl());
//        twm.setRespType(menu.getRespType());
//        weixinMenuService.update(twm);
//        return "redirect:/weixinMenu/list";
//    }
//
//    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
//    public String delete(@PathVariable int id,Model model) {
//        weixinMenuService.delete(id);
//        return "redirect:/weixinMenu/list";
//    }
//
//    @RequestMapping("/queryPublishMenu")
//    public String queryPublish(Model model) {
//        model.addAttribute("ms", weChatMenuService.queryMenu());
//        return "weixinMenu/publish";
//    }

}

