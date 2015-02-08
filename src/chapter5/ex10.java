package chapter5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by vad on 02.02.2015.
 */
/*10. Your flight from Los Angeles to Frankfurt leaves at 3:05 pm local time and
takes 10 hours and 50 minutes. When does it arrive? Write a program that
can handle calculations like this.
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
public class ex10 {
    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm (VV) ");

        ZoneId departureZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = LocalDateTime.of(2015, 1, 1, 15, 5, 0).atZone(departureZone);
        System.out.printf("LEAVING:  %s%n", departure.format(format));

        // Flight is 10 hours and 50 minutes, or 650 minutes
        ZoneId arrivingZone = ZoneId.of("Etc/GMT-1");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusMinutes(10*60+50);

        System.out.printf("ARRIVAL:  %s%n", arrival.format(format));
    }
}
/*
LEAVING:  01.01.2015 15:05 (America/Los_Angeles)
ARRIVAL:  02.01.2015 10:55 (Etc/GMT-1)
 */