package mundo;

public class Jugador {
  private String nombre;
  
  private int score;
  
  public Jugador(String paramString) {
    this.nombre = paramString;
    this.score = 0;
  }
  
  public String darNombre() {
    return this.nombre;
  }
  
  public int darScore() {
    return this.score;
  }
  
  public void sumar(int paramInt) {
    this.score += paramInt;
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/mundo/Jugador.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */