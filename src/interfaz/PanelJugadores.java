package interfaz;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mundo.Jugador;

public class PanelJugadores extends JPanel {
  private static final long serialVersionUID = 578493698984433016L;
  
  private ArrayList<Jugador> jugadores;
  
  public PanelJugadores(ArrayList<Jugador> paramArrayList) {
    this.jugadores = paramArrayList;
    setOpaque(false);
    setLayout(new GridBagLayout());
    Font font = new Font("Chalkduster", 0, 12);
    JLabel jLabel1 = new JLabel("Jugadores");
    jLabel1.setFont(font);
    GridBagConstraints gridBagConstraints = new GridBagConstraints(0, 0, 2, 1, 0.0D, 0.0D, 10, 0, new Insets(5, 30, 30, 20), 0, 0);
    add(jLabel1, gridBagConstraints);
    JLabel jLabel2 = new JLabel("Puntos ronda");
    jLabel2.setFont(font);
    gridBagConstraints = new GridBagConstraints(2, 0, 4, 1, 0.0D, 0.0D, 10, 0, new Insets(5, 20, 30, 20), 0, 0);
    add(jLabel2, gridBagConstraints);
    JLabel jLabel3 = new JLabel("Total");
    jLabel3.setFont(font);
    gridBagConstraints = new GridBagConstraints(6, 0, 2, 1, 0.0D, 0.0D, 10, 0, new Insets(5, 20, 30, 30), 0, 0);
    add(jLabel3, gridBagConstraints);
    for (byte b = 0; b < this.jugadores.size(); b++) {
      Jugador jugador = this.jugadores.get(b);
      JLabel jLabel4 = new JLabel(jugador.darNombre());
      gridBagConstraints = new GridBagConstraints(0, b + 1, 2, 1, 0.0D, 0.0D, 10, 0, new Insets(0, 30, 10, 20), 0, 0);
      jLabel4.setFont(new Font("Comic Sans MS", 0, 12));
      add(jLabel4, gridBagConstraints);
      JTextField jTextField = new JTextField();
      gridBagConstraints = new GridBagConstraints(2, b + 1, 4, 1, 0.0D, 0.0D, 10, 0, new Insets(0, 20, 10, 30), 0, 0);
      jTextField.setPreferredSize(new Dimension(50, 25));
      add(jTextField, gridBagConstraints);
      JLabel jLabel5 = new JLabel(jugador.darScore() + "");
      gridBagConstraints = new GridBagConstraints(6, b + 1, 2, 1, 0.0D, 0.0D, 10, 0, new Insets(0, 20, 10, 20), 0, 0);
      jLabel5.setFont(new Font("Comic Sans MS", 0, 12));
      add(jLabel5, gridBagConstraints);
    } 
    setSize(new Dimension(400, this.jugadores.size() * 40 + 50));
    repaint();
  }
  
  public ArrayList<Integer> darPuntajes() {
    ArrayList<Integer> arrayList = new ArrayList();
    Component[] arrayOfComponent = getComponents();
    for (byte b = 0; b < arrayOfComponent.length; b++) {
      try {
        if (arrayOfComponent[b].getClass() == JTextField.class) {
          arrayList.add(Integer.valueOf(Integer.parseInt(((JTextField)arrayOfComponent[b]).getText())));
          ((JTextField)arrayOfComponent[b]).setText("");
        } 
      } catch (NumberFormatException numberFormatException) {
        JOptionPane.showMessageDialog(this, "No se han inscrito los puntajes de \n todos los jugadores.", "Información faltante", 0);
        return null;
      } 
    } 
    return arrayList;
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/interfaz/PanelJugadores.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */