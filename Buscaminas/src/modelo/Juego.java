package modelo;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controlador.Casilla;
import Vista.VentanaAcceso;
import Vista.VentanaMinas;

public class Juego extends Observable

{	private static Juego juego = null;

	public static int nivel;
	public static int filas;
	public static int columnas;
	public static int numMinas;
	private Casilla[][]casillas;
	


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
	public static Juego getInstance(int pNivel){
		if (juego == null){juego = new Juego(pNivel);}return juego;
	}
	public void setMatriz(Casilla[][]casillas){
		this.casillas=casillas;
	}
	
	public Casilla[][]hacerMatriz(JPanel jp){
		Casilla[][]casillas=new Casilla[this.filas][this.columnas];
		for(int f = 0; f < this.filas; f++){
			  for(int c = 0; c < this.columnas; c++){
		         casillas[f][c]= new Casilla("num", null);		         
		         jp.add(casillas[f][c]);
		         //casillas[f][c].setBounds(f*10, c*10, 40, 40);
		         casillas[f][c].addMouseListener(casillas[f][c].getControlador());
		         //nuevo setPosicion añadido
		         casillas[f][c].fila = f;
		         casillas[f][c].columna = c;
		        //System.out.println(c); 
		      }
		     // System.out.println(f);  
		 } // fin for
		juego.ponerMinas(juego.numMinas,casillas);
		juego.contarAlrededor(casillas);
		//juego.finJuego(casillas);
		//System.out.println(juego.nivel);
		setMatriz(casillas);
		return casillas;
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
    	//ImageIcon mina = new ImageIcon("img/mina2.jpg");
    	if(casillas[valorFila][valorColumna].estaMinada == false)
    	{
    		casillas[valorFila][valorColumna].estaMinada = true;
    		//casillas[valorFila][valorColumna].setIcon(mina);
    		pMinas--;
    	}
      }
}
public static void finJuego (Casilla casillas[][])
{	
	for(int i=0;i<Juego.filas;i++){
	    for(int j=0;j<Juego.columnas;j++){
	    	if(casillas[i][j].estaMinada==true&&casillas[i][j].descubierta==false){
	    	casillas[i][j].pulsar();
	    	}
	    }
	   }
 }
public void revelarAlrededor(Casilla casillas[][],Casilla casillaActual){
	
	 /*Tenemos la fila y la columna de la casilla pulsada
	 Para la casilla pulsada comprobamos en que posicion del tablero se encuentra
	 y en función de la posicion (esquina,lado o central)revelamos las casillas que tiene alrededor
	 Además si alguna de las casillas reveladas tampoco tiene minas alrededor
	 ejecutará este mismo método de manera recursiva
	 int i=casillaActual.fila;
	 int j=casillaActual.columna; 
	 if(i==0&&j==0){
            if(!casillas[i+1][j].descubierta){
                casillas[i+1][j].pulsar();
                if(casillas[i+1][j].minasAlrededor==0){
                revelarAlrededor(casillas[][],casillas[i+1][j];
                }
                }            
            }
            if(!casillas[i][j+1].descubierta){
                casillas[i][j+1].pulsar();
            }
            if(!casillas[i+1][j+1].descubierta){
                casillas[i+1][j+1].pulsar();
            }*/
        }
        


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



