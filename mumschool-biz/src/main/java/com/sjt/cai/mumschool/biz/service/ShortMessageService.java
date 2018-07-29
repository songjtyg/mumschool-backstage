package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.entity.po.ShortMessagePO;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-29
 */
public interface ShortMessageService extends IService<ShortMessagePO> {

    JsonResult<Boolean> sendSmsVerifyCode(String phone);

    Boolean ifValidVerifyCode(String phone,String verifyCode);
}
