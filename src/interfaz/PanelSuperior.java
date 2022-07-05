package interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSuperior extends JPanel {

	private static final long serialVersionUID = -1238515219878107020L;

	public PanelSuperior() {
		setLayout(new GridBagLayout());
		setSize(new Dimension(100, 50));
		setAlignmentX(0.5F);

		GridBagConstraints gridBagConstraints = new GridBagConstraints(0, 0, 1, 1, 1.0D, 1.0D, 10, 0,
				new Insets(5, 10, 5, 10), 0, 0);
		add(new JLabel(), gridBagConstraints);

		JLabel titulo = new JLabel("Rumi");
		gridBagConstraints = new GridBagConstraints(1, 0, 2, 1, 1.0D, 1.0D, 10, 0, new Insets(5, 10, 5, 10), 0, 0);
		titulo.setAlignmentX(0.5F);
		add(titulo, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints(3, 0, 1, 1, 1.0D, 1.0D, 10, 0, new Insets(5, 10, 5, 10), 0, 0);
		add(new JLabel(), gridBagConstraints);
	}
}

/*
 * Location: /Users/Nicholas/Documents/Trabajo/NickGoodwind
 * T.S./Programación/RumiSB.jar!/interfaz/PanelSuperior.class Java compiler
 * version: 8 (52.0) JD-Core Version: 1.1.3
 */