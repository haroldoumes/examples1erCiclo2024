public class Contador {
  private Integer conteo = 0;

  public void incrementar(){
    this.conteo++;
    try {
      Thread.sleep(100);
    }catch(InterruptedException ex){
      ex.printStackTrace();
    }
  }

  public Integer getConteo(){
    return this.conteo;
  }
}
