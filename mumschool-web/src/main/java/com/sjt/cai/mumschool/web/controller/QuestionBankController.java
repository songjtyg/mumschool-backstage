package com.sjt.cai.mumschool.web.controller;


import com.sjt.cai.mumschool.biz.service.QuestionBankService;
import com.sjt.cai.mumschool.entity.po.QuestionBankPO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-18
 */
@Api
@RestController
@RequestMapping("/questionBank")
public class QuestionBankController {
    @Autowired
    private QuestionBankService questionBankService;

    @GetMapping(value = "/{id}")
    public QuestionBankPO selectById(@PathVariable("id") Integer id){
        return questionBankService.selectById(id);
    }

}

