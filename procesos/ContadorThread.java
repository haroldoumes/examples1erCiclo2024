public class ContadorThread implements Runnable {
  @Override
  public void run(){
    System.out.println("Ejecutando tarea");
    try {
      Thread.sleep(1000);
    }catch(InterruptedException ex){
      ex.printStackTrace();
    }
  }
  
}
