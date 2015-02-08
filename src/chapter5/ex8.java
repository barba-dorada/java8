package chapter5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by vad on 02.02.2015.
 */
public class ex8 {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.now();
        Set<String> zids = ZoneId.getAvailableZoneIds();
        // zids.stream().forEach(s -> System.out.println(s));

        zids.stream().map(ZoneId::of).forEach(zone -> {
                    ZonedDateTime zdt = dt.atZone(zone);
                    ZoneOffset offset = zdt.getOffset();
                    String out = String.format("%35s %10s%n", zone, offset);
                    System.out.printf(out);
                }
        );

        /* http://docs.oracle.com/javase/tutorial/datetime/iso/timezones.html */
    }
}
