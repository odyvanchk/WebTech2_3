package server.service.Impl;

import entity.Response;
import entity.StudentCase;
import entity.User;
import server.DAO.ServerDAO;
import server.DAO.ServerDAOFactory;
import server.service.ServerService;

import java.util.List;

public class ServerServiceImpl implements ServerService {

    @Override
    public Response getStudentCases() {
        ServerDAOFactory factory = ServerDAOFactory.getInstance();
        ServerDAO serverDAO = factory.getServerDAO();
        return serverDAO.getStudentCases();
    }

    @Override
    public void editStudentCase(int caseId) {

    }

    @Override
    public void createStudentCase(StudentCase studentCase) {

    }

    @Override
    public Response getStudentCaseById(int caseId) {
        return null;
    }

    @Override
    public void login(User user) {

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
