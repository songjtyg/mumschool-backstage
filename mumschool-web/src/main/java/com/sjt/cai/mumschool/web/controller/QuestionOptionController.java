package com.sjt.cai.mumschool.web.controller;


import com.sjt.cai.mumschool.biz.service.QuestionOptionService;
import com.sjt.cai.mumschool.biz.service.QuestionService;
import com.sjt.cai.mumschool.entity.po.QuestionOptionPO;
import com.sjt.cai.mumschool.entity.po.QuestionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
@RestController
@RequestMapping("/questionOption")
public class QuestionOptionController {
    @Autowired
    private QuestionOptionService questionOptionService;

    @GetMapping("/questionId/{questionId}")
    public List<QuestionOptionPO> selectById(@PathVariable("questionId")Integer questionId){
        return questionOptionService.selectByQuestionId(questionId);
    }
}

