package modelo;
import java.util.Observable;
import javax.swing.JPanel;
import Controlador.Casilla;
import Controlador.ControladorJuego;


public class Juego extends Observable

{	
	
	private static Juego juego;
	public static int nivel;
	public static int filas;
	public static int columnas;
	public static int numMinas;
	public static int contadorBanderas;
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

public void revelarAlrededor(){
	juego.getInstance(nivel);
	Casilla[][] matriz = this.casillas;
	Casilla actual = this.casillaActual;
	
	 
	 /*Tenemos la fila y la columna de la casilla pulsada
	 Para la casilla pulsada comprobamos en que posicion del tablero se encuentra
	 y en función de la posicion (esquina,lado o central)revelamos las casillas que tiene alrededor
	 Además si alguna de las casillas reveladas tampoco tiene minas alrededor
	 ejecutará este mismo método de manera recursiva*/
	
	 int i=casillaActual.fila;
	 int j=casillaActual.columna; 
	 
	 if(j != 0 && j != this.columnas-1 && i != 0 && i != this.filas-1){
         if(!casillas[i-1][j-1].descubierta){
             casillas[i][j].pulsar();
         }
         if(!casillas[i-1][j].descubierta){
             casillas[i][j].pulsar();
         }
         if(!casillas[i-1][j+1].descubierta){
             casillas[i][j].pulsar();
         }
         if(!casillas[i][j+1].descubierta){
             casillas[i][j].pulsar();
         }
         if(!casillas[i+1][j+1].descubierta){
             casillas[i][j].pulsar();
         }
         if(!casillas[i+1][j].descubierta){
             casillas[i][j].pulsar();
         }
         if(!casillas[i+1][j-1].descubierta){
             casillas[i][j].pulsar();
         }
         if(!casillas[i][j-1].descubierta){
             casillas[i][j].pulsar();
         }
     }
     
     
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



