package com.sjt.cai.mumschool.biz.service;

import com.sjt.cai.mumschool.entity.po.TUserPO;
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
public interface TUserService extends IService<TUserPO> {

    TUserPO loadByUserName(String username);

    TUserPO loadByOpenId(String openid);

    TUserPO login(String username, String password);
}
