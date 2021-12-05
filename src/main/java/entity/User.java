package entity;

import java.io.Serializable;

public class User implements Serializable {
    private String login;
    private int hashPassword;
    private UserRole role;
    private int id;

    public User() {}

    public User(String login, int hashPassword, UserRole role, int id) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.role = role;
        this.id = id;
    }

    public User(UserRole role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(int hashPassword) {
        this.hashPassword = hashPassword;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", hashPassword=" + hashPassword +
                ", role=" + role +
                ", id=" + id +
                '}';
    }
}
