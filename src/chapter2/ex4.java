package chapter2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by vad on 03.03.2015.
 */
/**
4. Suppose you have an array  int[] values = { 1, 4, 9, 16 } . What is
Stream.of(values) ? How do you get a stream of  int instead?
 */
public class ex4 {
    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        Stream<int[]> stream = Stream.of(values);
        stream.forEach(i -> System.out.println(i));
        IntStream is = IntStream.of(values);
        is.forEach(i -> System.out.println(i));
    }
}
/*
[I@3f99bd52
1
4
9
16

* * * */