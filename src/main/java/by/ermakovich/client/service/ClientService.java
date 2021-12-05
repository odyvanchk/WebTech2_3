package by.ermakovich.client.service;

import by.ermakovich.entity.StudentCase;
import by.ermakovich.entity.User;

import java.io.IOException;
import java.util.List;

public interface ClientService {
    List<StudentCase> getStudentCases() throws IOException;

    List<User> getUsers() throws IOException;

    boolean editStudentCase(StudentCase studentCase) throws IOException;

    boolean createStudentCase(StudentCase studentCase) throws IOException;

    StudentCase getStudentCaseById(String caseId) throws IOException;

    User login(User user) throws IOException;

    User signIn(User user) throws IOException;


}
