package chapter5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by vad on 02.02.2015.
 */
public class ex9 {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();
        Set<String> zids = ZoneId.getAvailableZoneIds();
        // zids.stream().forEach(s -> System.out.println(s));


//#9
        zids.stream().map(ZoneId::of).forEach(zone -> {
                    ///ZoneId zone = ZoneId.of(s);

                    ZonedDateTime zdt = dt.atZone(zone);
                    ZoneOffset offset = zdt.getOffset();
                    int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
                    String out = String.format("%35s %10s%n", zone, offset);

                    // Write only time zones that do not have a whole hour offset
                    // to standard out.
                    if (secondsOfHour != 0) {
                        System.out.printf(out);
                    }
                }
        );

        /* http://docs.oracle.com/javase/tutorial/datetime/iso/timezones.html */
    }
}
