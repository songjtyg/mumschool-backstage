package com.sjt.cai.mumschool.biz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.entity.po.QuestionChoicePO;
import com.sjt.cai.mumschool.dao.QuestionChoiceMapper;
import com.sjt.cai.mumschool.biz.service.QuestionChoiceService;
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
public class QuestionChoiceServiceImpl extends ServiceImpl<QuestionChoiceMapper, QuestionChoicePO> implements QuestionChoiceService {
    @Override
    public List<QuestionChoicePO> selectByQuestionId(Integer questionId) {
        return selectList(new EntityWrapper<QuestionChoicePO>().where("question_id ={0}",questionId ));
    }
}
