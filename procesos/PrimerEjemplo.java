public class PrimerEjemplo {

  public static void main(String... args){

    Contador conteo = new Contador();

    ContadorThread contadorThread = new ContadorThread();
    Thread hilo1 = new Thread(contadorThread);
    hilo1.start();

    Thread hilo2 = new Thread(() -> {
        System.out.println("Mostrando mensaje en una clase anonima");
        for(int i = 0;i<1000;i++){
          conteo.incrementar();
        }
    });

    Thread hilo3 = new Thread(() -> {
      System.out.println("Mostrando mensaje en una clase anonima");
      for(int i = 0;i<1000;i++){
        conteo.incrementar();
      }
    });
    hilo2.start();
    hilo3.start();
    try{
      hilo2.join();
      hilo3.join();
    }catch(InterruptedException ex){
      ex.printStackTrace();
    }
    System.out.println("El conteo final es: "+conteo.getConteo());
    
  }

}