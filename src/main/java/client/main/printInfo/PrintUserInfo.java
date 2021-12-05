package client.main.printInfo;

import entity.User;

import java.util.List;

public class PrintUserInfo {
    public static void print(List<User> users) {
        for (User user: users) {
            System.out.println(user.toString());
        }
    }
}
