package ua.zp.brain.labs.oop.basics.lab21;

import java.util.Objects;

public class User3 {
    private String name;
    private int old;
    private String phone;

    public User3(String name, int old, String phone) {
        this.name = name;
        this.old = old;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User3{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User3)) return false;
        User3 user3 = (User3) o;
        return old == user3.old &&
                name.equals(user3.name) &&
                phone.equals(user3.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, old, phone);
    }
}
