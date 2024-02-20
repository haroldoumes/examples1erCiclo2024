import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
  public static void main(String... args){
    try{
      Socket socket = new Socket("127.0.0.1", 8080);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      out.println("Hol servidor, ¿Cómo estás?");

      String response = in.readLine();
      System.out.println("Respuesta del servidor: "+response);

      in.close();
      out.close();
      socket.close();
    }catch(IOException ex){
      ex.printStackTrace();
    }
  }
}
