package chapter5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by vad on 02.02.2015.
 */
public class ex5 {
    public static void main(String[] args) {
        LocalDate ld= LocalDate.of(1971, 8, 21);
        long i = ld.until(LocalDate.now(), ChronoUnit.DAYS);
        System.out.println("колво дней от моего рождения: "+i);
    }
}
/*

* */