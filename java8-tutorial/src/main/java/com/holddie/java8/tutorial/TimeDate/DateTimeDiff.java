package com.holddie.java8.tutorial.TimeDate;

import sun.dc.DuctusRenderingEngine;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * 两个时间差值
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/16 16:13
 */
public class DateTimeDiff {
    public static void main(String[] args) {

        /**
         * 时间差涉及类：
         * 1、日期：Period
         * 2、时间：Duration
         */
        // 两个日期之间：Period
        LocalDate date = LocalDate.of(2017, 7, 15);
        LocalDate date1 = LocalDate.now();
        Period period = Period.between(date, date1);
        System.out.println(period.getYears() + "年" + period.getMonths() + "月" + period.getDays() + "天");

        // 两个时间之间 Duration
        LocalTime time = LocalTime.of(20, 30);
        LocalTime time1 = LocalTime.now();
        Duration duration = Duration.between(time1, time);
        System.out.println(duration.toMinutes() + "分钟");

    }
}
