package client.main.view;

import client.main.Methods;

import java.io.IOException;
import java.util.Scanner;

public class AdminViewer {

    public static void view() throws IOException {
        int act = -1;
        Scanner in = new Scanner(System.in);

        while (act != 6) {
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
                case 5 -> Methods.getUsers();
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
        System.out.println("5. get all users");
        System.out.println("6. log out");
    }
}
