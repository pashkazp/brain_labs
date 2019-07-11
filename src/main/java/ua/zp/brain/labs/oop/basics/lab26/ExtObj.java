package ua.zp.brain.labs.oop.basics.lab26;

import java.io.*;

public class ExtObj {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(CardType.CARD_MC, "Bank of America", "1234-5678-9012-3456", "123", "456");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/home/forexhunter/IdeaProjects/braincad/brain_labs/src/main/java/ua/zp/brain/labs/oop/basics/lab26/card.ext")))) {
            creditCard.writeExternal(oos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
