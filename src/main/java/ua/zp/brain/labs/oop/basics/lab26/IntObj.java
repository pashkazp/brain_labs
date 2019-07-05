package ua.zp.brain.labs.oop.basics.lab26;

import java.io.*;

public class IntObj {
    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/home/forexhunter/IdeaProjects/braincad/brain_labs/src/main/java/ua/zp/brain/labs/oop/basics/lab26/card.ext")))) {

            CreditCard cc = new CreditCard();
            cc.readExternal(ois);
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
