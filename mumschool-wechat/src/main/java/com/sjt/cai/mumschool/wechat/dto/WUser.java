package com.sjt.cai.mumschool.wechat.dto;

import lombok.Data;

@Data
public class WUser {
    private int subscribe;
    private String openId;
    private String nickname;
    private int sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headImageUrl;
    private long subscribe_time;
    private int groupId;
    private String remark;
    private String unionId;
}
