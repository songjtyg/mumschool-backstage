package com.sjt.cai.mumschool.biz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sjt.cai.mumschool.common.dto.WeixinMenuDto;
import com.sjt.cai.mumschool.entity.po.WeixinMenuPO;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-13
 */
public interface WeixinMenuService extends IService<WeixinMenuPO> {
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

    List<WeixinMenuPO> listAll();

    WeixinMenuPO loadByKey(String key);

    List<WeixinMenuDto> generateWeixinMenuDto(List<WeixinMenuPO> menus);
}
