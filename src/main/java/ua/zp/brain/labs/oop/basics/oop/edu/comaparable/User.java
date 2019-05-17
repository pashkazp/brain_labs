package ua.zp.brain.labs.oop.basics.oop.edu.comaparable;

import java.util.Arrays;

public class User implements Comparable <User>{
    //добавляем возможность сравнивать объекты User
    private String name;
    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override //реализуем метод compareTo интерфейса Comparable
    public int compareTo(User o) { //используем метод compareTo из класса String для сравнения строк
        int result = this.name.compareTo(o.name);

        //если имена одинаковые - сравниваем возраст, используя метод compareTo из класса Integer
        if (result == 0) {
            result = this.age.compareTo(o.age);
        }
        return result;
    }

    public static void main(String[] args) {
        User user1 = new User("Sasha", 12);
        User user2 = new User("Oksana", 10);
        User user3 = new User("David", 14);
        User user4 = new User("David", 12);
        User user5 = new User("Igor", 12);

        User[] users = {user1, user2, user3, user4, user5};

        for (User user : users){
            System.out.println(user.name + " " + user.age);
        }
        System.out.println();
        Arrays.sort(users);

        for (User user : users){
            System.out.println(user.name + " " + user.age);
        }
    }
}
