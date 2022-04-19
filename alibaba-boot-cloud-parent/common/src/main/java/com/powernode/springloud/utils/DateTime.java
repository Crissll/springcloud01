package com.powernode.springloud.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    /**
     * 获取年月日时分秒
     * */
    public static String getDateTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

    /**
     * 获取年月日
     * */
    public static String getDate(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 获取时分秒
     * */
    public static String getTime(){
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }
}
