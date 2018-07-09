package com.sjt.cai.mumschool.common.service;

public interface WqrService {
    String loadTicketByBaseQr(int snum);
    String loadTicketByTempQr(int snum);
}
