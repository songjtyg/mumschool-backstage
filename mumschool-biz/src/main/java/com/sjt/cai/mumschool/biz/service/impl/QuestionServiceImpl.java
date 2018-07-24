package com.sjt.cai.mumschool.biz.service.impl;

import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.dto.NextQuestionDTO;
import com.sjt.cai.mumschool.entity.po.QuestionPO;
import com.sjt.cai.mumschool.dao.QuestionMapper;
import com.sjt.cai.mumschool.biz.service.QuestionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, QuestionPO> implements QuestionService {

    @Override
    public QuestionBO selectNext(NextQuestionDTO nextQuestionDTO) {
        return baseMapper.selectNext(nextQuestionDTO);
    }
}
