package chapter2;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by vad on 03.03.2015.
 */
public class ex5 {
    public static void main(String[] args) {
        Stream<Long> streamOfLong;
        streamOfLong = Stream.iterate(System.currentTimeMillis(), new MyRandomGenerator(25214903917L,11L,2L<<48));
        streamOfLong.limit(100).forEach(System.out::println);
    }
}
class MyRandomGenerator implements UnaryOperator<Long>{
    private final long a;
    private final long c;
    private final long m;

    public MyRandomGenerator(long a,long c, long m){
        this.a=a;
        this.c=c;
        this.m=m;
    }
    @Override
    public Long apply(Long xn) {
        return ((a*xn+c) % m);
    }
}
