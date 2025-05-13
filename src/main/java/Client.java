import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("netology.homework", Server.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            Scanner scanner = new Scanner(System.in);

            String serverResponse = in.readLine();
            System.out.println(serverResponse);
            String name = scanner.nextLine();
            out.println(name);

            serverResponse = in.readLine();
            System.out.println(serverResponse);
            String isChild = scanner.nextLine();
            out.println(isChild);

            serverResponse = in.readLine();
            System.out.println(serverResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
