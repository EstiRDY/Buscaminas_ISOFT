package Controlador;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Vista.ContadorMinas;
import Vista.VentanaMinas;
import modelo.Juego;
 
 
 
 
public class Casilla extends JButton
{
    public boolean estaMinada = false;
    private Controlador controlador; 
    public int minasAlrededor;
    public boolean esPulsableIzq = true;
    public boolean esPulsableDer = true;
    public boolean banderaPuesta = false;
    public boolean descubierta = false;
    public int columna;
    public int fila;
    MouseEvent e;
   
    
   ImageIcon bandera =  VentanaMinas.getBandera();
   ImageIcon mina = VentanaMinas.getMina();
 
	
	

    public Casilla(String text, Icon icon) {
        super();
         
    }
    public int getColumna() {
        return this.columna;
    }
 
    public int getFila() {
        return this.fila;
    }

 
    public void pulsar(){
        //Si no tiene icono
        
        this.esPulsableIzq = false;
        this.esPulsableDer = false; 
        if(this.getIcon()!= bandera && this.estaMinada == false)
             
        {
        	this.descubierta=true;
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

        }
         
        //Si tiene icono mina   
        if(this.estaMinada){ 
            this.esPulsableIzq = false;
            this.esPulsableDer = false;
            this.setIcon(mina);
            ControladorJuego.finJuego(Juego.getInstance(0).getCasillas());
        }
         
    }
    public void revelarMina(){

    	            this.esPulsableIzq = false;
    	            this.esPulsableDer = false;
    	            this.setIcon(mina);
    	        
    }
     
    public void revelarAlrededor(int pFila, int pColumna){
    	
          Juego juego = Juego.getInstance(0);  //FUNCIONA con cualquier nivel!
            Casilla[][] matriz = juego.getCasillas();
            for (int f = pFila-1; f <= pFila+1; f++){
                for (int c = pColumna-1; c <= pColumna+1; c++){
                    if(f>=0 && c>=0 && f<juego.filas && c<juego.columnas){      
                    if (matriz[f][c].esPulsableIzq ){
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
    	
        public void mouseClicked(MouseEvent e) {//Si no ha sido pulsadaIzq
            if (e.getButton()== MouseEvent.BUTTON1 && Casilla.this.esPulsableIzq == true )
            {   
                Casilla.this.pulsar();
                }
                 
             
            //Pulsar derecho
            if (e.getButton() == MouseEvent.BUTTON3 && Casilla.this.esPulsableDer == true)
            { 	//Cada vez que pulso derecho, hacer cambios en el contador(suma o resta)
   
 
            	
                if(Casilla.this.getIcon()== null){
               if (Juego.getInstance(0).clickDerechos > 0)    {     
		           Casilla.this.setIcon(bandera);
			 	   Casilla.this.esPulsableIzq = false;
			 	   Casilla.this.banderaPuesta = true;
		                	
		 	       Juego.getInstance(0).clickDerechos--; //++
		 	       VentanaMinas.getcontadorMinas().setText(String.valueOf(Juego.getInstance(0).clickDerechos));
               }
                }
                 
                else
                {
                    Casilla.this.setIcon(null);
                    Casilla.this.esPulsableIzq = true;
                    Casilla.this.banderaPuesta = false;
                    Juego.getInstance(0).clickDerechos++; //--
         
                    VentanaMinas.getcontadorMinas().setText(String.valueOf(Juego.getInstance(0).clickDerechos));
                }
               
            } 
         ControladorJuego.ganarPartida(Juego.getInstance(0).getCasillas(), Juego.getInstance(0) );}
 


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
    	