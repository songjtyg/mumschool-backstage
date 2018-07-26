package com.sjt.cai.mumschool.entity.bo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

@Data
public class ExamBO {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer userId;
    private Integer questionBankId;
    private Integer correctNum;
    private Integer score;
    private Date beginTime;
    private Date endTime;
}
