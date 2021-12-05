package client.DAO.Impl;

import client.DAO.ClientDAO;
import client.DAO.socketManager.SocketManager;
import entity.RequestType;
import entity.Response;
import entity.StudentCase;
import entity.User;

import java.io.IOException;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    SocketManager socketManager = new SocketManager("localhost",8080);

    @Override
    public List<StudentCase> getStudentCases() throws IOException {
        Response response = socketManager.sendRequest(null, RequestType.VIEW);
        return (List<StudentCase>) response.getBody();
    }


    @Override
    public void editStudentCase(int caseId) {

    }

    @Override
    public void createStudentCase(StudentCase studentCase) {

    }

    @Override
    public StudentCase getStudentCaseById(int caseId) {
        return null;
    }

    @Override
    public User login(User user) throws IOException {
        return (User)socketManager.sendRequest(user, RequestType.LOGIN).getBody();
    }

    @Override
    public void signIn(User user) {

    }

    @Override
    public void saveStudentCases(List<StudentCase> list) {

    }

    @Override
    public void saveUsersList(List<User> list) {

    }
}
