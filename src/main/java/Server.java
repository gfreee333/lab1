import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
// todo такс вроде если я правильно понимаю такой сервер на ТСР соединение основанный , пока не понимаю окончательно, как допиливать, но примено вроде как понял, что можно поменять
public class Server extends Thread {
    ServerSocket serverSocket; // Определяется переменная serverSocket
    public Server() {
        try {

            serverSocket = new ServerSocket(1001);
            System.out.println(serverSocket.toString());
        } catch (IOException e) {
            fail(e, "Could not start server.");
        }
        System.out.println("Server is running . . .");
        /* Стартует поток */
        this.start();
    }
    public static void fail(Exception e, String str) {
        System.out.println(str + "." + e);
    }
    public void run() {
        try {
            while (true) {
                /* Принимаются запросы от клиентов */
                Socket client = serverSocket.accept();
                Connection con = new Connection(client);
            }
        } catch (IOException e) {
            fail(e, "Not listening");
        }
    }
    public static void main(String[] args) {
        /* Запускается сервер */
        new Server();
    }
}
class Connection extends Thread {
    /* Declare the variables */
    protected Socket netClient;
    protected BufferedReader fromClient;
    protected PrintStream toClient;
    // todo вот сюда вроде как нужно будет добавить подключение нескольких клиентов на серверЮ просто не до конца понимаю, с помощью cnnection уже реализация есть или нет
    //todo глянь как несколько припиздячить в serverTest через простой цикл for реализовывал
    public Connection(Socket client) {
        netClient = client;
        try {
/* Создается входной поток, чтобы принимать данные от
клиента */
            fromClient = new BufferedReader(new
                    InputStreamReader(
                    netClient.getInputStream()));
/* Создается выходной поток, чтобы посылать данные
клиенту */
            toClient = new
                    PrintStream(netClient.getOutputStream());
        } catch (IOException e) {
            try {
                /* Закрывается сокет клиента */
                netClient.close();
            } catch (IOException e1) {
                System.err.println("Unable to set up streams" +
                        e1);
                return;
            }
        }
        /* Start the thread */
        this.start();
    }
    // todo вроде как просто можно изменить метод  run  на обработку и подачу информации сервера клиенту , чтобы все окей с работой было
    //todo (простым языком , а не моим словесным поносом) ( просто переписать реализацию игры в run )
    public void run() {
        String login, password;
        try {
            while (true) {
                toClient.println("Login: ");
                /* Принимается login как ввод от клиента */
                login = fromClient.readLine();
/* Завершить соединение, когда Bye вводится как
login */
                if (login == null || login.equals("Bye")) {
                    System.out.println("Exit");
                    return;
                } else
                    System.out.println(login + " logged in");
// Посылается подтверждение клиенту
                            toClient.println("Password: ");
                /* Принимается пароль то клиента */
                password = fromClient.readLine();
            }
        } catch (IOException e) {
        } finally {
            try {
                netClient.close();
            } catch (IOException e) {
            }
        }
    }
}