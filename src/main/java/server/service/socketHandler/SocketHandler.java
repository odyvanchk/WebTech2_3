package server.service.socketHandler;

import entity.ClientRequest;
import entity.Response;
import entity.StudentCase;
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

                    case GETBYID -> service.getStudentCaseById((int) req.getBody());
                    case EDIT -> service.editStudentCase((StudentCase) req.getBody());
                    case VIEW -> service.getStudentCases();
                    case CREATE -> service.createStudentCase((StudentCase)req.getBody());
                    case LOGIN -> service.login((User) req.getBody());
                    case SIGNIN -> service.signIn((User) req.getBody());
                    case VIEWUSERS -> service.getUsers();
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
