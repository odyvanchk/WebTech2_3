package by.ermakovich.server.DAO;

import by.ermakovich.entity.Response;
import by.ermakovich.entity.StudentCase;
import by.ermakovich.entity.User;

import java.util.List;

public interface ServerDAO {
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
