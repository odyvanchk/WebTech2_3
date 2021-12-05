package client;

import client.service.ClientService;
import client.service.ClientServiceFactory;
import entity.StudentCase;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientServiceFactory serviceFactory = ClientServiceFactory.getInstance();
        ClientService service = serviceFactory.getClientService();
        int in = 1;
        while(in !=0){
            Scanner s = new Scanner(System.in);
             in = s.nextInt();
            switch (in){
                case 1 -> System.out.println(service.getStudentCases().toString());
                case 2 -> service.createStudentCase(new StudentCase());
            }
        }

    }
}
