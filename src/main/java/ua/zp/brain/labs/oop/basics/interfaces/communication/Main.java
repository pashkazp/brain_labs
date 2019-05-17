package ua.zp.brain.labs.oop.basics.interfaces.communication;

public class Main {
    public static void main(String[] args) {
        SmartPhone nokia = new SmartPhone();
        nokia.openApp("Angry Birds");
        nokia.call("Vasya");
        nokia.sendMail("qwerty");

        Caller galaxyS7 = new SmartPhone();
        galaxyS7.call("Boss");
        // Интерфейс не имеет метода openApp, необходимо явное приведение
        ((SmartPhone) galaxyS7).openApp("Viber");

        Caller panasonic = new HomePhone();
        panasonic.call("911");
        //panasonic.openApp(); // ERROR! Такого метода нет у HomePhone

        MailSender iphone8 = new SmartPhone();
        MailSender ukrposhta = new Post();

        generalSendMail(nokia);
        generalSendMail(((MailSender) galaxyS7));
        // generalSendMail(((HomePhone)panasonic)); // ERROR! HomePhone не имеет нужного интерфейса
        generalSendMail(iphone8);
        generalSendMail(ukrposhta);
    }

    public static void generalSendMail(MailSender sender) {
        sender.sendMail("--This is mail-- from" + sender.getClass());
    }
}
