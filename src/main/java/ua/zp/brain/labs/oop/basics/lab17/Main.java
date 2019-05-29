package ua.zp.brain.labs.oop.basics.lab17;

import java.util.Scanner;

/**
 * Simple program that demonstrates the work of the {@link Store)
 */
public class Main {

    public static void main(String[] args) {
        Store store = new Store("Копеечка", "http://coin.ua");

        User[] users = initUsers();

        store.setUsers(users);

        System.out.printf("\nВас приветствует магазин \"%s\". Смотрите спецпредложения на сайте %s \n",
                store.getStoreName(), store.getStoreName());
        while (true) {
            tryLogin(store);
        }
    }

    /**
     * Creates some approved {@link User}'s and return it
     *
     * @return User[] array of approved users
     */
    public static User[] initUsers() {

        User[] users = new User[5];
        User user;

        user = new User("admin", "admin", "Admin Admin");
        user.setRole(UserRole.ROLE_ADMIN);
        users[0] = user;

        user = new User("user", "user", "User User");
        user.setRole(UserRole.ROLE_USER);
        users[1] = user;

        user = new User("client", "client", "Client Client");
        user.setRole(UserRole.ROLE_CLIENT);
        users[2] = user;

        user = new User("director", "director", "Director Director");
        user.setRole(UserRole.ROLE_DIRECTOR);
        users[3] = user;

        user = new User("manager", "manager", "Manager Manager");
        user.setRole(UserRole.ROLE_MANAGER);
        users[4] = user;

        return users;
    }

    /**
     * Requests login user data and tries to register it on the system
     *
     * @param store specifies Store to perform login
     */
    public static void tryLogin(Store store) {
        if (store == null) {
            return;
        }
        Scanner in = new Scanner(System.in);
        System.out.print("\nВведите логин: ");
        String login = in.next();
        System.out.print("\nВведите пароль: ");
        String pass = in.next();
        boolean logged = store.login(login, pass);
        if (!logged) {
            System.out.println("\nНеверный логин и\\или пароль");
        } else {
            store.getCurrentUserRights();
            store.logout();
        }
    }

}
