package ua.zp.brain.labs.oop.basics.lab21;

public class User1 {
    private String name;
    private int old;
    private String phone;

    public User1(String name, int old, String phone) {
        this.name = name;
        this.old = old;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", phone='" + phone + '\'' +
                '}';
    }

}
