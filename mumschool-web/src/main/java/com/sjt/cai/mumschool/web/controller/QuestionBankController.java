package com.sjt.cai.mumschool.web.controller;


import com.sjt.cai.mumschool.biz.service.QuestionBankService;
import com.sjt.cai.mumschool.common.JsonResult;
import com.sjt.cai.mumschool.entity.bo.QuestionBO;
import com.sjt.cai.mumschool.entity.dto.QuestionBankVerifyDTO;
import com.sjt.cai.mumschool.entity.po.QuestionBankPO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

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

    @GetMapping(value = "/{id}/content")
    public JsonResult<String>  selectContentById(@PathVariable("id") Integer id){
        return JsonResult.success(questionBankService.selectById(id).getContent());
    }

}

