package chapter1;

import java.io.File;

/**
 * Created by vad on 21.02.2015.
 */
public class Util {
    static void printFiles(File files[]){
        System.out.println("==files("+files.length+")==");
        for(File file:files){
            System.out.println(file);
        }

    }
}
