package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.entity.po.QuestionOptionPO;
import com.sjt.cai.mumschool.dao.QuestionOptionMapper;
import com.sjt.cai.mumschool.biz.service.QuestionOptionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
@Service
public class QuestionOptionServiceImpl extends ServiceImpl<QuestionOptionMapper, QuestionOptionPO> implements QuestionOptionService {
    @Override
    public List<QuestionOptionPO> selectByQuestionId(Integer questionId) {
        return selectList(new EntityWrapper<QuestionOptionPO>().where("question_id ={0}",questionId ));
    }
}
