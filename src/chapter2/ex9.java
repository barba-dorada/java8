package chapter2;

/**
 * Created by vad on 04.03.2015.
 */

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 9. Join all elements in a  Stream<ArrayList<T>> to one  ArrayList<T> . Show how to do
 * this with the three forms of  reduce .
 * 10. Write a call to  reduce that can be used to compute the average of a  Stream<Double> .
 * Why can’t you simply compute the sum and divide by  count() ?
 */

public class ex9 {
    public static void main(String[] args) {

        Stream<ArrayList<String>> stream = getArrayListStream();
        ArrayList<String> s0 = stream.reduce(new ArrayList<>(), (x, y) -> {
            x.addAll(y);
            return x;
        }, (x, y) -> {
            x.addAll(y);
            return x;
        });
        System.out.println(s0);

        stream = getArrayListStream();
        Optional<ArrayList<String>> s1 = stream.reduce((x, y) -> {
            x.addAll(y);
            return x;
        });
        System.out.println(s1.get());


        stream = getArrayListStream();
        ArrayList<String> s2 = stream.reduce(new ArrayList<>(), (x, y) -> {
            x.addAll(y);
            return x;
        });
        System.out.println(s2);


    }

    private static Stream<ArrayList<String>> getArrayListStream() {
        ArrayList<String> s1 = new ArrayList<>();
        s1.add("qqq");
        s1.add("www");
        s1.add("eee");
        ArrayList<String> s2 = new ArrayList<>();
        s2.add("rrr");
        s2.add("ttt");
        s2.add("yyy");
        ArrayList<String> s3 = new ArrayList<>();
        s3.add("aaa");
        s3.add("sss");
        s3.add("ddd");
        return Stream.of(s1, s2, s3);
    }
}
