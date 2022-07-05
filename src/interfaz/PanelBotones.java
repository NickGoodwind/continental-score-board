package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel implements ActionListener {
  private static final long serialVersionUID = 2391408731453985947L;
  
  private static final String NUEVA = "nueva";
  
  private static final String RONDA = "ronda";
  
  private static final String TERMINAR = "terminar";
  
  private InterfazRumi principal;
  
  private JButton nuevaPartida;
  
  private JButton finalizarRonda;
  
  private JButton terminarJuego;
  
  public PanelBotones(InterfazRumi paramInterfazRumi) {
    this.principal = paramInterfazRumi;
    
    setOpaque(false);
    setLayout(new GridLayout(1, 3));
    setSize(new Dimension(400, 50));
    
    this.nuevaPartida = new JButton("Nueva partida");
    this.nuevaPartida.setActionCommand(PanelBotones.NUEVA);
    this.nuevaPartida.addActionListener(this);
    add(this.nuevaPartida);
    
    this.finalizarRonda = new JButton("Finalizar ronda");
    this.finalizarRonda.setActionCommand(PanelBotones.RONDA);
    this.finalizarRonda.addActionListener(this);
    add(this.finalizarRonda);
    
    this.terminarJuego = new JButton("Terminar partida");
    this.terminarJuego.setActionCommand(PanelBotones.TERMINAR);
    this.terminarJuego.addActionListener(this);
    add(this.terminarJuego);
    
    if (!this.principal.hayJugadores()) {
      this.finalizarRonda.setEnabled(false);
      this.terminarJuego.setEnabled(false);
    } 
  }
  
  public void actionPerformed(ActionEvent event) {
    String str = event.getActionCommand();
    if (str.equals(PanelBotones.NUEVA)) {
      this.principal.dispose();
      InterfazRumi.main((String[])null);
    } else if (str.equals(PanelBotones.RONDA)) {
      this.principal.sumarPuntos();
      this.principal.refrescar();
    } else if (str.equals(PanelBotones.TERMINAR)) {
      this.principal.terminarPartida();
    } 
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/interfaz/PanelBotones.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */