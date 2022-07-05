package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mundo.Jugador;

public class PanelResultados extends JPanel implements ActionListener {
  private static final long serialVersionUID = -1539197777235667582L;
  
  private static final String NUEVA = "nueva";
  private static final String VOLVER = "volver";
  private static final String CERRAR = "cerrar";
  
  private JFrame principal;
  
  private ArrayList<Jugador> jugadores;
  
  public PanelResultados(JFrame frame, ArrayList<Jugador> jugadores) {
    this.jugadores = jugadores;
    this.principal = frame;
    setOpaque(false);
    setLayout(new GridBagLayout());
    
    JLabel primer = new JLabel("1ª Posición:");
    GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_END, 0, new Insets(30, 50, 0, 0), 0, 0);
    primer.setForeground(new Color(255, 215, 0));
    add(primer, gbc);
    
    JLabel nombre = new JLabel(((Jugador)this.jugadores.get(0)).darNombre());
    gbc = new GridBagConstraints(GridBagConstraints.RELATIVE, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, 0, new Insets(30, 0, 0, 0), 0, 0);
    nombre.setForeground(new Color(255, 215, 0));
    add(nombre, gbc);
    
    byte b;
    for (b = 1; b < this.jugadores.size(); b++) {
      gbc = new GridBagConstraints(0, b, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_END, 0, new Insets(10, 50, 0, 0), 0, 0);
      add(new JLabel((b + 1) + "ª Posición:"), gbc);
      gbc = new GridBagConstraints(GridBagConstraints.RELATIVE, b, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, 0, new Insets(10, 0, 0, 0), 0, 0);
      add(new JLabel(((Jugador)this.jugadores.get(b)).darNombre()), gbc);
    } 
    
    JPanel botones = new JPanel();
    gbc = new GridBagConstraints(0, GridBagConstraints.RELATIVE, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, 0, new Insets(20, 0, 0, 0), 0, 0);
    add(botones, gbc);

    JButton nueva = new JButton("Nueva partida");
    nueva.addActionListener(this);
    nueva.setActionCommand(PanelResultados.NUEVA);
    botones.add(nueva);
    
    JButton volver = new JButton("Volver");
    volver.addActionListener(this);
    volver.setActionCommand(PanelResultados.VOLVER);
    botones.add(volver);
    
    JButton cerrar = new JButton("Cerrar");
    cerrar.addActionListener(this);
    cerrar.setActionCommand(PanelResultados.CERRAR);
    botones.add(cerrar);
  }
  
  public void actionPerformed(ActionEvent paramActionEvent) {
    String str = paramActionEvent.getActionCommand();
    if (str.equals(PanelResultados.NUEVA)) {
      this.principal.dispose();
      InterfazRumi.main(null);
    } else if(str.equals(PanelResultados.VOLVER)) {
    	((InterfazRumi) this.principal).volver();
    }  else if(str.equals(PanelResultados.CERRAR)) {
    	this.principal.dispose();
		System.exit(0);
    }
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/interfaz/PanelResultados.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */