package chapter2;

import java.util.stream.Stream;

/**
 * Created by vad on 03.03.2015.
 */
public class ex7 {
    public static void main(String[] args) {
        Stream<Double> generate = Stream.generate(Math::random);
        System.out.println(isFinite(generate));
    }

    public static <T> boolean isFinite(Stream<T> stream){
        Stream<T> s2 = stream.skip(Long.MAX_VALUE);
        return !s2.findAny().isPresent();
    }
}
