package com.sjt.cai.mumschool.entity.bo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class QuestionBO {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 1-单选；2-多选
     */
	private Integer type;
	private String content;
	private Integer score;
	private Integer creater;
	private Date createTime;
	private Integer modifier;
	private Date modifyTime;
	private Integer questionBankId;

}
