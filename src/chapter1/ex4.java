package chapter1;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

import static chapter1.Util.printFiles;

/**
 * Created by vad on 21.02.2015.
 *
 * 4. Given an array of  File objects, sort it so that the directories come before the
 * files, and within each group, elements are sorted by path name. Use a lambda
 * expression, not a  Comparator .
 *
 */
public class ex4 {
    public static void main(String[] args) {
        File startDir = new File("d:/downloads");
        File[] files;
        files = startDir.listFiles();
        printFiles(files);

        Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory() == o2.isDirectory()) {
                return o1.getPath().compareTo(o2.getPath());
            } else {
                return o1.isDirectory() ? -1 : 1;
            }
        });

        printFiles(files);
    }
}
