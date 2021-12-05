package client.DAO.Impl;

import client.DAO.ClientDAO;
import client.DAO.socketManager.SocketManager;
import entity.RequestType;
import entity.Response;

import java.io.IOException;

public class ClientDAOImpl implements ClientDAO {
    SocketManager socketManager = new SocketManager("localhost",8080);

    @Override
    public Response getAllClients() throws IOException {
        return socketManager.sendRequest(new Object(), RequestType.VIEW);
    }

    @Override
    public Response getStudentById(int id) {
        return null;
    }

    @Override
    public void editCaseByName(String name) {

    }

    @Override
    public void createCase(Object newCase) {

    }
}
