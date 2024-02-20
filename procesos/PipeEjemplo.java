import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeEjemplo {
  public static void main(String... args){
    PipedInputStream inputStream = new PipedInputStream();
    PipedOutputStream outputStream = new PipedOutputStream();

    try {
      inputStream.connect(outputStream);

      Thread wriThread = new Thread(() -> {
        String mensaje = "Hola mundo desde un pipe en el modulo principal";
        try {
          outputStream.write(mensaje.getBytes());
          outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

      Thread readerThread = new Thread(()->{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        try {
          while((bytesRead = inputStream.read(buffer)) != -1){
            baos.write(buffer, 0, bytesRead);
          }
          System.out.println("Mensaje recibido desde el pipe: "+new String(baos.toByteArray()));
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

      wriThread.start();
      readerThread.start();

      wriThread.join();
      readerThread.join();

      inputStream.close();
      
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
