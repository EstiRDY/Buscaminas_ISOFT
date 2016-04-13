package Controlador;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Vista.ContadorMinas;
import modelo.Juego;
 
 
 
 
public class Casilla extends JButton //extends Observable
{
 
    public boolean descubierta = false;
    public boolean estaMinada = false;
    private Controlador controlador; 
    public int minasAlrededor;
    public boolean esPulsableIzq = true;
    public boolean esPulsableDer = true;
    public boolean banderaPuesta = false;
    public int columna;
    public int fila;
    MouseEvent e;
    
    private ImageIcon bandera = new ImageIcon("img/bandera.jpg");
    private ImageIcon mina = new ImageIcon("img/mina2.jpg");
	
	ControladorContador cc = new ControladorContador();
	ContadorMinas cm = new ContadorMinas(cc);
	

    public Casilla(String text, Icon icon) {
        super();
        /*setChanged();
        notifyObservers();*/
         
    }
    public int getColumna() {
        return this.columna;
    }
 
    public int getFila() {
        return this.fila;
    }
     
 
 
    public void pulsar(){
        //Si no tiene icono
        this.descubierta=true;
        if(this.getIcon()!= bandera && this.estaMinada == false)
             
        {
            if (minasAlrededor > 0) {
                    setText(String.valueOf(minasAlrededor));    
             } 
             
            if(minasAlrededor==0) {
                this.setText("");
                this.setBackground(Color.white);
                this.revelarAlrededor(this.fila, this.columna);
            }
              
            this.setBackground(Color.white);
            //Casilla.this.setFont(font);
            this.esPulsableIzq = false;
            this.esPulsableDer = false; 
        }
         
        //Si tiene icono mina   
        if(this.estaMinada){ 
            this.esPulsableIzq = false;
            this.esPulsableDer = false;
            this.setIcon(mina);
            ControladorJuego.finJuego(Juego.getInstance(0).getCasillas());
        }
         
    }

     
    public void revelarAlrededor(int pFila, int pColumna){
    	
          Juego juego = Juego.getInstance(0);  //FUNCIONA con cualquier nivel!
            Casilla[][] matriz = juego.getCasillas();
            for (int f = pFila-1; f <= pFila+1; f++){
                for (int c = pColumna-1; c <= pColumna+1; c++){
                    if(f>=0 && c>=0 && f<juego.filas && c<juego.columnas){      
                    if (matriz[f][c].esPulsableIzq && !matriz[f][c].descubierta){
                        matriz[f][c].pulsar(); 
                        if (matriz[f][c].minasAlrededor==0){
                        matriz[f][c].revelarAlrededor(f,c);
                    }
                    }
                    }
                    }
            }
        
    }
         
 
         
     
    private class Controlador implements MouseListener{
 
    	int contadorBanderas = 0;
    	
        public void mouseClicked(MouseEvent e) {//Si no ha sido pulsadaIzq
            if (e.getButton()== MouseEvent.BUTTON1 && Casilla.this.esPulsableIzq == true )
            {   
                Casilla.this.pulsar();
                }
                 
             
            //Pulsar derecho
            if (e.getButton() == MouseEvent.BUTTON3 && Casilla.this.esPulsableDer == true)
            { 	//Cada vez que pulso derecho, hacer cambios en el contador(suma o resta)
   
            	System.out.println(contadorBanderas);
            	
                if(Casilla.this.getIcon()== null){
                 
	                Casilla.this.setIcon(bandera);
	                Casilla.this.esPulsableIzq = false;
	                Casilla.this.banderaPuesta = true;
	                contadorBanderas--;
	                cc.setCounter(contadorBanderas);
	                this.update(cc, cm);
	
                }
                 
                else
                {
                    Casilla.this.setIcon(null);
                    Casilla.this.esPulsableIzq = true;
                    Casilla.this.banderaPuesta = false;
                    contadorBanderas++;
	                cc.setCounter(contadorBanderas);
	                this.update(cc, cm);
                }
               
            } 
         ControladorJuego.ganarPartida(Juego.getInstance(0).getCasillas(), Juego.getInstance(0) );}
 
        private void update(ControladorContador cc, ContadorMinas cm) {
        	System.out.println(contadorBanderas);
			
		}

		public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
             
        }
 
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
             
        }
 
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
             
        }
 
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
             
        }
 
             
        }//fin controlador
     
    public MouseListener getControlador(){
        if (controlador == null)
        {
            controlador = new Controlador();
        }
        return controlador;
    }
}
    	