package Controlador;
import java.util.Observable;
import java.util.Random;

import Vista.Casilla;
import Vista.VentanaMinas;

public class Juego extends Observable

{
int filas = VentanaMinas.filas;
int columnas = VentanaMinas.columnas;
int numMinas = VentanaMinas.numMinas;
public Casilla casillas[][] = new Casilla [filas][columnas];



public void generar() { 
		for(int f = 0; f < filas; f++){
		      for(int c = 0; c < columnas; c++){ //el fallo esta aquí!!
		      
/** Cambio en el diseño, generar paneles en la matriz en vez de botones
 * 
 *  **/			
		         casillas[f][c]= new Casilla("num", null);
		         VentanaMinas.panelminas.add(casillas[f][c]);
		         casillas[f][c].setBounds(f*40,c*40,20,20);
		         //Medidas de las casillas. A tocar en otro momento
		         //casillas[f][c].addActionListener(casillas[f][c].getControlador());
		         
		         
		      }
		}
}
private void asignarNumeros() {
	// TODO Auto-generated method stub

}
private boolean ganarPartida() {

	
    int minasDescubiertas = 0;
    for (int f = 0; f < filas; f++){
        for (int c = 0; c < columnas; c++){
            if (casillas[f][c].descubierta){
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
    	int valorFila = i.nextInt(filas);  
    	int valorColumna = j.nextInt(columnas); 
    	
    	if(casillas[valorFila][valorColumna].tieneMina == false)
    	{
    		casillas[valorFila][valorColumna].tieneMina = true;
    	}
    	else 
    	{
    		i = new Random(); j = new Random();
    	}             
         System.out.println( puestas );
         /// Y UN DO-WHILE??? SI NO PONE MINA, GENERA ALEATORIO Y PARA AHÍ
         
       } 
}
}
