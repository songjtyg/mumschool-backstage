package com.sjt.cai.mumschool.web.controler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.biz.service.WeixinMenuService;
import com.sjt.cai.mumschool.wechat.dto.WeixinMenuDto;
import com.sjt.cai.mumschool.wechat.service.MenuService;
import com.sjt.cai.mumschool.entity.po.WeixinMenuPO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/mumschool/menu")
public class MenuController {
    @Inject
    private WeixinMenuService weixinMenuService;
    @Inject
    private MenuService menuService;

    @GetMapping("/publishMenu")
    public void publishMenu() throws JsonProcessingException {
        List<WeixinMenuPO> wmps = weixinMenuService.listAll();
        List<WeixinMenuDto> wmds = weixinMenuService.generateWeixinMenuDto(wmps);
        menuService.publishMenu(wmds);
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
//        model.addAttribute("ms", menuService.queryMenu());
//        return "weixinMenu/publish";
//    }

    @PostMapping(value="/login")
    public String login(HttpSession httpSession){
        System.out.println(httpSession.getId());
        return "{}";
    }
}

