package Controlador;
import java.util.Observable;
import java.util.Random;

import Vista.VentanaMinas;

public class Juego extends Observable

{
	public static int nivel;
	public static int filas;
	public static int columnas;
	public static int numMinas;

	public Casilla casillas[][] = new Casilla [filas][columnas];


public Juego(int pNivel)
{	
	//cargar desde radioButtons
	int pFilas = 0, pColumnas = 0, pMinas = 0;
	
	switch (pNivel) {
	case 1: pFilas = 7; pColumnas = 10;
		break;
	case 2:  pFilas = 10; pColumnas = 15;
		break;
	case 3:  pFilas = 12; pColumnas = 25;
		break;
	}
	pMinas = pColumnas*pNivel;
	this.nivel = pNivel; 
	this.filas = pFilas; 
	this.columnas = pColumnas; 
	this.numMinas = pMinas;
	
	System.out.println(this.filas+","+this.columnas+","+this.nivel);
	
	/*setChanged();
	notifyObservers();*/
}



private void asignarNumeros() {
	// TODO Auto-generated method stub

}
private boolean ganarPartida() {

    int minasDescubiertas = 0;
    for (int f = 0; f < filas; f++){
        for (int c = 0; c < columnas; c++){
            if (casillas[f][c].descubierta == true){
                minasDescubiertas++;}}}
    if (minasDescubiertas == numMinas)
        {return true;}
    else
        {return false;}
}



private void ponerMinas(int pMinas) {
        pMinas = this.numMinas;
        for ( int puestas = 0; puestas <= pMinas; puestas++) 
         //coger una casilla[i][j] random, if notienemina, ponermina
         {
        	Random i = new Random(); Random j = new Random();
        	int valorFila = (int)(Math.random()*(filas-1));  
        	int valorColumna = (int)(Math.random()*(columnas-1));  
        	
        	if(casillas[valorFila][valorColumna].estaMinada == false)
        	{
        		casillas[valorFila][valorColumna].estaMinada = true;
        		//No hace falta incrementar minas porque es un for
        	}
        	else 
        	{
        		i = new Random(); j = new Random();
        	}             
             System.out.println( puestas );
        }
    }

private void contarAlrededor(Casilla casillas[][])
{
	}

}

