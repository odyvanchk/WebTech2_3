package by.ermakovich.client.main.view;

import by.ermakovich.client.main.UseCases;

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
                case 1 -> UseCases.getStudentCases();
                case 2 -> UseCases.editStudentCase();
                case 3 -> UseCases.createStudentCase();
                case 4 -> UseCases.getStudentCaseById();
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
