package ua.zp.brain.labs.oop.basics.lab25;

import java.io.File;
import java.io.IOException;

public class DirectoryFilesPrinter {

    public static void main(String[] args) {
        File file = new File("/home/forexhunter/IdeaProjects/braincad/brain_labs/src/main/");
        printNames(file.listFiles());
    }

    public static void printNames(File[] files) {
        if (files != null) {
            for (File file : files) {
                try {
                    System.out.println(file.getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!file.isFile()) {
                    printNames(file.listFiles());
                }
            }
        } else {
            System.out.println("Каталог не существует или пуст");
        }
    }
}
