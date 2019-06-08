package ua.zp.brain.labs.oop.basics.lab21;

import java.util.Objects;

public class User2 {
    private String name;
    private int old;
    private String phone;

    public User2(String name, int old, String phone) {
        this.name = name;
        this.old = old;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User2)) return false;
        User2 user2 = (User2) o;
        return name.equals(user2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
