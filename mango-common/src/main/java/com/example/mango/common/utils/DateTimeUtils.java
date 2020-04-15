package com.example.mango.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xugang
 */
public class DateTimeUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前标准格式化日期时间
     *
     * @return 时间字符
     */
    public static String getDateTime() {
        return getDateTime(new Date());
    }

    /**
     * 标准格式化日期时间
     *
     * @param date 日期
     * @return 日期字符
     */
    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }

}
