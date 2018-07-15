package com.sjt.cai.mumschool.wechat.dto;

import lombok.Data;

@Data
public class WetChatDuplicateMessage {
    private String fromUserName;
    private String createTime;
    private Long curTime;
    private String  rel;

    public WetChatDuplicateMessage(String fromUserName, String createTime) {
        super();
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.curTime = System.currentTimeMillis();
        this.rel = null;
        this.rel = Thread.currentThread().getName();
    }

    @Override
    public boolean equals(Object obj){
        WetChatDuplicateMessage dm = (WetChatDuplicateMessage)obj;
        return dm.getFromUserName().equals(this.getFromUserName())
                && dm.getCreateTime().equals(this.getCreateTime());
    }
}
