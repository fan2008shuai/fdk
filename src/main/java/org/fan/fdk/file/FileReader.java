package org.fan.fdk.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fan.shuai on 2019/11/16.
 */
public class FileReader {

    public static void main(String[] args) throws IOException {
        String file = System.getProperty("user.home") + "/test.txt";
        /**
         * It's the directory where java was run from, where you started the JVM. Does not have to be within
         * the user's home directory. It can be anywhere where the user has permission to run java.
         *
         * So if you cd into /somedir, then run your program, user.dir will be /somedir.
         *
         * A different property, user.home, refers to the user directory. As in /Users/myuser or
         * /home/myuser or C:\Users\myuser.
         */
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
        List<String> result = new LinkedList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(file), StandardCharsets.UTF_8)) {
            String line;
            while((line = br.readLine()) != null) {
                result.add(line);
            }
        }

        Path resultPath = Paths.get(file).getParent().resolve("test.copy.txt");
        Files.write(resultPath, result, StandardCharsets.UTF_8);
    }

}
