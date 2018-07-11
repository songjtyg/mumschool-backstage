package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.biz.service.TUserService;
import com.sjt.cai.mumschool.biz.service.WeixinMenuService;
import com.sjt.cai.mumschool.biz.service.WeixinMessageService;
import com.sjt.cai.mumschool.biz.service.WeixinQrService;
import com.sjt.cai.mumschool.wechat.constant.WeixinFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WGroup;
import com.sjt.cai.mumschool.wechat.dto.WUser;
import com.sjt.cai.mumschool.wechat.msg.MessageCreateKit;
import com.sjt.cai.mumschool.wechat.msg.MessageKit;
import com.sjt.cai.mumschool.wechat.msg.WeixinEventKit;
import com.sjt.cai.mumschool.wechat.service.GroupService;
import com.sjt.cai.mumschool.wechat.service.UserService;
import com.sjt.cai.mumschool.wechat.util.DuplicateMessageKit;
import com.sjt.cai.mumschool.entity.po.TUserPO;
import com.sjt.cai.mumschool.entity.po.WeixinMenuPO;
import com.sjt.cai.mumschool.entity.po.WeixinQr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
@Service
public class WeixinMessageServiceImpl implements WeixinMessageService {
    @Autowired
    WeixinMenuService weixinMenuService;

    @Autowired
    UserService userService;

    @Autowired
    TUserService tUserService;

    @Autowired
    private GroupService wGroupService;
    @Autowired
    private WeixinQrService weixinQrService;
    @Autowired
    private GroupService groupService;

    @Override
    public  String handlerMsg(Map<String, String> msgMap) throws IOException {
        if (DuplicateMessageKit.checkDuplicate(msgMap)) {
            String rel = DuplicateMessageKit.getRel(msgMap);
            return rel;
        }else {
            String msgType = msgMap.get("MsgType");
            if (WeixinFinalValue.MSG_EVENT_TYPE.equals(msgType.trim())) {
                String event = msgMap.get("Event");
                if("CLICK".equals(event)){
                    String keyCode = msgMap.get("EventKey");
                    WeixinMenuPO wm = weixinMenuService.loadByKey(keyCode);
                    return WeixinEventKit.handlerClickEvent(msgMap,wm);
                }else if ("subscribe".equals(event)){
                    TUserPO tUserPO = handlerUserInfo(msgMap);
                    String snum = getSence(msgMap,true);
                    String openId = WeixinEventKit.extractOpenId(msgMap);
                    if(snum != null){
                        WeixinQr wq = weixinQrService.loadBySnum(Integer.parseInt(snum));
                        if(wq.getType() == WeixinQr.SET_GROUP_TYPE)
                       wGroupService.moveUserToGroup(openId,Integer.parseInt(wq.getQrData()));
                    }
                    if(tUserPO.getBind() == 0){
                        String bindUrl = "http://www.konghao.org";
                        return MessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap,"<a href=\""+bindUrl+"\">请点击绑定用户获得更好的体验</a>"));
                    } else {
                        String bindUrl = "http://www.konghao.org";
                        return MessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap,"<a href=\""+bindUrl+"\">欢迎您再次使用我们的微信平台，点击打开</a>"));
                    }

                }else if ("unsubscribe".equals(event)) {
                    String openId = WeixinEventKit.extractOpenId(msgMap);
                    TUserPO tUserPO =  tUserService.selectOne(new EntityWrapper<TUserPO>().where("openId={0}",openId));
                    if(tUserPO !=null) {
                        tUserPO.setStatus(0);
                        tUserService.updateById(tUserPO);
                    }
                }else if("SCAN".equals(event)){
                    return handlerScanEvent(msgMap);
                }
            } else if (WeixinFinalValue.MSG_TEXT_TYPE.equals(msgType.trim())) {
                return MessageKit.textTypeHandler(msgMap);
            } else if (WeixinFinalValue.MSG_IMAGE_TYPE.equals(msgType.trim())) {
                return MessageKit.imageTypeHandler(msgMap, "nDwKcYuGUH62UCsFmetNdyl8tu7ym2S62NXF9cl9UEWqcf-cHCj497bquMK35Mxg");
            } else {
                return MessageKit.hanlderCommonMsg(msgMap);
            }
        }
        return null;
    }

    private String handlerScanEvent(Map<String, String> msgMap) throws IOException {
        TUserPO u = handlerUserInfo(msgMap);
        String snum = getSence(msgMap,false);
        String openId = msgMap.get("FromUserName");
        WeixinQr wq =  weixinQrService.loadBySnum(Integer.parseInt(snum));
        if (wq.getType()==WeixinQr.REPASSWORD_TYPE){
            //处理修改密码操作
            return MessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap,"<a href=\""+wq.getQrData()+"\">"+wq.getMsg()+"</a>"));
        }else if (wq.getType() == WeixinQr.SET_GROUP_TYPE){
            //处理设置用户操作
            groupService.moveUserToGroup(openId,Integer.parseInt(wq.getQrData()));
            WGroup wg = wGroupService.queryUserGroup(openId);
            return MessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap,"<a href=\""+wq.getQrData()+"\">"+wg.getName()+"</a>"));
        }else if (wq.getType() == WeixinQr.TYPE_BIND){
            //处理绑定用户操作
        }else if(wq.getType() == WeixinQr.TEMP_LOGIN){
            //处理用户扫码登录操作
            long t = System.currentTimeMillis() - wq.getCreateDate().getTime();
            if ((t/1000)>60){
                return MessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap,""));//todo
            }else {
                wq.setStatus(1);
                wq.setQrData(openId);
                weixinQrService.updateById(wq);
            }

        }
        return null;
    }

    private TUserPO handlerUserInfo(Map<String,String> msgMap) throws IOException {
        String openId = WeixinEventKit.extractOpenId(msgMap);
        TUserPO tUserPO =  tUserService.selectOne(new EntityWrapper<TUserPO>().where("openId={0}",openId));
        if(tUserPO ==null) {
            WUser wUser = userService.queryByOpenId(openId);
            tUserPO = new TUserPO();
            tUserPO.setBind(0);
            tUserPO.setImgUrl(wUser.getHeadImageUrl());
            tUserPO.setNickname(wUser.getNickname());
            tUserPO.setOpenid(openId);
            tUserPO.setSex(wUser.getSex());
            tUserPO.setStatus(1);
            tUserPO.setUsername(wUser.getOpenId());
            tUserPO.setPassword(wUser.getOpenId());
            tUserService.insert(tUserPO);
        }else {
            if (tUserPO.getStatus() == 0){
                tUserPO.setStatus(1);
                tUserService.updateById(tUserPO);
            }
        }
        return tUserPO;
    }
    private String getSence(Map<String,String> msgMap,boolean subscribe){
        String key = msgMap.get("EventKey");
        if(key == null || "".equals(key)) return null;
        if(subscribe)
            return key.split("_")[1];
        else
            return key;
    }
}
