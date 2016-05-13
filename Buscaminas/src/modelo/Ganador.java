package modelo;

import Controlador.ControladorTimer;

public class Ganador {
	private String nombre;
	private int segundos;
public Ganador(String pNombre, int pPuntuacion){
	
	this.nombre = pNombre;
	this.segundos = pPuntuacion;
	}

public String getNombre(){return nombre;}
public int getSegundos(){return segundos;}
}
