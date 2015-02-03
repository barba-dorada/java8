package chapter5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by vad on 02.02.2015.
 */
public class ex4 {
    public static void main(String[] args) {

        int year = Integer.parseInt(args[1]);
        int month = Integer.parseInt(args[0]);

        LocalDate firstDay = LocalDate.of(year, month, 1);
        LocalDate lastDay = firstDay.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("пн вт ср чт пт сб вс");

        LocalDate first0 = firstDay.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        for (LocalDate d = first0; !d.isAfter(lastDay); d = d.plusDays(1)) {
            if (d.getMonth().getValue() == month) {
                System.out.printf("%2d ", d.getDayOfMonth());
            } else {
                System.out.print("   ");
            }
            if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }
        }
    }
}
/*

* */