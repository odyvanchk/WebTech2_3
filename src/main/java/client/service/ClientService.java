package client.service;

import entity.Response;

import java.io.IOException;

public interface ClientService {
    Response getAllClients() throws IOException;

    Response getStudentById(int id);

    void editCaseByName(String name);

    void createCase(Object newCase);

}
