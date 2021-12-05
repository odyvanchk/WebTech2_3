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
    public boolean editStudentCase(StudentCase studentCase) throws IOException {
        return (boolean) socketManager.sendRequest(studentCase,RequestType.EDIT).getBody();
    }

    @Override
    public boolean createStudentCase(StudentCase studentCase) throws IOException {
        return (boolean) socketManager.sendRequest(studentCase, RequestType.CREATE).getBody();
    }

    @Override
    public StudentCase getStudentCaseById(int caseId) throws IOException {
        return (StudentCase) socketManager.sendRequest(caseId, RequestType.GETBYID).getBody();
    }

    @Override
    public User login(User user) throws IOException {
        return (User)socketManager.sendRequest(user, RequestType.LOGIN).getBody();
    }

    @Override
    public User signIn(User user) throws IOException {
        return (User) socketManager.sendRequest(user, RequestType.SIGNIN).getBody();
    }

    @Override
    public List<User> getUsers() throws IOException {
        return (List<User>) socketManager.sendRequest(null, RequestType.VIEWUSERS).getBody();
    }

}
