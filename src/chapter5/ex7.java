package chapter5;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by vad on 02.02.2015.
 */
public class ex7 {
    public static void main(String[] args) {
        TimeInterval ti1 = new TimeInterval(LocalDateTime.of(2015, 1, 1, 10, 0), LocalDateTime.of(2015, 1, 1, 12, 0));
        TimeInterval ti2 = new TimeInterval(LocalDateTime.of(2015, 1, 1, 11, 0), Duration.ofHours(4));
        TimeInterval ti3 = new TimeInterval(LocalDateTime.of(2015, 1, 1, 12, 0), Duration.ofHours(4));

        LocalDateTime t1=LocalDateTime.now();
        System.out.println(t1.isAfter(t1));
        System.out.println(t1.isBefore(t1));


        System.out.println(ti1);
        System.out.println(ti2);
        System.out.println(ti1.isOverlap(ti2));
        System.out.println(ti1.isOverlap(ti3));
        System.out.println(ti1.isOverlap(ti1));


    }
}

class TimeInterval {
    LocalDateTime start;
    LocalDateTime stop;

    public TimeInterval(LocalDateTime begin, LocalDateTime end) {
        this.start = begin;
        this.stop = end;
    }

    public TimeInterval(LocalDateTime start, Duration dur) {
        this.start = start;
        this.stop = start.plus(dur);
    }

    @Override
    public String toString() {
        return "TimeInterval{start=" + start + ", stop=" + stop + '}';
    }


    boolean isOverlap(TimeInterval t){
        return contain(t.start)|| contain(t.stop);

    }
    boolean contain(LocalDateTime dt){
        return (dt.isAfter(start)||dt.equals(start)) && dt.isBefore(stop)  ;

    }
}
