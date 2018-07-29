package com.sjt.cai.mumschool.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    public static JsonResult<Boolean> isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return JsonResult.faultMessage("手机号应为11位数");
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (!isMatch) {
                return JsonResult.faultMessage("手机号应为11位数");
            }
            return JsonResult.success(true);
        }
    }
}
