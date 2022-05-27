package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {
  private static final long serialVersionUID = 4845750582460575102L;
  
  private Image fondo;
  
  public PanelFondo() {
    setLayout(new BorderLayout());
    String str = "./data/background.jpg";
    this.fondo = (new ImageIcon(str)).getImage();
    setBackground(new Color(0, 255, 0, 0));
    repaint();
  }
  
  public void paint(Graphics paramGraphics) {
    paramGraphics.drawImage(this.fondo, 0, 0, getWidth(), getHeight(), null);
    super.paint(paramGraphics);
  }
  
  public void cambiarFondo() {
    String str = "./data/resultados.jpg";
    this.fondo = (new ImageIcon(str)).getImage();
    setBackground(new Color(0, 255, 0, 0));
    repaint();
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/interfaz/PanelFondo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */