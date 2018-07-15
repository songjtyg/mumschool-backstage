package com.sjt.cai.mumschool.wechat.service;

public interface WeChatWqrService {
    String loadTicketByBaseQr(int snum);
    String loadTicketByTempQr(int snum);
}
