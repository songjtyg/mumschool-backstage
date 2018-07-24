package com.sjt.cai.mumschool.web.controller;


import com.sjt.cai.mumschool.biz.service.ExamAnswerService;
import com.sjt.cai.mumschool.biz.service.ExamService;
import com.sjt.cai.mumschool.biz.service.QuestionService;
import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.dto.ExamBeginDTO;
import com.sjt.cai.mumschool.entity.po.ExamPO;
import com.sjt.cai.mumschool.entity.po.QuestionPO;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
@Controller
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/begin")
    public JsonResult<QuestionPO> begin(@RequestBody ExamBeginDTO examBeginDTO, HttpSession session) {
        ExamPO examPO = new ExamPO();
        examPO.setQuestionBankId(examBeginDTO.getQuestionBankId());
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null){
            examPO.setUserId(weixinUserPO.getId());
            examService.insert(examPO);

            QuestionBO questionBO = new QuestionBO();
            questionBO.setQuestionBankId(examPO.getQuestionBankId());
            questionBO.setId(0);
            QuestionBO nextQuestionBO = questionService.selectNext(questionBO);

            return JsonResult.success(nextQuestionBO);
        }
        return JsonResult.errorsInfo("1","session为空，请首先登陆")
    }

}

