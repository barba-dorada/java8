package chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vad on 03.03.2015.
 */

/**
3. Measure the difference when counting long words with a  parallelStream instead
of a  stream . Call  System.currentTimeMillis before and after the call, and print the
difference. Switch to a larger document (such as War and Peace) if you have
a fast computer.
 */

public class ex3 {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("dickens.txt")));
        ArrayList<String> worlds = new ArrayList<>();
        worlds.addAll(Arrays.asList(contents.split("[\\P{L}]+")));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                long t0 = System.currentTimeMillis();
                long c1 = worlds.stream().filter(w -> w.length() > 12).count();
                long t1 = System.currentTimeMillis();
                long c2 = worlds.parallelStream().filter(w -> w.length() > 12).count();
                long t2 = System.currentTimeMillis();
                System.out.printf("words:%d, seq:%d, par:%d\n", worlds.size(), t1 - t0, t2 - t1);
            }
            worlds.addAll(worlds);
        }
    }
}
/*

words:5268155, seq:82, par:88
words:5268155, seq:23, par:19
words:5268155, seq:23, par:19
words:5268155, seq:24, par:18
words:5268155, seq:26, par:20
words:10536310, seq:53, par:34
words:10536310, seq:46, par:37
words:10536310, seq:52, par:37
words:10536310, seq:64, par:40
words:10536310, seq:48, par:31
words:21072620, seq:94, par:70
words:21072620, seq:96, par:71
words:21072620, seq:100, par:65
words:21072620, seq:93, par:68
words:21072620, seq:102, par:63
words:42145240, seq:195, par:135
words:42145240, seq:189, par:154
words:42145240, seq:190, par:144
words:42145240, seq:246, par:133
words:42145240, seq:188, par:136

 */