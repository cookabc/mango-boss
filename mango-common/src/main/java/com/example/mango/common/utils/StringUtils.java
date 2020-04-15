package com.example.mango.common.utils;

/**
 * @author xugang
 */
public class StringUtils {

    /**
     * 判空操作
     *
     * @param value 需要判断的字符
     * @return 是否为空
     */
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }

}
