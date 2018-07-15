package com.sjt.cai.mumschool.biz.service.impl;

import com.sjt.cai.mumschool.wechat.service.WeChatWqrService;
import com.sjt.cai.mumschool.entity.po.WeixinQr;
import com.sjt.cai.mumschool.dao.WeixinQrMapper;
import com.sjt.cai.mumschool.biz.service.WeixinQrService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-25
 */
@Service
public class WeixinQrServiceImpl extends ServiceImpl<WeixinQrMapper, WeixinQr> implements WeixinQrService {
    @Autowired
    private WeChatWqrService weChatWqrService;

    @Override
    public WeixinQr loadBySnum(int snum) {
        WeixinQr weixinQr = new WeixinQr();
        weixinQr.setSnum(snum);
        return baseMapper.selectOne(weixinQr);
    }

    @Override
    public WeixinQr add(WeixinQr weixinQr){
        if(weixinQr.getSnum() == null )throw new RuntimeException("场景值不能为空");
        if(weixinQr.getSnum()<=WeixinQr.MAX_BASE_SNUM){
            //永久二维码
            WeixinQr tempWeixinQr = this.loadBySnum(weixinQr.getSnum());
            if(tempWeixinQr != null) throw new RuntimeException("固定二维码的场景值已经存在");
            weixinQr.setCreateDate(new Date());
            setQrTicket(tempWeixinQr,0);
            baseMapper.insert(tempWeixinQr);
        }else{
            //临时二维码
            addTempQr(weixinQr);
        }
        return weixinQr;
    }

    private WeixinQr addTempQr(WeixinQr wq) {
        WeixinQr twq = this.loadBySnum(wq.getSnum());
        if(twq == null){
            wq.setCreateDate(new Date());
            setQrTicket(wq,1);
            baseMapper.insert(wq);
            return wq;
        }else{
            if(checkExpired(twq)){
                //先删除twq，之后添加wq
                twq.setCreateDate(new Date());
                twq.setMsg(wq.getMsg());
                twq.setName(wq.getName());
                twq.setQrData(wq.getQrData());
                twq.setSnum(wq.getSnum());
                twq.setStatus(wq.getStatus());
                twq.setType(wq.getType());
                setQrTicket(twq,1);
                baseMapper.updateById(twq);
                return twq;
            }else{
                wq.setSnum((WeixinQr.MAX_BASE_SNUM+1)+ new Random().nextInt());
                return addTempQr(wq);
            }
        }
    }
    private void setQrTicket(WeixinQr wq,int type){
        String ticket;
        if(type==0){
            ticket = weChatWqrService.loadTicketByBaseQr(wq.getSnum());
        }else{
            ticket = weChatWqrService.loadTicketByTempQr(wq.getSnum());
        }
        if (ticket == null || "".equals(ticket)) throw new RuntimeException("从微信获取二维码失败！");
        wq.setTicket(ticket);
    }
    private boolean checkExpired(WeixinQr twq) {
        long t = System.currentTimeMillis() - twq.getCreateDate().getTime();
        if ((t/1000)>60) return true;
        return false;
    }
}
