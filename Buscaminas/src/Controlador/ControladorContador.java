package Controlador;

import modelo.Juego;

public class ControladorContador {

	private Casilla[][]casillas;
	private static Juego juego;
	private int counter = 0;
	
	public ControladorContador(Casilla[][] casillas)
	{
		this.juego = juego.getInstance(0);
		this.casillas = casillas;
		this.counter = juego.numMinas;
	}
	
	
}
