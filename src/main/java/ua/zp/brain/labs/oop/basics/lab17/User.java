package ua.zp.brain.labs.oop.basics.lab17;

import java.util.Objects;

/**
 * Simple Java object that represents User of {@link  Store}
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class User {
    private String login;
    private String password;
    private String userName;
    private UserRole role = UserRole.ROLE_USER;

    /**
     * Creates User with given values
     *
     * @param login    String that specifies User login
     * @param password String that specifies User password
     * @param userName String that specifies User Name
     */
    public User(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userName, user.userName) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, userName, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", role=" + role.getRole() +
                '}';
    }
}
