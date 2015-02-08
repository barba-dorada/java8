package chapter5;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vad on 02.02.2015.
 * <p>
 * 12. Write a program that solves the problem described at the beginning of
 * Section 5.5, “Zoned Time,” on page 109. Read a set of appointments in differ-
 * ent time zones and alert the user which ones are due within the next hour in
 * local time.
 */
public class ex12 {
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm (VV O) ");

    public static void main(String[] args) {
        List<ZonedDateTime> list = new LinkedList<>();
        list.add(mk(10, 30, "Europe/Moscow"));
        list.add(mk(11, 25, "Europe/Berlin"));
        list.add(mk(11, 35, "Europe/Paris"));
        list.add(mk(10, 00, "UTC"));
        list.add(mk(17, 00, "Europe/London"));
        System.out.println(list);

        ZonedDateTime local = mk(13, 00, "Europe/Moscow");

        list.stream().sorted().forEach(dd -> {
            print(dd);
            print(dd.withZoneSameInstant(ZoneId.of("Europe/Moscow")));
        });
        System.out.println("ближайшие с" + local + " в течении часа");
        list.stream().filter(d -> d.isAfter(local) && d.isBefore(local.plusHours(1))).forEach(dd -> {
            print(dd);
            //   print(dd.withZoneSameInstant(ZoneId.of("Europe/Moscow")));
        });

    }

    static void print(TemporalAccessor temporal) {
        System.out.println(format.format(temporal));
    }

    static ZonedDateTime mk(int hour, int minute, String zone) {
        return LocalDateTime.of(2015, 1, 1, hour, minute, 0).atZone(ZoneId.of(zone));
    }

}
/*



* */