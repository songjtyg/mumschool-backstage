package com.sjt.cai.mumschool.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.biz.service.ExamAnswerService;
import com.sjt.cai.mumschool.biz.service.ExamService;
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
import java.util.Date;
import java.util.List;

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

    @PostMapping("/begin")
    public JsonResult<QuestionBO> begin(@RequestBody ExamBeginDTO examBeginDTO, HttpSession session) {
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null){
            ExamPO examPO = new ExamPO();
            examPO.setQuestionBankId(examBeginDTO.getQuestionBankId());
            examPO.setUserId(weixinUserPO.getId());
            examPO.setBeginTime(new Date());
            examPO.setCorrectNum(0);
            examPO.setScore(0);
            examService.insert(examPO);

            NextQuestionDTO nextQuestionDTO = new NextQuestionDTO();
            nextQuestionDTO.setQuestionBankId(examPO.getQuestionBankId());
            nextQuestionDTO.setQuestionId(0);
            QuestionBO nextQuestionBO = questionService.selectNext(nextQuestionDTO);

            return JsonResult.success(nextQuestionBO);
        }
        return JsonResult.errorsInfo("1","session为空，请首先登陆")
    }
    @PostMapping("/next")
    public JsonResult<QuestionPO> next(@RequestBody ExamAnswerPO examAnswerPO, HttpSession session) {
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null){
            examAnswerService.insert(examAnswerPO);

            NextQuestionDTO nextQuestionDTO = new NextQuestionDTO();
            nextQuestionDTO.setQuestionBankId(examAnswerPO.getQuestionBankId());
            nextQuestionDTO.setQuestionId(examAnswerPO.getQuestionId());
            QuestionBO nextQuestionBO = questionService.selectNext(nextQuestionDTO);

            return JsonResult.success(nextQuestionBO);
        }
        return JsonResult.errorsInfo("1","session为空，请首先登陆")
    }

    @GetMapping("/finish")
    public JsonResult<Integer> finish(@RequestParam Integer examId, HttpSession session) {
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null){
            List<ExamAnswerPO> result examAnswerService.selectList(new EntityWrapper<ExamAnswerPO>().where("exam_id = {0}",examId));
            //列表循环计算
            return JsonResult.success(100);
        }
        return JsonResult.errorsInfo("1","session为空，请首先登陆")
    }
}

