package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import mundo.Jugador;

public class PanelJugadores extends JPanel {
	private static final long serialVersionUID = 578493698984433016L;

	private ArrayList<Jugador> jugadores;
	private ArrayList<JTextField> puntos;

	public PanelJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.puntos = new ArrayList<JTextField>();

		setLayout(new GridBagLayout());
		setSize(new Dimension(jugadores.size() * 140, 300));
		for (Jugador jugador : this.jugadores) {
			createColumn2(jugador);
		}
	}
	
	private void createColumn2(Jugador jugador) {
		int j = jugador.darPuntajes().size();
		
		JPanel playerCol = new JPanel();
		playerCol.setLayout(new GridLayout(1,2,0,0));
		playerCol.setBorder(new TitledBorder(jugador.darNombre()));
		playerCol.setPreferredSize(new Dimension(150,(j*25)+50));
		
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
		this.add(playerCol,gbc);
		
		GridLayout colLayout = new GridLayout(j+1,1,0,0);
		JPanel prevCol = new JPanel(colLayout);
		playerCol.add(prevCol);
		
		JPanel totalCol = new JPanel(colLayout);
		playerCol.add(totalCol);
		
		int sum = 0;
		ListIterator<Integer> iterator = jugador.darPuntajes().listIterator();
		while (iterator.hasNext()) {
			int anterior = iterator.next();
			sum += anterior;

			JLabel prev = new JLabel(anterior + "");
			styleLabel(prev);
			prevCol.add(prev);

			JLabel total = new JLabel(sum + "");
			styleLabel(total);
			totalCol.add(total);
		}
		
		JTextField ronda = new JTextField();
		ronda.setBorder(setBorder());
		ronda.setHorizontalAlignment(SwingConstants.CENTER);
		puntos.add(ronda);
		prevCol.add(ronda);
	}

	private void styleLabel(JLabel label) {
		label.setPreferredSize(new Dimension(100,25));
		label.setBorder(setBorder());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(new Color(180, 180, 180));
	}

	private Border setBorder() {
		MatteBorder b1 = new MatteBorder(0, 0, 1, 1, new Color(100, 100, 100));
		MatteBorder b2 = new MatteBorder(1, 1, 0, 0, new Color(200, 200, 200));
		return new CompoundBorder(b1, b2);
	}

	public ArrayList<Integer> darPuntajesRonda() {
		ArrayList<Integer> puntajes = new ArrayList<Integer>();
		for (JTextField campo : puntos) {
			try {
				String text = campo.getText();
				int valor = Integer.parseInt(text);
				Jugador.verificarPuntaje(valor);
				puntajes.add(valor);
				campo.setText("");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error en el puntaje de \n algún jugador.", "Información", 0);
				return null;
			}
		}
		return puntajes;
	}
}

/*
 * Location: /Users/Nicholas/Documents/Trabajo/NickGoodwind
 * T.S./Programación/RumiSB.jar!/interfaz/PanelJugadores.class Java compiler
 * version: 8 (52.0) JD-Core Version: 1.1.3
 */