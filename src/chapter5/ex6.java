package chapter5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by vad on 02.02.2015.
 */
public class ex6 {
    public static void main(String[] args) {
        LocalDate first= LocalDate.of(1901, 1, 13);
        LocalDate last=LocalDate.of(2000,12,14);

        System.out.println("пятницы, 13, в ХХ веке");
        for(LocalDate d=first;d.isBefore(last);d=d.plusMonths(1)){
            if(d.getDayOfWeek()== DayOfWeek.FRIDAY){
                System.out.println(d);
            }
        }
    }
}
/*

* */