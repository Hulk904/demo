package com.demo.base;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by yangyuan on 2019/9/11.
 *
 * @author yangyuan
 * @date 2019/09/11
 */
public class Testtime {
    private static boolean timeCheck(Date lotteryTime) {
        if (lotteryTime == null) {
            return false;
        }
        Instant instant = lotteryTime.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.now().isAfter(instant.atZone(zoneId).toLocalDateTime());
    }

    public static void main(String[] args) {
        for (int i = 0;i < 20 ; i ++) {
            System.out.println(timeCheck(parse("2019-09-11 00:30:41")));
        }
    }

    public static Date parse(String dateString) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, dateTimeFormatter);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }
}
