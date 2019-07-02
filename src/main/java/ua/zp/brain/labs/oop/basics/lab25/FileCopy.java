package ua.zp.brain.labs.oop.basics.lab25;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("/home/forexhunter/IdeaProjects/braincad/brain_labs/src/main/java/ua/zp/brain/labs/oop/basics/lab25/FilePrinter.java");
             OutputStream fos = new FileOutputStream("/home/forexhunter/IdeaProjects/braincad/brain_labs/src/main/java/ua/zp/brain/labs/oop/basics/lab25/FilePrinter.java.copy")) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
