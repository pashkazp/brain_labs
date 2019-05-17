package ua.zp.brain.labs.oop.basics.interfaces.communication;

class SmartPhone implements Caller, EmailSender {

    public void openApp(String appName) {
        System.out.println("Now app" + appName + " opened!");
    }

    @Override
    public void call(String contact) {
        System.out.println("Select in list and call to " + contact);
    }

    @Override
    public String createMail(String mail) {
        return "some mail " + mail;
    }

    @Override
    public void sendMail(String mail) {
        System.out.println(mail + " sended by internet!");
    }

    @Override
    public void editMail(String mail) {
        System.out.println("new mail " + mail);
    }

}

