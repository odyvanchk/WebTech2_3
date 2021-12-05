package server.service.socketHandler;

import entity.ClientRequest;
import entity.Response;
import entity.User;
import server.service.ServerService;
import server.service.ServerServiceFactory;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler extends Thread{
    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    public SocketHandler(Socket socket) throws IOException {

        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());

        start();
    }

    @Override
    public void run() {
        try {
            ServerService service = ServerServiceFactory.getInstance().getServerService();
            while (true) {
                ClientRequest req = (ClientRequest) in.readObject();
                Response response = switch (((ClientRequest) req).getRequestType()) {

                    //case EDIT -> service.editStudentCase((int) ((ClientRequest) req).getBody());
                    case VIEW -> service.getStudentCases();
                    //case CREATE -> service.createStudentCase((StudentCase) ((ClientRequest) req).getBody());
                    case LOGIN -> service.login((User) req.getBody());
                    case SIGNIN -> service.signIn((User) req.getBody());
                     default -> null;
                };
                send(response);
            }

        }catch (EOFException ignored){}

        catch (IOException | ClassNotFoundException e) {
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
