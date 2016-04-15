package modelo;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Controlador.Casilla;
import Controlador.ControladorContador;
import Controlador.ControladorJuego;
import Vista.ContadorMinas;


public class Juego

{	
	
	private static Juego juego;
	public static int nivel;
	public static int filas;
	public static int columnas;
	public static int numMinas;
	private Casilla[][]casillas;
	public Casilla casillaActual;
	private ControladorJuego ctrl;



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
		          casillas[f][c].addMouseListener(casillas[f][c].getControlador());
	    	      casillas[f][c].fila = f;
		          casillas[f][c].columna = c;
  
		      }
		  
		 } // fin for
		juego.ponerMinas(juego.numMinas,casillas);
		juego.contarAlrededor(casillas);
		//juego.finJuego(casillas);
		setMatriz(casillas);
		return casillas;
	}


public void ponerMinas(int pMinas, Casilla[][]casillas) {
    pMinas = getInstance(nivel).numMinas;
    while(pMinas>0) 
     //coger una casilla[i][j] random, if notienemina, ponermina
     {
    	int valorFila = (int)(Math.random()*(getInstance(nivel).filas));  
    	int valorColumna = (int)(Math.random()*(getInstance(nivel).columnas)); 
    	if(casillas[valorFila][valorColumna].estaMinada == false)
    	{
    		casillas[valorFila][valorColumna].estaMinada = true;
	        //casillas[valorFila][valorColumna].setIcon(mina);

    		pMinas--;
    	}
      }
}     

public void contarAlrededor(Casilla casillas[][])
{  for(int i=0;i<this.filas;i++){
    for(int j=0;j<this.columnas;j++){
    	for(int f=i-1;f<=i+1;f++){
    		for(int c=j-1;c<=j+1;c++){
    			if(f>=0 && c>=0 && f<juego.filas && c<juego.columnas){
    				if(casillas[f][c].estaMinada){
    					casillas[i][j].minasAlrededor++;
    				}
    			}
    		}
    		
    	}
    }
   }
}


	public Casilla[][] getCasillas() {
		return this.casillas;
	}
	
	public ControladorJuego addControlador() {
		if (ctrl == null)
		{
			ctrl = new ControladorJuego(casillas);
		}
		System.out.println("controlador añadido");
		System.out.println(ctrl);
		return ctrl;
		
	}

	
	}



