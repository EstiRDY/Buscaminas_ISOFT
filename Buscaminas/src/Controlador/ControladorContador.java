package Controlador;

import java.util.Observable;
import modelo.Juego;

public class ControladorContador extends Observable{

	private Casilla[][]casillas;
	private static Juego juego;
	private int counter = 0;
	
	public ControladorContador()
	{
		this.juego = juego.getInstance(0);
		this.casillas = juego.getCasillas();
		this.counter = juego.numMinas;
	}

	public int getCounter(){return counter;}
	public void setCounter(int counter)
	{
		this.counter = counter;
		setChanged();
		notifyObservers();
	}
	
}
