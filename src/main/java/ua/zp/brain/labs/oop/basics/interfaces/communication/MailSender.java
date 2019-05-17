package ua.zp.brain.labs.oop.basics.interfaces.communication;

public interface MailSender {

    String createMail(String mail);

    void sendMail(String mail);
}
