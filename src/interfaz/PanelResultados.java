package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mundo.Jugador;

public class PanelResultados extends JPanel implements ActionListener {
  private static final long serialVersionUID = -1539197777235667582L;
  
  private static final String NUEVA = "nueva";
  
  private InterfazRumi principal;
  
  private ArrayList<Jugador> jugadores;
  
  private JButton nueva;
  
  public PanelResultados(InterfazRumi paramInterfazRumi, ArrayList<Jugador> paramArrayList) {
    this.jugadores = paramArrayList;
    this.principal = paramInterfazRumi;
    setOpaque(false);
    setLayout(new GridBagLayout());
    JLabel jLabel1 = new JLabel("1ª Posición:");
    GridBagConstraints gridBagConstraints = new GridBagConstraints(0, 0, 2, 1, 0.0D, 0.0D, 10, 0, new Insets(30, 10, 0, 0), 0, 0);
    Font font = new Font("Comic Sans MS", 1, 13);
    jLabel1.setFont(font);
    jLabel1.setForeground(new Color(255, 215, 0));
    add(jLabel1, gridBagConstraints);
    JLabel jLabel2 = new JLabel(((Jugador)this.jugadores.get(0)).darNombre());
    gridBagConstraints = new GridBagConstraints(2, 0, 2, 1, 0.0D, 0.0D, 10, 0, new Insets(30, 10, 0, 0), 0, 0);
    jLabel2.setFont(font);
    jLabel2.setForeground(new Color(255, 215, 0));
    add(jLabel2, gridBagConstraints);
    for (byte b = 1; b < this.jugadores.size(); b++) {
      gridBagConstraints = new GridBagConstraints(0, b + 1, 2, 1, 0.0D, 0.0D, 10, 0, new Insets(10, 10, 0, 0), 0, 0);
      add(new JLabel((b + 1) + "ª Posición:"), gridBagConstraints);
      gridBagConstraints = new GridBagConstraints(2, b + 1, 2, 1, 0.0D, 0.0D, 10, 0, new Insets(10, 10, 0, 0), 0, 0);
      add(new JLabel(((Jugador)this.jugadores.get(b)).darNombre()), gridBagConstraints);
    } 
    this.nueva = new JButton("Nueva partida");
    this.nueva.addActionListener(this);
    this.nueva.setActionCommand("nueva");
    gridBagConstraints = new GridBagConstraints(0, -1, 4, 1, 0.0D, 0.0D, 10, 0, new Insets(20, 10, 0, 0), 0, 0);
    add(this.nueva, gridBagConstraints);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    String str = paramActionEvent.getActionCommand();
    if (str.equals("nueva")) {
      this.principal.dispose();
      InterfazRumi.main(null);
    } 
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/interfaz/PanelResultados.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */