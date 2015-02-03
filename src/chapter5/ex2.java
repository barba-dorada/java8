package chapter5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by vad on 02.02.2015.
 */
public class ex2 {
    public static void main(String[] args) {
        LocalDate ld= LocalDate.of(2000,2,29);
        System.out.println(ld.plus(1,ChronoUnit.YEARS));
        System.out.println(ld.plus(4, ChronoUnit.YEARS));
        System.out.println(ld.plus(1,ChronoUnit.YEARS).plus(1, ChronoUnit.YEARS).plus(1,ChronoUnit.YEARS).plus(1, ChronoUnit.YEARS));
    }
}
/*
2001-02-28
2004-02-29
2004-02-28
        */