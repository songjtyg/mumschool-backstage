package com.sjt.cai.mumschool.wechat.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WeChatUser {
    private int subscribe;
    private String openid;
    private String unionId;

    private String nickname;
    private Integer sex;
    private String language;
    private String country;
    private String province;
    private String city;
    private String headimgurl;
    private Date subscribe_time;
    private String remark;
    private Integer groupid;
    private List<String> tagid_list;
    private String subscribe_scene;
    private Integer qr_scene;
    private String qr_scene_str;
}
