package server.service;

import entity.StudentCase;
import entity.User;

import java.util.List;

public interface ServerService {

    List<User> getAllClients();

    StudentCase getStudentById(int id);

    void editCaseByName(String name);

    void createCase(Object newCase);

}
