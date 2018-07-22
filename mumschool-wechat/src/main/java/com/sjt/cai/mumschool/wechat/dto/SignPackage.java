package com.sjt.cai.mumschool.wechat.dto;

import lombok.Data;

@Data
public class SignPackage {
    private String appId;
    private String timestamp;
    private String nonceStr;
    private String pageUrl;
    private String signature;
}