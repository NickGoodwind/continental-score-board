package mundo;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private int puntajeTotal;
	private ArrayList<Integer> puntajes;

	public Jugador(String paramString) {
		this.nombre = paramString;
		this.puntajeTotal = 0;
		this.puntajes = new ArrayList<Integer>();
	}

	public String darNombre() {
		return this.nombre;
	}

	public int darScore() {
		return this.puntajeTotal;
	}
	
	public ArrayList<Integer> darPuntajes() {
		return this.puntajes;
	}

	public void sumar(int nuevoPuntaje) {
		this.puntajeTotal += nuevoPuntaje;
		puntajes.add(nuevoPuntaje);
	}

	public static void verificarPuntaje(Integer valor) {
		if((valor % 5) != 0) {
			throw new IllegalArgumentException();
		}
		
	}
}

/*
 * Location: /Users/Nicholas/Documents/Trabajo/NickGoodwind
 * T.S./Programación/RumiSB.jar!/mundo/Jugador.class Java compiler version: 8
 * (52.0) JD-Core Version: 1.1.3
 */