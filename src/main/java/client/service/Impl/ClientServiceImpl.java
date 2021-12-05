package client.service.Impl;

import client.DAO.ClientDAOFactory;
import client.service.ClientService;
import entity.StudentCase;
import entity.User;

import java.io.IOException;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    @Override
    public List<StudentCase> getStudentCases() throws IOException {
        return ClientDAOFactory.getInstance().getClientDAO().getStudentCases();

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
     return ClientDAOFactory.getInstance().getClientDAO().login(user);
    }

    @Override
    public User signIn(User user) throws IOException {
        return ClientDAOFactory.getInstance().getClientDAO().signIn(user);
    }

    @Override
    public void saveStudentCases(List<StudentCase> list) {

    }

    @Override
    public void saveUsersList(List<User> list) {

    }
}
