package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.entity.po.WeixinQrPO;
import com.sjt.cai.mumschool.wechat.service.WeChatWqrService;
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
public class WeixinQrServiceImpl extends ServiceImpl<WeixinQrMapper, WeixinQrPO> implements WeixinQrService {
    @Autowired
    private WeChatWqrService weChatWqrService;

    /**
     * 根据snum查询二维码
     * @param snum
     * @return
     */
    @Override
    public WeixinQrPO selectBySnum(int snum) {
        return selectOne(new EntityWrapper<WeixinQrPO>().where("snum = {0}",snum));
    }
    /**
     * 判断二维码是否过期
     * @param twq
     * @return
     */
    private boolean checkExpired(WeixinQrPO twq) {
        long t = System.currentTimeMillis() - twq.getCreateDate().getTime();
        return (t/1000)>60 ? true:false;
    }
    /**
     * 生成二维码
     * @param weixinQrPO
     * @return
     */
    @Override
    public WeixinQrPO insertWeixinQr(WeixinQrPO weixinQrPO){
        if(weixinQrPO.getSnum() == null )throw new RuntimeException("场景值不能为空");
        if(weixinQrPO.getSnum()<= WeixinQrPO.MAX_BASE_SNUM){
            //永久二维码
            WeixinQrPO dbWeixinQrPO = this.selectBySnum(weixinQrPO.getSnum());
            if(dbWeixinQrPO != null) throw new RuntimeException("固定二维码的场景值已经存在");
            weixinQrPO.setCreateDate(new Date());
            weixinQrPO.setTicket(weChatWqrService.loadTicketByBaseQr(weixinQrPO.getSnum()));
            this.insert(weixinQrPO);
        }else{
            //临时二维码
            insertTempWeixinQr(weixinQrPO);
        }
        return weixinQrPO;
    }

    /**
     * 生成临时二维码
     * @param weixinQrPO
     * @return
     */
    private WeixinQrPO insertTempWeixinQr(WeixinQrPO weixinQrPO) {
        WeixinQrPO dbWeixinQrPO = this.selectBySnum(weixinQrPO.getSnum());
        if(dbWeixinQrPO == null){
            //数据库无则插入
            weixinQrPO.setCreateDate(new Date());
            weixinQrPO.setTicket(weChatWqrService.loadTicketByTempQr(weixinQrPO.getSnum()));
            baseMapper.insert(weixinQrPO);
            return weixinQrPO;
        }else{
            //数据库有&已经过期则更新
            if(checkExpired(dbWeixinQrPO)){
                //先删除twq，之后添加wq
                dbWeixinQrPO.setCreateDate(new Date());
                dbWeixinQrPO.setMsg(weixinQrPO.getMsg());
                dbWeixinQrPO.setName(weixinQrPO.getName());
                dbWeixinQrPO.setQrData(weixinQrPO.getQrData());
                dbWeixinQrPO.setSnum(weixinQrPO.getSnum());
                dbWeixinQrPO.setStatus(weixinQrPO.getStatus());
                dbWeixinQrPO.setType(weixinQrPO.getType());
                weixinQrPO.setTicket(weChatWqrService.loadTicketByTempQr(weixinQrPO.getSnum()));
                this.updateById(dbWeixinQrPO);
                return dbWeixinQrPO;
            }else{
                //数据库有&没有过期则新增
                weixinQrPO.setSnum((WeixinQrPO.MAX_BASE_SNUM+1)+ new Random().nextInt());
                return insertTempWeixinQr(weixinQrPO);
            }
        }
    }
    
}
