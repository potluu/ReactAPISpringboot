package com.ecommerce.project.laptop.utils;


import java.io.File;
import java.time.LocalTime;
import java.util.Date;

public class TimeUtils {

    public static Date getTimeNowSystem(){
        LocalTime time=LocalTime.now();
        Date date = new Date(time.getSecond());
        return date;
    }



}
