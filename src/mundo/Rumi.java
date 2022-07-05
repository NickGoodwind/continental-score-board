package mundo;

import java.util.ArrayList;

public class Rumi {
  ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
  
  public void agregarJugador(String nombre) {
    Jugador jugador = new Jugador(nombre);
    this.jugadores.add(jugador);
  }
  
  public Jugador buscarJugador(String nombre) {
    for (Jugador jugador : this.jugadores) {
      if (jugador.darNombre().equals(nombre))
        return jugador;
    } 
    return null;
  }
  
  public ArrayList<Jugador> darJugadores() {
    return this.jugadores;
  }
  
  public void aumentarPuntaje(String nombre, int puntaje) {
    Jugador jugador = buscarJugador(nombre);
    jugador.sumar(puntaje);
  }
  
  public ArrayList<Jugador> darJugadoresEnOrden(ArrayList<Jugador> jugadores, int cifraSignificativa) {
    if (jugadores.size() == 1 || cifraSignificativa == 0)
      return jugadores;
    
    ArrayList<ArrayList<Jugador>> ordenes = new ArrayList<ArrayList<Jugador>>();
    ArrayList<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
    
    byte b;
    for (b = 0; b < 10; b++) {
      ArrayList<Jugador> orden = new ArrayList<Jugador>();
      ordenes.add(orden);
    } 
    
    for (b = 0; b < jugadores.size(); b++) {
      if (((Jugador)jugadores.get(b)).darScore() <= 0) {
        jugadoresOrdenados.add(jugadores.get(b));
      } else {
        String str = ((Jugador)jugadores.get(b)).darScore() + "";
        if (str.length() == 3) {
          str = "0" + str;
        } else if (str.length() == 2) {
          str = "00" + str;
        } else if (str.length() == 1) {
          str = "000" + str;
        } 
        int i = Integer.parseInt(str.charAt(cifraSignificativa - 1) + "");
        ((ArrayList<Jugador>)ordenes.get(i)).add(jugadores.get(b));
      } 
    }
    
    for (b = 0; b < ordenes.size(); b++) {
      ArrayList<Jugador> orden = ordenes.get(b);
      for (byte b1 = 0; b1 < orden.size(); b1++)
        jugadoresOrdenados.add(orden.get(b1)); 
    } 
    return darJugadoresEnOrden(jugadoresOrdenados, cifraSignificativa - 1);
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/mundo/Rumi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */