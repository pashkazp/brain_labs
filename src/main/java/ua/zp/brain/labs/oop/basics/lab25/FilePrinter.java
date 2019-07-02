package ua.zp.brain.labs.oop.basics.lab25;

import java.io.*;

public class FilePrinter {
    public static void main(String[] args) {
        try (Reader re = new BufferedReader(new FileReader(new File("/home/forexhunter/IdeaProjects/braincad/brain_labs/src/main/java/ua/zp/brain/labs/oop/basics/lab25/FilePrinter.java")))) {
            int c;
            while ((c = re.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
