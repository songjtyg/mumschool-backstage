package com.sjt.cai.mumschool.dao;

import com.sjt.cai.mumschool.entity.po.ShortMessagePO;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-29
 */
public interface ShortMessageMapper extends BaseMapper<ShortMessagePO> {
    ShortMessagePO selectRecentVerifyCodeByPhone(String phone);
}
