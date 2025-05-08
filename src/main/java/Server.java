import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер стартовал!");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    String infoFromClient = bufferedReader.readLine();
                    System.out.printf("Client port %d; Info from client: %s%n", clientSocket.getPort(), infoFromClient);
                    printWriter.println(clientSocket.getPort() + " Эта строчка отправлена с сервера");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
