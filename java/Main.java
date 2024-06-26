import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args) {
   
     ServerSocket serverSocket;
     Socket clientSocket;
    
     try {
       serverSocket = new ServerSocket(4221);
       // Since the tester restarts your program quite often, setting SO_REUSEADDR
       // ensures that we don't run into 'Address already in use' errors
       clientSocket = serverSocket.accept(); // Wait for connection from client.
       System.out.println("accepted new connection");
     } catch (IOException e) {
       System.out.println("IOException: " + e.getMessage());
     }
  }
}
