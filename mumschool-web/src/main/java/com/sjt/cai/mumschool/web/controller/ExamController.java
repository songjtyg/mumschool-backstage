package com.sjt.cai.mumschool.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.biz.service.ExamAnswerService;
import com.sjt.cai.mumschool.biz.service.ExamService;
import com.sjt.cai.mumschool.biz.service.QuestionBankService;
import com.sjt.cai.mumschool.biz.service.QuestionService;
import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.dto.ExamBeginDTO;
import com.sjt.cai.mumschool.entity.dto.NextQuestionDTO;
import com.sjt.cai.mumschool.entity.po.ExamAnswerPO;
import com.sjt.cai.mumschool.entity.po.ExamPO;
import com.sjt.cai.mumschool.entity.po.QuestionPO;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    private ExamAnswerService examAnswerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionBankService questionBankService;

    @PostMapping("/begin")
    public JsonResult<QuestionBO> begin(@RequestBody ExamBeginDTO examBeginDTO, HttpSession session) {
        if (!questionBankService.ifExistByIdAndQrVerifyCode(examBeginDTO.getQuestionBankId(),examBeginDTO.getQrVerifyCode())){
            return JsonResult.errorsInfo("0","图形码验证码错误！");
        }

        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null) {
            return JsonResult.errorsInfo("1","session为空，请首先登陆");
        }

        ExamPO examPO = new ExamPO();
        examPO.setQuestionBankId(examBeginDTO.getQuestionBankId());
        examPO.setUserId(weixinUserPO.getId());
        examPO.setCorrectNum(0);
        examPO.setScore(0);
        examPO.setBeginTime(new Date());
        examPO.setEndTime(null);
        examService.insert(examPO);

        NextQuestionDTO nextQuestionDTO = new NextQuestionDTO();
        nextQuestionDTO.setExamId(examPO.getId());
        nextQuestionDTO.setQuestionBankId(examPO.getQuestionBankId());
        nextQuestionDTO.setQuestionId(0);
        QuestionBO nextQuestionBO = questionService.selectNext(nextQuestionDTO);

        return JsonResult.success(nextQuestionBO);

    }
    @PostMapping("/next")
    public JsonResult<QuestionBO> next(@RequestBody ExamAnswerPO examAnswerPO, HttpSession session) {
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null){
            return JsonResult.errorsInfo("1","session为空，请首先登陆");
        }


        examAnswerService.insertOrUpdate(examAnswerPO);

        NextQuestionDTO nextQuestionDTO = new NextQuestionDTO();
        nextQuestionDTO.setExamId(examAnswerPO.getExamId());
        nextQuestionDTO.setQuestionBankId(examAnswerPO.getQuestionBankId());
        nextQuestionDTO.setQuestionId(examAnswerPO.getQuestionId());
        QuestionBO nextQuestionBO = questionService.selectNext(nextQuestionDTO);

        return JsonResult.success(nextQuestionBO);
    }

    @GetMapping("/finish")
    public JsonResult<Integer> finish(@RequestParam Integer examId, HttpSession session) {
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null){
            return JsonResult.errorsInfo("1","session为空，请首先登陆");
        }

        return JsonResult.success(examService.calculateScore(examId));

    }
}

