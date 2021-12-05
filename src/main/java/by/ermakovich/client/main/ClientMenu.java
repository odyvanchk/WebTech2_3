package by.ermakovich.client.main;

import by.ermakovich.client.main.view.AdminViewer;
import by.ermakovich.client.main.view.AuthorizedUserViewer;
import by.ermakovich.client.main.view.GuestViewer;
import by.ermakovich.client.service.ClientService;
import by.ermakovich.client.service.ClientServiceFactory;
import by.ermakovich.entity.User;
import by.ermakovich.entity.UserRole;

import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class ClientMenu {
    private static User currentUser = new User(UserRole.UNAUTHUSER);
    private static ClientService service= ClientServiceFactory.getInstance().getClientService();

    public static void menu() throws IOException {

        while(currentUser != null) {
            currentUser = identification();
            if(currentUser != null) {
                switch (currentUser.getRole()) {
                    case ADMIN -> AdminViewer.view();
                    case AUTHUSER -> AuthorizedUserViewer.view();
                    case GUEST -> GuestViewer.view();
                    default -> {
                        return;
                    }
                }
            }
        }
    }

    public static User identification() throws IOException {
        System.out.println("Choose");
        System.out.println("1. Log in");
        System.out.println("2. Sign in");
        System.out.println("3. Exit");

        int i = 0;
        Scanner s = new Scanner(System.in);
        i = s.nextInt();
        currentUser = switch (i) {
           case 1 -> authorisation();
           case 2 -> registration();
           default -> null;
        };
        return currentUser;
    }

    private static User authorisation() throws IOException {
        User user = new User();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter login");
        user.setLogin(in.nextLine());

        System.out.println("Enter password");
        user.setHashPassword(in.nextLine().hashCode());
        User currentUser = service.login(user);
        if (currentUser != null){
            System.out.println("Hello " + user.getLogin());
        }
        else{
            System.out.println("Not found");
        }
        return currentUser;
    }

    private static User registration() throws IOException {
        User user = new User();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter login");
        user.setLogin(in.nextLine());

        System.out.println("Enter password");
        user.setHashPassword(in.nextLine().hashCode());

        user.setId(UUID.randomUUID().toString());

        System.out.println("Enter role");
        System.out.println("0. Authorised user");
        System.out.println("1. Admin");
        System.out.println("2. Guest");


        Scanner role = new Scanner(System.in);
        user.setRole(UserRole.values()[role.nextInt()]);

        User currentUser = service.signIn(user);

        if (currentUser != null){
            System.out.println("Hello " + user.getLogin());
        }
        else{
            System.out.println("Error");
        }
        return currentUser;
    }
}
