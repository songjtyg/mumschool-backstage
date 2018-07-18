package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.entity.po.PhoneIdentifyPO;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
public interface PhoneIdentifyService extends IService<PhoneIdentifyPO> {

    String selectByPhone(String phone);
}
