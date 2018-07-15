package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.biz.service.WeixinUserService;
import com.sjt.cai.mumschool.biz.service.WeixinMenuService;
import com.sjt.cai.mumschool.biz.service.WeixinMessageService;
import com.sjt.cai.mumschool.biz.service.WeixinQrService;
import com.sjt.cai.mumschool.wechat.constant.WeChatFinalValue;
import com.sjt.cai.mumschool.wechat.dto.WeChatGroup;
import com.sjt.cai.mumschool.wechat.dto.WeChatUser;
import com.sjt.cai.mumschool.wechat.util.WeChatMessageKit;
import com.sjt.cai.mumschool.wechat.util.WeChatEventKit;
import com.sjt.cai.mumschool.wechat.service.WeChatGroupService;
import com.sjt.cai.mumschool.wechat.service.WeChatUserService;
import com.sjt.cai.mumschool.wechat.util.WeChatDuplicateMessageKit;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import com.sjt.cai.mumschool.entity.po.WeixinMenuPO;
import com.sjt.cai.mumschool.entity.po.WeixinQr;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
@Service
public class WeixinMessageServiceImpl implements WeixinMessageService {
    @Autowired
    WeixinMenuService weixinMenuService;

    @Autowired
    WeChatUserService weChatUserService;

    @Autowired
    WeixinUserService weixinUserService;

    @Autowired
    private WeChatGroupService weChatGroupService;
    @Autowired
    private WeixinQrService weixinQrService;

    @Override
    public  String handlerMsg(Map<String, String> msgMap) throws IOException {
        if (WeChatDuplicateMessageKit.checkDuplicate(msgMap)) {
            String rel = WeChatDuplicateMessageKit.getRel(msgMap);
            return rel;
        }else {
            String msgType = msgMap.get("MsgType");
            if (WeChatFinalValue.MSG_EVENT_TYPE.equals(msgType.trim())) {
                String event = msgMap.get("Event");
                if("CLICK".equals(event)){
                    String keyCode = msgMap.get("EventKey");
                    WeixinMenuPO wm = weixinMenuService.loadByKey(keyCode);
                    return WeChatEventKit.handlerClickEvent(msgMap,wm);
                }else if ("subscribe".equals(event)){
                    WeixinUserPO weixinUserPO = handlerUserInfo(msgMap);
                    String snum = getSence(msgMap,true);
                    String openid = WeChatEventKit.extractOpenid(msgMap);
                    if(snum != null){
                        WeixinQr wq = weixinQrService.loadBySnum(Integer.parseInt(snum));
                        if(wq.getType() == WeixinQr.SET_GROUP_TYPE)
                       weChatGroupService.moveUserToGroup(openid,Integer.parseInt(wq.getQrData()));
                    }
                    if(weixinUserPO.getBind() == 0){
                        String bindUrl = "http://mumschool-front.ngrok.xiaomiqiu.cn/#/register";
                        return WeChatMessageKit.map2xml(WeChatMessageKit.createTextMsg(msgMap,"<a href=\""+bindUrl+"\">请点击绑定用户获得更好的体验</a>"));
                    } else {
                        String bindUrl = "http://mumschool-front.ngrok.xiaomiqiu.cn/#/login";
                        return WeChatMessageKit.map2xml(WeChatMessageKit.createTextMsg(msgMap,"<a href=\""+bindUrl+"\">欢迎您再次使用我们的微信平台，点击打开</a>"));
                    }

                }else if ("unsubscribe".equals(event)) {
                    String openid = WeChatEventKit.extractOpenid(msgMap);
                    WeixinUserPO weixinUserPO =  weixinUserService.selectOne(new EntityWrapper<WeixinUserPO>().where("openid={0}",openid));
                    if(weixinUserPO !=null) {
                        String bindUrl = "http://mama.maihan.com.cn";
                        weixinUserPO.setActive(false);
                        weixinUserService.updateById(weixinUserPO);
                        return WeChatMessageKit.map2xml(WeChatMessageKit.createTextMsg(msgMap,"<a href=\""+bindUrl+"\">欢迎您以后再次使用我们的微信平台，点击打开</a>"));
                    }
                }else if("SCAN".equals(event)){
                    return handlerScanEvent(msgMap);
                }else if("VIEW".equals(event)){// TODO VIEW事件如何处理完善？
                    return null;
                }
            } else if (WeChatFinalValue.MSG_TEXT_TYPE.equals(msgType.trim())) {
                return WeChatMessageKit.textTypeHandler(msgMap);
            } else if (WeChatFinalValue.MSG_IMAGE_TYPE.equals(msgType.trim())) {
                return WeChatMessageKit.imageTypeHandler(msgMap, "nDwKcYuGUH62UCsFmetNdyl8tu7ym2S62NXF9cl9UEWqcf-cHCj497bquMK35Mxg");
            } else {
                return WeChatMessageKit.hanlderCommonMsg(msgMap);
            }
        }
        return null;
    }

    private String handlerScanEvent(Map<String, String> msgMap) throws IOException {
        WeixinUserPO u = handlerUserInfo(msgMap);
        String snum = getSence(msgMap,false);
        String openid = msgMap.get("FromUserName");
        WeixinQr wq =  weixinQrService.loadBySnum(Integer.parseInt(snum));
        if (wq.getType()==WeixinQr.REPASSWORD_TYPE){
            //处理修改密码操作
            return WeChatMessageKit.map2xml(WeChatMessageKit.createTextMsg(msgMap,"<a href=\""+wq.getQrData()+"\">"+wq.getMsg()+"</a>"));
        }else if (wq.getType() == WeixinQr.SET_GROUP_TYPE){
            //处理设置用户操作
            weChatGroupService.moveUserToGroup(openid,Integer.parseInt(wq.getQrData()));
            WeChatGroup wg = weChatGroupService.queryUserGroup(openid);
            return WeChatMessageKit.map2xml(WeChatMessageKit.createTextMsg(msgMap,"<a href=\""+wq.getQrData()+"\">"+wg.getName()+"</a>"));
        }else if (wq.getType() == WeixinQr.TYPE_BIND){
            //处理绑定用户操作
        }else if(wq.getType() == WeixinQr.TEMP_LOGIN){
            //处理用户扫码登录操作
            long t = System.currentTimeMillis() - wq.getCreateDate().getTime();
            if ((t/1000)>60){
                return WeChatMessageKit.map2xml(WeChatMessageKit.createTextMsg(msgMap,""));//todo
            }else {
                wq.setStatus(1);
                wq.setQrData(openid);
                weixinQrService.updateById(wq);
            }

        }
        return null;
    }

    private WeixinUserPO handlerUserInfo(Map<String,String> msgMap) throws IOException {
        String openid = WeChatEventKit.extractOpenid(msgMap);
        WeixinUserPO weixinUserPO =  weixinUserService.selectOne(new EntityWrapper<WeixinUserPO>().where("openid={0}",openid));
        if(weixinUserPO ==null) {
            WeChatUser weChatUser = weChatUserService.queryByOpenid(openid);
            weixinUserPO = new WeixinUserPO();
            BeanUtils.copyProperties(weChatUser,weixinUserPO,"Tagid_list");

            weixinUserPO.setUserName(weChatUser.getNickname());
            weixinUserPO.setPhone(null);
            weixinUserPO.setPassword("123456");
            weixinUserPO.setBind(0);
            weixinUserPO.setStatus(1);
            weixinUserPO.setUserType(null);
            weixinUserPO.setActive(true);
            weixinUserService.insert(weixinUserPO);
        }else {
            if (!weixinUserPO.getActive()){
                weixinUserPO.setActive(true);
                weixinUserService.updateById(weixinUserPO);
            }
        }
        return weixinUserPO;
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
