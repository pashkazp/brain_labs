package ua.zp.brain.labs.oop.basics.lab17;


import java.util.Arrays;
import java.util.Objects;

/**
 * Simple Java object that represents Store
 *
 * @author Pavlo Degtyarev
 * @version 1.0
 */
public class Store {
    private String storeName;
    private String storeUrl;
    private User[] users;
    private User authorisedUser;

    /**
     * Create Store with given values
     *
     * @param storeName String specifies Store Name
     * @param storeUrl  String specifies website URL
     */
    public Store(String storeName, String storeUrl) {
        this.storeName = storeName;
        this.storeUrl = storeUrl;
    }

    /**
     * Set users with approved access to the store
     *
     * @param users Array of {@link User}'s
     */
    public void setUsers(User[] users) {
        this.users = users;
    }

    /**
     * Searches for the {@link User} with the specified login and password, authenticates him and remembers him for further work with him.
     * Return true if successful and false otherwise
     *
     * @param login    String that specifies the User login
     * @param password String that specifies the User password
     * @return boolean
     */
    public boolean login(String login, String password) {
        if (users == null) {
            return false;
        }
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                authorisedUser = user;
                return true;
            }

        }
        return false;
    }

    /**
     * Represents the rights of registered {@link User}
     */
    public void getCurrentUserRights() {
        if (authorisedUser == null) {
            return;
        }
        System.out.printf("\nЗдравствуйте, %s!", authorisedUser.getUserName());
        switch (authorisedUser.getRole()) {
            case ROLE_DIRECTOR:
                System.out.println("\nДиректор магазина, может управлять кадрами, и ценами");
                break;
            case ROLE_ADMIN:
                System.out.println("\nАдминистратор магазина, может добавлять товары и редактировать их описание");
                break;
            case ROLE_MANAGER:
                System.out.println("\nМенеджер магазина, может общаться с клиентами");
                break;
            case ROLE_CLIENT:
                System.out.println("\nКлиент магазина, может покупать товары и пользоваться дисконтом");
                break;
            case ROLE_USER:
                System.out.println("\nАнонимный пользователь, может покупать товары и\\или авторизоваться");
                break;
        }
    }


    /**
     * Performs user logon from the system if it is logged in.
     */
    public void logout() {
        if (authorisedUser == null) {
            return;
        }
        System.out.printf("\nПользователь \"%s\" вышел из системы.\n", authorisedUser.getUserName());
        authorisedUser = null;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return Objects.equals(storeName, store.storeName) &&
                Objects.equals(storeUrl, store.storeUrl) &&
                Arrays.equals(users, store.users) &&
                Objects.equals(authorisedUser, store.authorisedUser);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(storeName, storeUrl, authorisedUser);
        result = 31 * result + Arrays.hashCode(users);
        return result;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", storeUrl='" + storeUrl + '\'' +
                ", users=" + Arrays.toString(users) +
                ", authorisedUser=" + authorisedUser +
                '}';
    }
}
