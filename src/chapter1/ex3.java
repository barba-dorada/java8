package chapter1;

import java.io.File;
import java.util.Arrays;

import static chapter1.Util.*;

/**
 * Created by vad on 21.02.2015.
 */
public class ex3 {

    public static void main(String[] args) {
        String ext = ".pdf";

        File startDir = new File("d:/downloads");
        File[] files;
        files = startDir.listFiles(pathname -> {
                    return pathname.getName().endsWith(ext);
                }
        );

        System.out.println(Arrays.asList(files));

        files = startDir.listFiles((dir, name) -> {
                    return name.endsWith(ext);
                }
        );
        printFiles(files);


    }
}
