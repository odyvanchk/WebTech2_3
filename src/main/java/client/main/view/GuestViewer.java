package client.main.view;

import client.main.printInfo.PrintStudentCaseInfo;
import client.service.ClientService;
import client.service.ClientServiceFactory;

import java.io.IOException;
import java.util.Scanner;

public class GuestViewer {
    private static ClientService service = ClientServiceFactory.getInstance().getClientService();

    public static void view() throws IOException {
        int act = -1;
        Scanner in = new Scanner(System.in);

        while (act != 3) {
            printMenu();
            while(!in.hasNextInt()){
                in.next();
            }
            act = in.nextInt();

            switch (act) {
                case 1 -> {
                    PrintStudentCaseInfo.printAll(service.getStudentCases());
                }
                case 2 -> {
                    System.out.println("Enter id ");
                    int id = in.nextInt();

                    PrintStudentCaseInfo.printOne(service.getStudentCaseById(id));
                }
                default -> { return; }
            }
        }
    }
    private static void printMenu(){
        System.out.println("Choose activity");
        System.out.println("1. get all student cases");
        System.out.println("2. get student case by id");
        System.out.println("3. log out");
    }
}
