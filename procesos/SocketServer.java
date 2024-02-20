import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
  public static void main(String... args){
    try{
      while (true) {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Servidor esperando conexiones en el puerto 8080");
        
        Socket clientSocket = serverSocket.accept();
        System.out.println("Cliente conectado desde: "+clientSocket.getInetAddress());

        BufferedReader in = new BufferedReader((new InputStreamReader(clientSocket.getInputStream())));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String mensaje = in.readLine();
        System.out.println("MEnsaje recibido: "+mensaje);

        out.println("Mensaje recibido: "+mensaje);

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();  
      }
      

    } catch(IOException ex){
      ex.printStackTrace();
    }
  }
}
