package Controlador;
import java.util.Observable;
import java.util.Random;

import javax.swing.ImageIcon;

import Vista.VentanaMinas;

public class Juego extends Observable

{
	public static int nivel;
	public static int filas;
	public static int columnas;
	public static int numMinas;
	


public Juego(int pNivel)
{	
	//cargar desde radioButtons
	int pFilas = 7, pColumnas = 10, pMinas = 10;
	
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
	
	//System.out.println(this.filas+","+this.columnas+","+this.nivel);
	
	/*setChanged();
	notifyObservers();*/
}




private boolean ganarPartida(Casilla[][]casillas) {

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

public static void ponerMinas(int pMinas, Casilla[][]casillas) {
    pMinas = Juego.numMinas;
    while(pMinas>0) 
     //coger una casilla[i][j] random, if notienemina, ponermina
     {
    	int valorFila = (int)(Math.random()*(Juego.filas));  
    	int valorColumna = (int)(Math.random()*(Juego.columnas)); 
    	//System.out.println(valorFila);
    	//System.out.println(valorColumna);
    	ImageIcon mina = new ImageIcon("img/mina2.jpg");
    	if(casillas[valorFila][valorColumna].estaMinada == false)
    	{
    		casillas[valorFila][valorColumna].estaMinada = true;
    		casillas[valorFila][valorColumna].setIcon(mina);
    		pMinas--;
    		//No hace falta incrementar minas porque es un for
    	}
      }
}

/*	public static int getFila(Casilla casilla){
		int fila = 0; 
		{for ( int i = 0; i < filas; ++i ) {
		    for ( int c = 0; c < columnas; ++c ) {
		         fila = i;
		     }
			}
			}
		return fila;
	}
	public static int getColumna(Casilla casilla){
		int fila = 0; int columna = 0;
		{for ( int i = 0; i < filas; ++i ) {
		    for ( int c = 0; c < columnas; ++c ) {
		         columna = c;
		     }
			}
			}
		return columna;
	}*/

public void contarAlrededor(Casilla casillas[][])
{  for(int i=0;i<this.filas;i++){
    for(int j=0;j<this.columnas;j++){
    	
        //esquina superior izquierda
        if(i==0&&j==0){
            if(casillas[i+1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
        }
        //esquina superior derecha
        if(i==0&&j==this.columnas-1){
        	//j = this.columnas;
        	if(casillas[i][j-1].estaMinada){
            casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
        }
        //esquina inferior izquierda
        if(i==this.filas-1 && j==0){
            if(casillas[i-1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
        }
        //esquina inferior derecha
        if(i==this.filas-1 && j== this.columnas-1){
            if(casillas[i][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
        }
        //lado izquierdo
        if(i!=0&&i!=this.filas-1&&j==0){
        	    if(casillas[i-1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
        }
        //lado superior
        if(i==0&&j!=0&&j!=this.columnas-1){
            if(casillas[i][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
        }
        //lado derecho
        if(i!=0&&i!=this.filas-1&&j==this.columnas-1){
            if(casillas[i-1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
        }
        //lado inferior
        if(i==this.filas-1 && j!=0 && j!=this.columnas-1){
            if(casillas[i][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
        }
        //Para las casillas del interior de la matriz
       if(j != 0 && j != this.columnas-1 && i != 0 && i != this.filas-1){
            if(casillas[i-1][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i-1][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j+1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i+1][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
            if(casillas[i][j-1].estaMinada){
                casillas[i][j].minasAlrededor++;
            }
        }
        }
        }
        }
	}



