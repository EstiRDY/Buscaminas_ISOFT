package modelo;

import Controlador.ControladorTimer;

public class Ganador {
	private String nombre;
	private int segundos;
public Ganador(){
	this.nombre = Juego.getInstance(0).nombreJugador;
	this.segundos = ControladorTimer.getControladorTimer().getTiempoFinal();
}
}
