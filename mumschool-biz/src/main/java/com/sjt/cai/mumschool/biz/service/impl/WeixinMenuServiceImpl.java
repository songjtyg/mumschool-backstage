package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjt.cai.mumschool.biz.service.WeixinMenuService;
import com.sjt.cai.mumschool.wechat.dto.WeixinMenuDto;
import com.sjt.cai.mumschool.dao.WeixinMenuMapper;
import com.sjt.cai.mumschool.entity.po.WeixinMenuPO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-13
 */
@Service
public class WeixinMenuServiceImpl extends ServiceImpl<WeixinMenuMapper, WeixinMenuPO> implements WeixinMenuService {

//    public void add(WeixinMenuPO wm) {
//        if(wm.getType().equals("click"))
//            wm.setMenuKey("KEY_"+System.currentTimeMillis());
//        weixinMenuDao.add(wm);
//    }
//
//    public void delete(int id) {
//        weixinMenuDao.delete(id);
//    }
//
//    public void update(WeixinMenuPO wm) {
//        weixinMenuDao.update(wm);
//    }
//
    @Override
    public List<WeixinMenuPO> listAll() {
        return selectList(new EntityWrapper<WeixinMenuPO>());
    }

    public WeixinMenuPO loadByKey(String key) {
        return selectOne(new EntityWrapper<WeixinMenuPO>().where("menu_key = {0}",key));
    }
    @Override
    public List<WeixinMenuDto> generateWeixinMenuDto(List<WeixinMenuPO> menus) {
        List<WeixinMenuDto> menuDtos = new ArrayList<WeixinMenuDto>();
        WeixinMenuDto wmd = null;
        for(WeixinMenuPO wm:menus) {
            wmd = new WeixinMenuDto();
            wmd.setKey(wm.getMenuKey());
            wmd.setName(wm.getName());
            wmd.setType(wm.getType());
            wmd.setId(wm.getId());
            wmd.setUrl(wm.getUrl());
            if(wm.getPid()==null||wm.getPid()==0) {
                if(wmd.getSub_button()==null) {
                    wmd.setSub_button(new ArrayList<WeixinMenuDto>());
                }
                menuDtos.add(wmd);
            } else {
                WeixinMenuDto twmd = findById(wm.getPid(), menuDtos);
                if(twmd==null) throw new RuntimeException("菜单的父类对象有问题，请检查");
                twmd.getSub_button().add(wmd);
            }
        }
        return menuDtos;
    }

    private WeixinMenuDto findById(int id,List<WeixinMenuDto> wmds) {
        for(WeixinMenuDto wmd:wmds) {
            if(wmd.getId()==id) {
                return wmd;
            }
        }
        return null;
    }

}
