package client.service;

import entity.StudentCase;
import entity.User;

import java.io.IOException;
import java.util.List;

public interface ClientService {
    List<StudentCase> getStudentCases() throws IOException;

    void editStudentCase(int caseId);

    void createStudentCase(StudentCase studentCase);

    StudentCase getStudentCaseById(int caseId);

    void login(User user);

    void signIn(User user);

    void saveStudentCases(List<StudentCase> list);

    void saveUsersList(List<User> list);

}
