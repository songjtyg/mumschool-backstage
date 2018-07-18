package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-19
 */
public interface WeixinUserService extends IService<WeixinUserPO> {

    WeixinUserPO loadByUserName(String userName);

    WeixinUserPO loadByPhone(String phone);

    WeixinUserPO loadByOpenid(String openid);

    WeixinUserPO loadByloginWord(String loginWord);

    WeixinUserPO loadByloginWordAndPassword(String userName, String password);
}
