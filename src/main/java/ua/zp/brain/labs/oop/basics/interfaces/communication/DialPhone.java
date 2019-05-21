package ua.zp.brain.labs.oop.basics.interfaces.communication;

public class DialPhone implements Caller {

    @Override
    public void call(String contact) {
        System.out.println("\nЭто номер 222-22-22?");
        System.out.println("Да. А кто вы?");
        System.out.println("Не важно. Позвоните, пожалуйста, по номеру \"" + contact
                + "\". У меня палец в номеронабирателе на двойке застрял.");
    }

}
