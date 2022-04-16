import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
  //todo пытася понять как работает ебучие подключение нескольких клиентов, понял, что цикл нужен 100 из 100 вроде как
public class ServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket;
        final Socket[] clientSockets;
        serverSocket = new ServerSocket(7777);
        System.out.print("Сервер готов к работе: \n " + "-----------------------");
        clientSockets = new Socket[2];
        for( int i = 0; i < clientSockets.length ; i++ )
        {
            clientSockets[i] = serverSocket.accept();
            System.out.println("\n Клиент: " + (i+1) + " подключился");
            System.out.println("\n" + clientSockets[i]);
        }
        for(int i=0; i<clientSockets.length; i++)
        {

        }
    }
}
