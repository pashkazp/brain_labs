package ua.zp.brain.labs.oop.basics.interfaces.communication;

public class Post implements MailSender {
    public void tramsportMail(){
        System.out.println("\n...из ящиков развозятся по всей земле на почтовых тройках с пьяными ямщиками и звонкими колокольцами. ");
    }

    @Override
    public String createMail(String mail) {
        System.out.println("\nКто-то пишет ржавым пером, макая его в пузырек с чернилами. Нацарапано: "+mail);
        return "Мятый лист бумаги с текстом: " + mail;
    }

    @Override
    public void sendMail(String mail) {
        System.out.println("\nПодписан адрес: На деревню дедушке. «Константину Макарычу»! "+mail);
        System.out.println("Письмо вброшено в какой-то первый попавшийся почтовый ящик");
    }
}
