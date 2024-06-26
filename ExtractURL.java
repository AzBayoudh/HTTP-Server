
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Main {
  public static void main(String[] args) {
   // You can use print statements as follows for debugging, they'll be visible
    // when running tests.
    System.out.println("Logs from your program will appear here!");
     ServerSocket serverSocket = null;
     Socket clientSocket = null;
    
    
     try {
       serverSocket = new ServerSocket(4221);
       // Since the tester restarts your program quite often, setting SO_REUSEADDR
       // ensures that we don't run into 'Address already in use' errors
       serverSocket.setReuseAddress(true);
       clientSocket = serverSocket.accept(); // Wait for connection from client.
      

       BufferedReader buffReader = new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));

        String start = buffReader.readLine();
        System.out.println("Received request line: " + start);
        String requestURL = start.split(" ") [1];
        System.out.println("Extracted URL: " + requestURL);

        String answer;
        if (requestURL.equalsIgnoreCase("/")){
          answer = "HTTP/1.1 200 OK\r\n\r\n";
        } else {
          answer = "HTTP/1.1 404 Not Found\r\n\r\n";
        }

        clientSocket.getOutputStream().write(answer.getBytes());
        


         
          
     } catch (IOException e) {
       System.out.println("IOException: " + e.getMessage());
     }
    
  }

  }

