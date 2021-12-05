package server.service;

import entity.Response;
import entity.StudentCase;
import entity.User;

import java.util.List;

public interface ServerService {

    Response getStudentCases();

    void editStudentCase(int caseId);

    void createStudentCase(StudentCase studentCase);

    Response getStudentCaseById(int caseId);

    Response login(User user);

    void signIn(User user);

    void saveStudentCases(List<StudentCase> list);

    void saveUsersList(List<User> list);

}
