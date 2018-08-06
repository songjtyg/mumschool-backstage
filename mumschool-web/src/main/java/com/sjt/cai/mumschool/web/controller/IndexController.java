package com.sjt.cai.mumschool.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.sjt.cai.mumschool.biz.service.*;
import com.sjt.cai.mumschool.common.JsonResult;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("first")
    public String finish( HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        return "forward:/";
    }
    @GetMapping("scanToExam")
    public String scanToExam( HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {

        return "forward:/";
    }
}

