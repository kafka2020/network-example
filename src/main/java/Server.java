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
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.println("New connection accepted");

                    out.println("Write your name");
                    final String name = in.readLine();
                    System.out.printf("Client name: %s\n", name);

                    out.println("Are you a child? (yes/no):");
                    String isChild = in.readLine();
                    System.out.printf("Client is child: %s\n", isChild);

                    if ("yes".equalsIgnoreCase(isChild)) {
                        out.println("Welcome to the kids area, " + name + "! Let's play!");
                    } else {
                        out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
