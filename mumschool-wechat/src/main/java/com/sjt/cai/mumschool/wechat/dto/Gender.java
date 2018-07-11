package com.sjt.cai.mumschool.wechat.dto;

public enum Gender {
    male("男"),
    female("女");

    private String name;
    private Gender(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
