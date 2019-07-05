package ua.zp.brain.labs.oop.basics.lab26;

import java.io.*;

public class DeserializeTest {
    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/home/forexhunter/IdeaProjects/braincad/brain_labs/src/main/java/ua/zp/brain/labs/oop/basics/lab26/card.ser")))) {
            CreditCard cc = (CreditCard)ois.readObject();
            System.out.println(cc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
