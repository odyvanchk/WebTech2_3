package client.service.Impl;

import client.DAO.ClientDAOFactory;
import client.service.ClientService;
import entity.Response;

import java.io.IOException;

public class ClientServiceImpl implements ClientService {
    @Override
    public Response getAllClients() throws IOException {
        return ClientDAOFactory.getInstance().getClientDAO().getAllClients();

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
