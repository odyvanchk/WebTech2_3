package by.ermakovich.client.DAO;

import by.ermakovich.client.DAO.Impl.ClientDAOImpl;

public final class ClientDAOFactory {

    private static final ClientDAOFactory instance = new ClientDAOFactory();
    private final ClientDAO clientDAO = new ClientDAOImpl();

    private ClientDAOFactory() {}

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public static ClientDAOFactory getInstance() {
        return instance;
    }
}
