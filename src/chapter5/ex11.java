package chapter5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.Duration.*;

/**
 * Created by vad on 02.02.2015.
 */
/*
11. Your return flight leaves Frankfurt at 14:05 and arrives in Los Angeles at
16:40. How long is the flight? Write a program that can handle calculations
like this.
America/Los_Angeles     -08:00
Etc/GMT-1     +01:00

ТУДА, 8 февраля, Воскресенье
15:20—11:05 (9 фев)
мест 8+
без пересадок, подробнее
Boeing 747
в Франкфурт
10 ч  45 мин



*/
public class ex11 {
    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm (VV) ");

        ZoneId departureZone =ZoneId.of("Etc/GMT-1");
        ZoneId arrivingZone = ZoneId.of("America/Los_Angeles");


        ZonedDateTime departure = LocalDateTime.of(2015, 1, 1, 14, 5, 0).atZone(departureZone);
        System.out.printf("LEAVING:  %s%n", departure.format(format));

        ZonedDateTime arrival =  LocalDateTime.of(2015, 1, 1, 16,40, 0).atZone(arrivingZone);
        System.out.printf("ARRIVAL:  %s%n", arrival.format(format));

        Duration duration = between(departure, arrival);
        System.out.println("flight takes : "+duration.toHours()+":"+duration.toMinutes()%60);
    }
}
/*
LEAVING:  01.01.2015 14:05 (Etc/GMT-1)
ARRIVAL:  01.01.2015 16:40 (America/Los_Angeles)
flight takes : 11:35
 */