package server.service;

import entity.Response;
import entity.StudentCase;
import entity.User;

import java.util.List;

public interface ServerService {

    Response getStudentCases();

    Response editStudentCase(StudentCase studentCase);

    Response createStudentCase(StudentCase studentCase);

    Response getStudentCaseById(String caseId);

    Response login(User user);

    Response signIn(User user);

    Response getUsers();

    void saveStudentCases(List<StudentCase> list);

    void saveUsersList(List<User> list);


}
