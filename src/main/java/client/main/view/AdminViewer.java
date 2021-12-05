package client.main.view;

import client.main.printInfo.PrintStudentCaseInfo;
import client.main.printInfo.PrintUserInfo;
import client.service.ClientService;
import client.service.ClientServiceFactory;
import entity.StudentCase;

import java.io.IOException;
import java.util.Scanner;

public class AdminViewer {
    private static ClientService service = ClientServiceFactory.getInstance().getClientService();

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
                case 1 -> {
                    PrintStudentCaseInfo.printAll(service.getStudentCases());
                }
                case 2 -> {
                    StudentCase studentCase = new StudentCase();

                    System.out.println("Enter id ");
                    studentCase.setId(in.nextInt());
                    in.nextLine();

                    System.out.println("Enter name ");
                    studentCase.setName(in.nextLine());

                    System.out.println("Enter surname");
                    studentCase.setSurname(in.nextLine());

                    System.out.println("Enter GPA");
                    studentCase.setGPA(in.nextDouble());
                    in.nextLine();

                    System.out.println("Enter Speciality");
                    studentCase.setSpeciality(in.nextLine());

                    service.editStudentCase(studentCase);
                }
                case 3 -> {
                    in.nextLine();
                    StudentCase studentCase = new StudentCase();
                    System.out.println("Enter name ");
                    studentCase.setName(in.nextLine());

                    System.out.println("Enter surname");
                    studentCase.setSurname(in.nextLine());

                    System.out.println("Enter GPA");
                    studentCase.setGPA(in.nextDouble());
                    in.nextLine();

                    System.out.println("Enter Speciality");
                    studentCase.setSpeciality(in.nextLine());

                    studentCase.setId(4);

                    if (service.createStudentCase(studentCase)){
                        System.out.println("Success");
                    }
                    else{
                        System.out.println("Error");
                    }
                }
                case 4 -> {
                    System.out.println("Enter id ");
                    int id = in.nextInt();

                    PrintStudentCaseInfo.printOne(service.getStudentCaseById(id));
                }
                case 5 -> {
                    PrintUserInfo.print(service.getUsers());
                }
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
