package server;

import server.service.serverLauncher.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(8080);
        server.launchAndWait();


//        List<StudentCase> list = new ArrayList<>();
//        StudentCase s1 = new StudentCase("Vasya","Petrov",6.7,"POIT",1);
//        list.add(s1);
//        StudentCase s2 = new StudentCase("Valentina","Petrova",6.7,"POIT",2);
//        list.add(s2);
//        StudentCase s3 = new StudentCase("Vasya","Petrov",6.7,"POIT",3);
//        list.add(s3);
//        StudentCase s4 = new StudentCase("Vasya","Petrov",6.7,"POIT",4);
//        list.add(s4);
//
//
//        List<User> list1 = new ArrayList<>();
//        User u1 = new User("admin","admin".hashCode(), UserRole.ADMIN,1);
//        list1.add(u1);
//
//        User u2 = new User("Svetlana","1234".hashCode(), UserRole.AUTHUSER,2);
//        list1.add(u2);
//
//        User u3 = new User("Polina","flower".hashCode(), UserRole.AUTHUSER,3);
//        list1.add(u3);
//
//        User u4 = new User("Stanislav","admin1234".hashCode(), UserRole.ADMIN,4);
//        list1.add(u4);
//

    }
}
