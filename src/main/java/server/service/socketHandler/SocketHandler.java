package server.service.socketHandler;

import entity.ClientRequest;
import entity.RequestType;
import server.service.ServerService;
import server.service.ServerServiceFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler extends Thread{
    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    public SocketHandler(Socket socket) throws IOException {
        socket = new Socket();
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());

        start();
    }

    @Override
    public void run() {
        try {
            ServerService service = ServerServiceFactory.getInstance().getServerService();
            while (true) {
                Object req = in.readObject();

                if (((ClientRequest) req).getRequestType() == RequestType.EXIT){
                    break;
                }


                switch (((ClientRequest) req).getRequestType()){
                    case EDIT -> service.editCaseByName((String) ((ClientRequest) req).getBody());
                    case VIEW -> send(service.getAllClients());
                    case CREATE -> service.createCase(req);
                }

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void send(Object resp) {
        try {
            out.writeObject(resp);
            out.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
