package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by vad on 03.03.2015.
 * * 
 1. Write a parallel version of the  for loop in Section 2.1, “From Iteration to
 Stream Operations,” on page 22. Obtain the number of processors. Make that
 many separate threads, each working on a segment of the list, and total up
 the results as they come in. (You don’t want the threads to update a single
 counter. Why?)
 */
public class ex1 {
    public static void main(String[] args) throws IOException {
        String contents=new String(Files.readAllBytes(Paths.get("war+peace.txt")));
        List<String> worlds= Arrays.asList(contents.split("[\\P{L}]+"));
        Stream<String> ss= Stream.of(contents.split("[\\P{L}]+"));
        long t0 = System.currentTimeMillis();
        int count=0;
        for(String w:worlds){
            if(w.length()>12) count++;
        }
        System.out.println(count);
        long t1 = System.currentTimeMillis();
        System.out.println(t1-t0);
        
        long count2 = ss.filter(w -> w.length() > 12).count();
        System.out.println(count2);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        
    }
}
