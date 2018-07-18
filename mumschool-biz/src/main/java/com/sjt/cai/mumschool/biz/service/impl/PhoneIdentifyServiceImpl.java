package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.entity.po.PhoneIdentifyPO;
import com.sjt.cai.mumschool.dao.PhoneIdentifyMapper;
import com.sjt.cai.mumschool.biz.service.PhoneIdentifyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
public class PhoneIdentifyServiceImpl extends ServiceImpl<PhoneIdentifyMapper, PhoneIdentifyPO> implements PhoneIdentifyService {

    @Override
    public String selectByPhone(String phone) {
        PhoneIdentifyPO po = selectOne(new EntityWrapper<PhoneIdentifyPO>().where("phone = {0}",phone));
        return Optional.ofNullable(po).map(i->i.getIdentifyingCode()).orElse("");
    }
}
