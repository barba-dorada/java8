package chapter5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import static java.time.LocalDate.now;

/**
 * Created by vad on 02.02.2015.
 */
public class ex1 {
    public static void main(String[] args) {
        int year=LocalDate.now().getYear();
        LocalDate ld= LocalDate.of(year, 1, 1);
        System.out.println(ld.plus(255,ChronoUnit.DAYS));
        System.out.println(LocalDate.ofYearDay(year,256));
    }
}
/*
2015-09-13
2015-09-13
* */