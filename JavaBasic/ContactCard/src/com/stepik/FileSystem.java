package com.stepik;

import java.io.File;

public class FileSystem {
    public static void main(String[] args) {
        String[] massiv_strok = new String[]{
                "a//b//..//file.txt",
                "a////b////c////file.txt",
                "a////..////b////c////file.txt",
                "a////.////b////..////c////.////file.txt",
                ".////a////b////..////b////c////.////file.txt"};

        for (String stroka_podstanovki : massiv_strok) {
            File file_temp = new File(stroka_podstanovki);
            System.out.println(stroka_podstanovki);
            try {
                System.out.println(file_temp.getCanonicalPath());
            } catch (Exception e) {
            }
            System.out.println("");
        }
    }
}