package by.ermakovich.client.service.Impl;

import by.ermakovich.client.DAO.ClientDAOFactory;
import by.ermakovich.client.service.ClientService;
import by.ermakovich.entity.StudentCase;
import by.ermakovich.entity.User;

import java.io.IOException;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    @Override
    public List<StudentCase> getStudentCases() throws IOException {
        return ClientDAOFactory.getInstance().getClientDAO().getStudentCases();
    }

    @Override
    public List<User> getUsers() throws IOException {
        return ClientDAOFactory.getInstance().getClientDAO().getUsers();
    }

    @Override
    public boolean editStudentCase(StudentCase studentCase) throws IOException {
        return ClientDAOFactory.getInstance().getClientDAO().editStudentCase(studentCase);
    }

    @Override
    public boolean createStudentCase(StudentCase studentCase) throws IOException {
        return ClientDAOFactory.getInstance().getClientDAO().createStudentCase(studentCase);
    }

    @Override
    public StudentCase getStudentCaseById(String caseId) throws IOException {
        return ClientDAOFactory.getInstance().getClientDAO().getStudentCaseById(caseId);
    }

    @Override
    public User login(User user) throws IOException {
     return ClientDAOFactory.getInstance().getClientDAO().login(user);
    }

    @Override
    public User signIn(User user) throws IOException {
        return ClientDAOFactory.getInstance().getClientDAO().signIn(user);
    }

}
