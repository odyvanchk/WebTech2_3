package by.ermakovich.client.main.printInfo;

import by.ermakovich.entity.User;

import java.util.List;

public class PrintUserInfo {
    public static void print(List<User> users) {
        for (User user: users) {
            System.out.println(user.toString());
        }
    }
}
