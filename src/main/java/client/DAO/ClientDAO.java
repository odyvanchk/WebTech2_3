package client.DAO;

import entity.Response;

import java.io.IOException;

public interface ClientDAO {
    Response getAllClients() throws IOException;

    Response getStudentById(int id);

    void editCaseByName(String name);

    void createCase(Object newCase);

}
