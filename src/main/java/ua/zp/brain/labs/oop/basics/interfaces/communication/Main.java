package ua.zp.brain.labs.oop.basics.interfaces.communication;

public class Main {

    private static Post post;
    private static DialPhone dialPhone;
    private static SmartPhone smartPhone;

    public static void main(String[] args) {

        post = new Post();
        String sheet = post.createMail("Милый дедушка, Константин Макарыч! — писал он. — И пишу тебе письмо. Поздравляю вас с "
                + "Рождеством и желаю тебе всего от господа бога. Нету у меня ни отца, ни маменьки, "
                + "только ты у меня один остался.");
        post.sendMail(sheet);
        post.tramsportMail();

        dialPhone = new DialPhone();
        dialPhone.call("спасатели 2 33 222 3 22 3");

        SmartPhone nokia = new SmartPhone();
        nokia.openApp("Angry Birds");
        nokia.call("Vasya");
        nokia.call("спасатели 2 33 222 3 22 3");
        nokia.sendMail("qwerty");

        Caller galaxyS7 = new SmartPhone();
        galaxyS7.call("Boss");
        // Интерфейс не имеет метода openApp, необходимо явное приведение
        ((SmartPhone) galaxyS7).openApp("Viber");

        Caller panasonic = new DialPhone();
        panasonic.call("911");
        //panasonic.openApp(); // ERROR! Такого метода нет у DialPhone

        MailSender iphone8 = new SmartPhone();
        MailSender ukrposhta = new Post();

        generalSendMail("===== TESTED MAIL =====", post, nokia, (MailSender) galaxyS7, iphone8, ukrposhta);


    }

    public static void generalSendMail(String mail, MailSender... sender) {
        for (MailSender m : sender) {
            if (m != null) {
                System.out.println("\n====== "+m.getClass().toString()+" made createMail() & sendMail()  ======");
                m.createMail(mail);
                m.sendMail(mail);
            }

        }
    }
}
