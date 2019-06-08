package ua.zp.brain.labs.oop.basics.lab21;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User1)) return false;
        User1 user1 = (User1) o;
        return old == user1.old &&
                Objects.equals(name, user1.name) &&
                Objects.equals(phone, user1.phone);
    }
}
