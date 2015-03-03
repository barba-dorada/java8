package chapter1;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * Created by vad on 02.02.2015.
 */
public class ex2 {
    public static void main(String[] args) {

        File rootDir = new File("c:/");
        File[] files;

        files = rootDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        System.out.println(Arrays.asList(files));

        files = rootDir.listFiles(pathname -> {
            return pathname.isDirectory();
        });
        System.out.println(Arrays.asList(files));

        files = rootDir.listFiles(File::isDirectory);
        System.out.println(Arrays.asList(files));

    }
}