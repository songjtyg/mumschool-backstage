package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.entity.po.TUserPO;
import com.sjt.cai.mumschool.dao.TUserMapper;
import com.sjt.cai.mumschool.biz.service.TUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUserPO> implements TUserService {
    @Override
    public TUserPO loadByUserName(String username){
        return selectOne(new EntityWrapper<TUserPO>().where("username = {0}",username));
    }
    @Override
    public TUserPO loadByOpenId(String openid){
        return selectOne(new EntityWrapper<TUserPO>().where("openid = {0}",openid));
    }
    @Override
    public  TUserPO login(String username,String password){
        return selectOne(new EntityWrapper<TUserPO>().where("username = {0} and password = {1}",username,password));
    }
}
