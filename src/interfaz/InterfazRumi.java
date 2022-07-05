package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import mundo.Jugador;
import mundo.Rumi;

public class InterfazRumi extends JFrame {
	private static final long serialVersionUID = 8506405474135124759L;

	private Rumi mundo;

	private PanelSuperior banner;
	private JScrollPane scroll;
	private PanelJugadores jugadores;
	private PanelBotones botones;
	private PanelResultados resultados;

	public InterfazRumi() {
		setLayout(new BorderLayout());
		setTitle("Rumi - Juego para toda la familia");
		setDefaultCloseOperation(2);
	}

	public void run() {
		this.mundo = new Rumi();
		String str = JOptionPane.showInputDialog("Escriba el número de jugadores");
		int i = 0;
		while (i == 0) {
			try {
				if(str != null) {
					i = Integer.parseInt(str);
				} else {
					this.dispose();
					System.exit(0);
				}
			} catch (NumberFormatException numberFormatException) {
				JOptionPane.showMessageDialog(this, "No es un número válido", "Error", 0);
				str = JOptionPane.showInputDialog("Escriba el número de jugadores");
			}
		}
		int j;
		for (j = 0; j < i; j++) {
			String str1 = JOptionPane.showInputDialog("Escriba el nombre del jugador " + (j + 1));
			if(str1 != null) {				
				this.mundo.agregarJugador(str1);
			} else {
				this.mundo.agregarJugador("Jugador " + j);
			}
		}

		volver();
		
		i = Math.max(Math.max(this.banner.getWidth(), this.jugadores.getWidth()), this.botones.getWidth());
		j = this.banner.getHeight() + this.jugadores.getHeight() + this.botones.getHeight();
		setSize(new Dimension(i, j));
	}

	public void sumarPuntos() {
		ArrayList<Integer> puntajes = this.jugadores.darPuntajesRonda();
		ArrayList<Jugador> jugadores = this.mundo.darJugadores();
		if (puntajes != null)
			for (byte b = 0; b < this.mundo.darJugadores().size(); b++)
				((Jugador) jugadores.get(b)).sumar(((Integer) puntajes.get(b)).intValue());
	}

	public void terminarPartida() {
		this.getContentPane().removeAll();
		this.resultados = new PanelResultados(this, this.mundo.darJugadoresEnOrden(this.mundo.darJugadores(), 4));
		this.add(this.resultados, "Center");
		this.validate();
		this.repaint();
	}

	public void refrescar() {
		this.jugadores = new PanelJugadores(this.mundo.darJugadores());
		this.scroll.getViewport().add(this.jugadores);
		this.validate();
		this.repaint();
	}
	
	public void volver() {
		this.getContentPane().removeAll();
		
		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		this.banner = new PanelSuperior();
		this.add(this.banner, "North");

		this.jugadores = new PanelJugadores(this.mundo.darJugadores());
		scroll.getViewport().add(this.jugadores);
		this.add(scroll, "Center");

		this.botones = new PanelBotones(this);
		this.add(this.botones, "South");
		
		this.validate();
		this.repaint();
	}

	public boolean hayJugadores() {
		return (this.mundo.darJugadores().size() != 0);
	}

	public static void main(String[] paramArrayOfString) {
		InterfazRumi interfazRumi = new InterfazRumi();
		interfazRumi.run();
		interfazRumi.setVisible(true);
		interfazRumi.setLocationRelativeTo(null);
//		interfazRumi.setResizable(false);
	}
}

/*
 * Location: /Users/Nicholas/Documents/Trabajo/NickGoodwind
 * T.S./Programación/RumiSB.jar!/interfaz/InterfazRumi.class Java compiler
 * version: 8 (52.0) JD-Core Version: 1.1.3
 */