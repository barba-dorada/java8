package chapter2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vad on 04.03.2015.
 */
/*
8. Write a method  public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
that alternates elements from the streams  first and  second , stopping when
one of them runs out of elements.
 */
public class ex8 {
    public static void main(String[] args) {
        Stream<Character> res = zip(getStream("qwerty"), getStream("asdfghjkl;'"));
        res.forEach(System.out::print);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        LinkedList<T> resultList = new LinkedList<>();

        while (!firstList.isEmpty() && !secondList.isEmpty()) {
            resultList.add(firstList.remove(0));
            resultList.add(secondList.remove(0));
        }

        return resultList.stream();
    }

    static Stream<Character> getStream(String s) {
        return Stream.iterate(0, x -> x + 1).limit(s.length()).map(s::charAt);
    }
}
