package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import com.sjt.cai.mumschool.dao.WeixinUserMapper;
import com.sjt.cai.mumschool.biz.service.WeixinUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-06-19
 */
@Service
public class WeixinUserServiceImpl extends ServiceImpl<WeixinUserMapper, WeixinUserPO> implements WeixinUserService {
    @Override
    public WeixinUserPO loadByUserName(String userName){
        return selectOne(new EntityWrapper<WeixinUserPO>().where("userName = {0}",userName));
    }
    @Override
    public WeixinUserPO loadByOpenid(String openid){
        return selectOne(new EntityWrapper<WeixinUserPO>().where("openid = {0}",openid));
    }
    @Override
    public  WeixinUserPO login(String userName,String password){
        return selectOne(new EntityWrapper<WeixinUserPO>().where("userName = {0} and password = {1}",userName,password));
    }
}
