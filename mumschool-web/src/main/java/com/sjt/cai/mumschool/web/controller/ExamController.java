package com.sjt.cai.mumschool.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.biz.service.*;
import com.sjt.cai.mumschool.common.CommonTransform;
import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.entity.bo.ExamAnswerBO;
import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.dto.ExamBeginDTO;
import com.sjt.cai.mumschool.entity.dto.NextQuestionDTO;
import com.sjt.cai.mumschool.entity.po.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
@RestController
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

    @Autowired
    private QuestionOptionService questionOptionService;

    @GetMapping("/begin")
    public JsonResult<QuestionBO> begin(@RequestParam("questionBankId") Integer questionBankId, HttpSession session) {


        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO == null) {
//            return JsonResult.errorsInfo("1","session为空，请首先登陆");
            weixinUserPO = new WeixinUserPO();
            weixinUserPO.setId(1);
        }

        ExamPO examPO = new ExamPO();
        examPO.setQuestionBankId(questionBankId);
        examPO.setUserId(weixinUserPO.getId());
        examPO.setCorrectNum(0);
        examPO.setScore(0);
        examPO.setBeginTime(new Date());
        examPO.setEndTime(null);
        examService.insert(examPO);

        return JsonResult.success(questionService.selectFirst(examPO.getId()));

    }
    @GetMapping("/first/")
    public JsonResult<QuestionBO> first(@RequestParam("examId") Integer examId, HttpSession session){
        return JsonResult.success(questionService.selectFirst(examId));
    }

    @PostMapping("/next")
    public JsonResult<QuestionBO> next(@RequestBody ExamAnswerBO examAnswerBO, HttpSession session) {
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null){
//            return JsonResult.errorsInfo("1","session为空，请首先登陆");
            weixinUserPO = new WeixinUserPO();
            weixinUserPO.setId(1);
        }

        ExamAnswerPO examAnswerPO = new ExamAnswerPO();
        BeanUtils.copyProperties(examAnswerBO,examAnswerPO,"choices");

        List<String> factChoices = examAnswerBO.getChoices();
        Collections.sort(factChoices);
        examAnswerPO.setChoices(StringUtils.join(factChoices,","));

        List<QuestionOptionPO> qos = questionOptionService.selectList(new EntityWrapper<QuestionOptionPO>().where("question_id = {0}",examAnswerBO.getQuestionId()));
        List<String> qss = qos.stream().filter(i->i.getCorrect()).map((i)-> i.getLetter()).collect(Collectors.toList());
        Collections.sort(qss);

        if (examAnswerPO.getChoices().equalsIgnoreCase(StringUtils.join(qss,",")))
            examAnswerPO.setCorrect(true);
        else
            examAnswerPO.setCorrect(false);
        examAnswerService.insertOrUpdate(examAnswerPO);

        NextQuestionDTO nextQuestionDTO = new NextQuestionDTO();
        nextQuestionDTO.setExamId(examAnswerBO.getExamId());
        nextQuestionDTO.setQuestionBankId(examAnswerBO.getQuestionBankId());
        nextQuestionDTO.setQuestionId(examAnswerBO.getQuestionId());
        QuestionBO nextQuestionBO = questionService.selectNext(nextQuestionDTO);

        return JsonResult.success(nextQuestionBO);
    }

    @GetMapping("/finish")
    public JsonResult<Integer> finish(@RequestParam("examId") Integer examId, HttpSession session) {
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null){
//            return JsonResult.errorsInfo("1","session为空，请首先登陆");
            weixinUserPO = new WeixinUserPO();
            weixinUserPO.setId(1);
        }

        return JsonResult.success(examService.calculateScore(examId));

    }
}

