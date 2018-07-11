package com.sjt.cai.mumschool.wechat.dto;

import lombok.Data;

@Data
public class DuplicateMessage {
    private String fromUserName;
    private String createTime;
    private Long curTime;
    private String  rel;

    public DuplicateMessage(String fromUserName, String createTime) {
        super();
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.curTime = System.currentTimeMillis();
        this.rel = null;
    }

    @Override
    public boolean equals(Object obj){
        DuplicateMessage dm = (DuplicateMessage)obj;
        if((dm.getCreateTime().equals(this.getCreateTime()))&&(dm.getFromUserName().equals(this.getFromUserName()))){
            return true;
        }
        return false;
    }
}
