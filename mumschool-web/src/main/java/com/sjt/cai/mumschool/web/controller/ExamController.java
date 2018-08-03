package com.sjt.cai.mumschool.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.biz.service.*;
import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.entity.bo.ExamAnswerBO;
import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.bo.QuestionBankBO;
import com.sjt.cai.mumschool.entity.dto.BankExamQuestionAnswerBO;
import com.sjt.cai.mumschool.entity.dto.ExamAnswerAndNextDTO;
import com.sjt.cai.mumschool.entity.dto.NextQuestionDTO;
import com.sjt.cai.mumschool.entity.dto.QuestionBankVerifyDTO;
import com.sjt.cai.mumschool.entity.po.ExamAnswerPO;
import com.sjt.cai.mumschool.entity.po.ExamPO;
import com.sjt.cai.mumschool.entity.po.QuestionOptionPO;
import com.sjt.cai.mumschool.entity.po.WeixinUserPO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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

    @PostMapping("/begin")
    public JsonResult<BankExamQuestionAnswerBO> begin(@RequestBody QuestionBankVerifyDTO questionBankVerifyDTO, HttpSession session) {
        //判断二维码是否有效
        if (!questionBankService.ifExistByIdAndQrVerifyCode(questionBankVerifyDTO.getQuestionBankId(),questionBankVerifyDTO.getQrVerifyCode())){
            return JsonResult.errorsInfo("1","二维码有误，请检查！");
        }
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO == null) {
//            return JsonResult.errorsInfo("1","session为空，请首先登陆");
            weixinUserPO = new WeixinUserPO();
            weixinUserPO.setId(1);
        }
        //获取题库
        QuestionBankBO questionBankBO = questionBankService.selectBOById(questionBankVerifyDTO.getQuestionBankId());
        //生成本次考试
        ExamPO examPO = new ExamPO();
        examPO.setQuestionBankId(questionBankVerifyDTO.getQuestionBankId());
        examPO.setUserId(weixinUserPO.getId());
        examPO.setCorrectNum(0);
        examPO.setScore(0);
        examPO.setBeginTime(new Date());
        examPO.setEndTime(null);
        examService.insert(examPO);
        //获取第一题
        QuestionBO questionBO = questionService.selectFirst(examPO.getId());
        //拼装返回值
        BankExamQuestionAnswerBO bankExamQuestionAnswerBO = new BankExamQuestionAnswerBO();
        bankExamQuestionAnswerBO.setQuestionBankBO(questionBankBO);
        bankExamQuestionAnswerBO.setQuestionBO(questionBO);
        return JsonResult.success(bankExamQuestionAnswerBO);
    }

    @PostMapping("/next")
    public JsonResult<QuestionBO> next(@RequestBody ExamAnswerAndNextDTO examAnswerAndNextDTO, HttpSession session) {
        WeixinUserPO weixinUserPO = (WeixinUserPO) session.getAttribute("user");
        if (weixinUserPO != null){
//            return JsonResult.errorsInfo("1","session为空，请首先登陆");
            weixinUserPO = new WeixinUserPO();
            weixinUserPO.setId(1);
        }
        //计算答案是否正确
        ExamAnswerPO examAnswerPO = new ExamAnswerPO();
        BeanUtils.copyProperties(examAnswerAndNextDTO,examAnswerPO,"choices","questionSeq");

        List<String> factChoices = examAnswerAndNextDTO.getChoices();
        Collections.sort(factChoices);
        examAnswerPO.setChoices(StringUtils.join(factChoices,","));

        List<QuestionOptionPO> qos = questionOptionService.selectList(new EntityWrapper<QuestionOptionPO>().where("question_id = {0}",examAnswerAndNextDTO.getQuestionId()));
        List<String> qss = qos.stream().filter(i->i.getCorrect()).map((i)-> i.getLetter()).collect(Collectors.toList());
        Collections.sort(qss);

        if (examAnswerPO.getChoices().equalsIgnoreCase(StringUtils.join(qss,",")))
            examAnswerPO.setCorrect(true);
        else
            examAnswerPO.setCorrect(false);
        //保存答案
        examAnswerService.insertOrUpdate(examAnswerPO);
        //获取下一道题
        NextQuestionDTO nextQuestionDTO = new NextQuestionDTO();
        nextQuestionDTO.setExamId(examAnswerAndNextDTO.getExamId());
        nextQuestionDTO.setQuestionBankId(examAnswerAndNextDTO.getQuestionBankId());
        nextQuestionDTO.setQuestionId(examAnswerAndNextDTO.getQuestionId());
        nextQuestionDTO.setSeq(examAnswerAndNextDTO.getQuestionSeq());
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

