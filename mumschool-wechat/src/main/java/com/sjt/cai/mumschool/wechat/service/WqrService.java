package com.sjt.cai.mumschool.wechat.service;

public interface WqrService {
    String loadTicketByBaseQr(int snum);
    String loadTicketByTempQr(int snum);
}
