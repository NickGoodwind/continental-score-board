package mundo;

import java.util.ArrayList;

public class Rumi {
  ArrayList<Jugador> jugadores = new ArrayList<>();
  
  public void agregarJugador(String paramString) {
    Jugador jugador = new Jugador(paramString);
    this.jugadores.add(jugador);
  }
  
  public Jugador buscarJugador(String paramString) {
    for (Jugador jugador : this.jugadores) {
      if (jugador.darNombre().equals(paramString))
        return jugador; 
    } 
    return null;
  }
  
  public ArrayList<Jugador> darJugadores() {
    return this.jugadores;
  }
  
  public void aumentarPuntaje(String paramString, int paramInt) {
    Jugador jugador = buscarJugador(paramString);
    jugador.sumar(paramInt);
  }
  
  public ArrayList<Jugador> darJugadoresEnOrden(ArrayList<Jugador> paramArrayList, int paramInt) {
    if (paramArrayList.size() == 1)
      return paramArrayList; 
    ArrayList<ArrayList> arrayList = new ArrayList();
    ArrayList<Jugador> arrayList1 = new ArrayList();
    if (paramInt == 0)
      return paramArrayList; 
    byte b;
    for (b = 0; b < 10; b++) {
      ArrayList arrayList2 = new ArrayList();
      arrayList.add(arrayList2);
    } 
    for (b = 0; b < paramArrayList.size(); b++) {
      if (((Jugador)paramArrayList.get(b)).darScore() == 0) {
        arrayList1.add(paramArrayList.get(b));
      } else {
        String str = ((Jugador)paramArrayList.get(b)).darScore() + "";
        if (str.length() == 3) {
          str = "0" + str;
        } else if (str.length() == 2) {
          str = "00" + str;
        } else if (str.length() == 1) {
          str = "000" + str;
        } 
        int i = Integer.parseInt(str.charAt(paramInt - 1) + "");
        ((ArrayList)arrayList.get(i)).add(paramArrayList.get(b));
      } 
    } 
    for (b = 0; b < arrayList.size(); b++) {
      ArrayList arrayList2 = arrayList.get(b);
      for (byte b1 = 0; b1 < arrayList2.size(); b1++)
        arrayList1.add(arrayList2.get(b1)); 
    } 
    return darJugadoresEnOrden(arrayList1, paramInt - 1);
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/mundo/Rumi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */