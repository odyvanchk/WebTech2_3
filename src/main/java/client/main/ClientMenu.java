package client.main;

import client.service.ClientService;
import client.service.ClientServiceFactory;
import entity.StudentCase;
import entity.User;

import java.io.IOException;
import java.util.Scanner;

public class ClientMenu {
    public static void menu() throws IOException {
        ClientServiceFactory serviceFactory = ClientServiceFactory.getInstance();
        ClientService service = serviceFactory.getClientService();

        identification(service);



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
                   System.out.println("Hello" + user.getLogin());
               }
               else{
                   System.out.println("Not found");
               }
               return currentUser;
           }

           case 2 -> {

           }
           
           case 3 -> {
                return null;
           }
        }
        return null;
    }
}
