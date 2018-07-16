package com.holddie.java8.tutorial.TimeDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 时区相关的日期处理
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/16 15:41
 */
public class ZonedDateTest {
    public static void main(String[] args) {

        // 系统分类
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        // 指定时区
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime1);

        // 指定GMT时区
        Instant instant = Instant.now();
        ZoneId zoneId1 = ZoneId.of("GMT");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.ofInstant(instant, zoneId1);
        System.out.println(zonedDateTime2);

    }
}
