package client.DAO.socketManager;

import entity.ClientRequest;
import entity.RequestType;
import entity.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketManager {
    private String ip = "localhost";
    private final int port;

    public SocketManager(String ip , int port) {
        this.port = port;
        this.ip = ip;
    }

    public SocketManager(int port) {
        this.port = port;
    }




    public Response sendRequest(Object body, RequestType requestType) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket(ip, port);
            ObjectInputStream in = new ObjectInputStream( socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            ClientRequest request = new ClientRequest(body, requestType);

            out.writeObject(request);
            out.flush();

            Response response = (Response) in.readObject();

            socket.close();
            in.close();
            out.close();

            return response;
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}

