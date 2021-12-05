package client.DAO;

import entity.StudentCase;
import entity.User;

import java.io.IOException;
import java.util.List;

public interface ClientDAO {
    List<StudentCase> getStudentCases() throws IOException;

    void editStudentCase(int caseId);

    void createStudentCase(StudentCase studentCase);

    StudentCase getStudentCaseById(int caseId);

    User login(User user) throws IOException;

    User signIn(User user) throws IOException;

    void saveStudentCases(List<StudentCase> list);

    void saveUsersList(List<User> list);

}
