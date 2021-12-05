package server.DAO;

import entity.StudentCase;
import entity.User;

import java.util.List;

public interface ServerDAO {
    List<StudentCase> getAllStudents();

    void editStudentCase(int caseId);

    void createStudentCase(StudentCase studentCase);

    StudentCase getStudentCaseById(int caseId);

    void login(User user);

    void signIn(User user);

    void saveStudentCases(List<StudentCase> list);

    void saveUsersList(List<User> list);

}
