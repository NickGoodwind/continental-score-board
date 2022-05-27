package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSuperior extends JPanel {
  private static final long serialVersionUID = -1238515219878107020L;
  
  private Image fondo;
  
  public PanelSuperior() {
    setLayout(new GridBagLayout());
    setSize(new Dimension(390, 50));
    setAlignmentX(0.5F);
    String str = "./data/banner.jpg";
    this.fondo = (new ImageIcon(str)).getImage();
    setBackground(new Color(0, 255, 0, 0));
    repaint();
    JLabel jLabel = new JLabel("Rumi");
    Font font = new Font("Comic Sans MS", 1, 22);
    jLabel.setFont(font);
    jLabel.setForeground(Color.WHITE);
    jLabel.setAlignmentX(0.5F);
    GridBagConstraints gridBagConstraints = new GridBagConstraints(0, 0, 1, 1, 1.0D, 1.0D, 10, 0, new Insets(5, 10, 5, 10), 0, 0);
    add(new JLabel(), gridBagConstraints);
    gridBagConstraints = new GridBagConstraints(1, 0, 2, 1, 1.0D, 1.0D, 10, 0, new Insets(5, 10, 5, 10), 0, 0);
    add(jLabel, gridBagConstraints);
    gridBagConstraints = new GridBagConstraints(3, 0, 1, 1, 1.0D, 1.0D, 10, 0, new Insets(5, 10, 5, 10), 0, 0);
    add(new JLabel(), gridBagConstraints);
  }
  
  public void paint(Graphics paramGraphics) {
    paramGraphics.drawImage(this.fondo, 0, 0, null);
    super.paint(paramGraphics);
  }
}


/* Location:              /Users/Nicholas/Documents/Trabajo/NickGoodwind T.S./Programación/RumiSB.jar!/interfaz/PanelSuperior.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */