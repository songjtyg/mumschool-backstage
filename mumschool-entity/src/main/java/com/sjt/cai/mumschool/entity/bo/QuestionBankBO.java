package com.sjt.cai.mumschool.entity.bo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 宋江涛
 * @since 2018-07-24
 */
@Data
public class QuestionBankBO {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;
	private String content;
	private Integer singleNum;
	private Integer multipleNum;
	private Integer totalScore;
    /**
     * 考试时间（分钟）
     */
	private Integer duration;
	private String qrVerifyCode;
}
