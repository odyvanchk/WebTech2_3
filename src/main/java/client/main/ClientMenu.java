package client.main;

import client.service.ClientService;
import client.service.ClientServiceFactory;
import entity.StudentCase;
import entity.User;
import entity.UserRole;

import java.io.IOException;
import java.util.Scanner;

public class ClientMenu {
    private static User currentUser = new User(UserRole.GUEST);

    public static void menu() throws IOException {
        ClientServiceFactory serviceFactory = ClientServiceFactory.getInstance();
        ClientService service = serviceFactory.getClientService();

        currentUser = identification(service);



        int in = 1;

        while(in !=0){
            Scanner s = new Scanner(System.in);
            in = s.nextInt();
            switch (in){
                case 1 -> PrintStudentCaseInfo.print(service.getStudentCases());
                case 2 -> service.createStudentCase(new StudentCase());
            }
        }
    }

    public static User identification(ClientService service) throws IOException {
        System.out.println("Choose");
        System.out.println("1. Log in");
        System.out.println("2. Sign in");
        System.out.println("3. Exit");

        int i = 0;
        Scanner s = new Scanner(System.in);
        i = s.nextInt();
        switch (i) {
           case 1 -> {
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

           case 2 -> {
               User user = new User();
               Scanner in = new Scanner(System.in);

               System.out.println("Enter login");
               user.setLogin(in.nextLine());

               System.out.println("Enter password");
               user.setHashPassword(in.nextLine().hashCode());

               System.out.println("Enter role");
               System.out.println("1. Guest");
               System.out.println("2. Authorised user");
               if (currentUser.getRole().equals(UserRole.ADMIN)){
                   System.out.println("3. Admin");
               }
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

           case 3 -> {
                return null;
           }
        }
        return null;
    }
}
