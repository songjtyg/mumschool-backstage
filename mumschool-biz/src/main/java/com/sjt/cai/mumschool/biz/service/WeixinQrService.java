package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.entity.po.WeixinQr;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-25
 */
public interface WeixinQrService extends IService<WeixinQr> {
    public WeixinQr loadBySnum(int snum);

    WeixinQr add(WeixinQr weixinQr);
}
