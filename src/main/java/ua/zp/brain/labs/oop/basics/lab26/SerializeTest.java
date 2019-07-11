package ua.zp.brain.labs.oop.basics.lab26;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeTest {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(CardType.CARD_MC, "Bank of America", "1234-5678-9012-3456", "123", "456");

        creditCard.newTread = new Thread(() -> System.out.println("aaaaa"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/home/forexhunter/IdeaProjects/braincad/brain_labs/src/main/java/ua/zp/brain/labs/oop/basics/lab26/card.ser")))) {
            oos.writeObject(creditCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
