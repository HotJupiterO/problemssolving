package ioexercises;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = "D:\\IDEAprojects\\src";
        getListOfPath(path);
        getSpecific(path, ".java");
        isExist(path);
        String w1 = "Ліс";
        String w2 = "Літо";

        System.out.println(isLexicographically(w1, w2));
    }

    public static void getListOfPath(String path) throws IOException {
        Path p = Paths.get(path);
        if (Files.exists(p)) {
            DirectoryStream<Path> d = Files.newDirectoryStream(p);
            for (Path x : d) System.out.println(x.getFileSystem());
        }

        System.out.println("=====================================");
        System.out.println("=====================================");
        File file = new File(path);
        System.out.println(Arrays.toString(file.listFiles()));
        /*for (String s : file.list()) {
            int start = s.indexOf(".");
            if (start > 0) System.out.println(s.substring(start + 1));
        }*/
        Stream.of(file.list())
                .filter(s -> s.indexOf(".") > 0)
                .map(s -> s.substring(s.indexOf(".") + 1))
                .forEach(System.out::println);


    }

    public static void getSpecific(String path, String pattern) {
        File file = new File(path);
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.toLowerCase(Locale.ROOT).endsWith(pattern));
            }
        });
        System.out.println(Arrays.toString(list));
    }

    public static void isExist(String path) {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("Directory or File exist.");
        } else {
            System.out.println("Directory or File doesn't exist.");
        }


    }

    public static boolean isLexicographically(String s1, String s2) {
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            if (s1.charAt(i) > s2.charAt(j)) return false;
        }
        return true;
    }

    public static String getLongestWord(File file) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                sb.append(sc.nextLine());
            }
            sc.close();
        }
        char[] chars = sb.toString().toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0, startIndex = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                if (startIndex < i) {

                }
                startIndex = i;
                continue;
            }
            System.out.println("lox");

        }
        return "";
    }


}
