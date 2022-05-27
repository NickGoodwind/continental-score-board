package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mundo.Jugador;
import mundo.Rumi;

public class InterfazRumi extends JFrame {
  private static final long serialVersionUID = 8506405474135124759L;
  
  private Rumi mundo;
  
  private PanelFondo centro;
  
  private PanelSuperior banner;
  
  private PanelJugadores jugadores;
  
  private PanelBotones botones;
  
  private PanelResultados resultados;
  
  public InterfazRumi() {
    setLayout(new BorderLayout());
    setTitle("Rumi - Juego para toda la familia");
    setDefaultCloseOperation(2);
    this.centro = new PanelFondo();
  }
  
  public void run() {
    this.mundo = new Rumi();
    String str = JOptionPane.showInputDialog("Escriba el número de jugadores");
    int i = 0;
    while (!i) {
      try {
        i = Integer.parseInt(str);
      } catch (NumberFormatException numberFormatException) {
        JOptionPane.showMessageDialog(this, "No es un número válido", "Error", 0);
        str = JOptionPane.showInputDialog("Escriba el número de jugadores");
      } 
    } 
    int j;
    for (j = 0; j < i; j++) {
      String str1 = JOptionPane.showInputDialog("Escriba el nombre del jugador " + (j + 1));
      this.mundo.agregarJugador(str1);
    } 
    this.banner = new PanelSuperior();
    this.jugadores = new PanelJugadores(this.mundo.darJugadores());
    this.botones = new PanelBotones(this);
    this.centro.add(this.banner, "North");
    this.centro.add(this.jugadores, "Center");
    this.centro.add(this.botones, "South");
    j = this.banner.getWidth();
    int k = this.banner.getHeight() + this.jugadores.getHeight() + this.botones.getHeight();
    setSize(new Dimension(j, k));
    add(this.centro);
  }
  
  public void sumarPuntos() {
    ArrayList<Integer> arrayList = this.jugadores.darPuntajes();
    ArrayList<Jugador> arrayList1 = this.mundo.darJugadoresEnOrden(this.mundo.darJugadores(), 4);
    if (arrayList != null)
      for (byte b = 0; b < this.mundo.darJugadores().size(); b++)
        ((Jugador)arrayList1.get(b)).sumar(((Integer)arrayList.get(b)).intValue());  
  }
  
  public void terminarPartida() {
    this.resultados = new PanelResultados(this, this.mundo.darJugadoresEnOrden(this.mundo.darJugadores(), 4));
    this.centro.cambiarFondo();
    this.centro.removeAll();
    this.centro.add(this.resultados, "Center");
    this.centro.validate();
    this.centro.repaint();
  }
  
  public void refrescar() {
    this.centro.remove(this.jugadores);
    this.jugadores = new PanelJugadores(this.mundo.darJugadoresEnOrden(this.mundo.darJugadores(), 4));
    this.centro.add(this.jugadores, "Center");
    this.centro.validate();
    this.centro.repaint();
  }
  
  public boolean hayJugadores() {
    return (this.mundo.darJugadores().size() != 0);
  }
  
  public static void main(String[] paramArrayOfString) {
    InterfazRumi interfazRumi = new InterfazRumi();
    interfazRumi.run();
    interfazRumi.setVisible(true);
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/interfaz/InterfazRumi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */