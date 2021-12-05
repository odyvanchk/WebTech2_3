package client.main.view;

import client.main.Methods;
import client.main.printInfo.PrintStudentCaseInfo;
import client.service.ClientService;
import client.service.ClientServiceFactory;

import java.io.IOException;
import java.util.Scanner;

public class AuthorizedUserViewer {

    public static void view() throws IOException {
        int act = -1;
        Scanner in = new Scanner(System.in);

        while (act != 5) {
            printMenu();
            while(!in.hasNextInt()){
              in.next();
            }
            act = in.nextInt();
            switch (act) {
                case 1 -> Methods.getStudentCases();
                case 2 -> Methods.editStudentCase();
                case 3 -> Methods.createStudentCase();
                case 4 -> Methods.getStudentCaseById();
                default -> { return; }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Choose activity");
        System.out.println("1. get all student cases");
        System.out.println("2. edit student case by id");
        System.out.println("3. create new student case");
        System.out.println("4. get student case by id");
        System.out.println("5. log out");
    }
}
