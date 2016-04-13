package Controlador;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
 
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
        if(this.getIcon()== null && this.estaMinada == false)
             
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
            //Juego.finJuego(casillas);
        }
         
    }

     
    public void revelarAlrededor(int pFila, int pColumna){
        Juego juego = Juego.getInstance(0);
        Casilla[][] matriz = juego.getCasillas();
        // casilla superior izquierda
        if(pFila == 0 && pColumna == 0){
            if(!matriz[pFila][pColumna+1].descubierta)matriz[pFila][pColumna+1].pulsar();
            if(!matriz[pFila+1][pColumna].descubierta)matriz[pFila+1][pColumna].pulsar();
            if(!matriz[pFila+1][pColumna+1].descubierta)matriz[pFila+1][pColumna+1].pulsar();
        }
        // casilla superior derecha
        if(pFila == 0 && pColumna== juego.columnas-1){
            if(!matriz[pFila][pColumna-1].descubierta)matriz[pFila][pColumna-1].pulsar();
            if(!matriz[pFila+1][pColumna-1].descubierta)matriz[pFila+1][pColumna-1].pulsar();
            if(!matriz[pFila+1][pColumna].descubierta)matriz[pFila+1][pColumna].pulsar();
        }
        // casilla inferior izquierda
        if(pFila == juego.filas-1 && pColumna == 0){
            if(!matriz[pFila-1][pColumna].descubierta)matriz[pFila-1][pColumna].pulsar();
            if(!matriz[pFila-1][pColumna+1].descubierta)matriz[pFila-1][pColumna+1].pulsar();
            if(!matriz[pFila][pColumna+1].descubierta)matriz[pFila][pColumna+1].pulsar();
        }
        // casilla inferior derecha
        if(pFila == juego.filas-1 && pColumna == juego.columnas-1){
            if(!matriz[pFila-1][pColumna-1].descubierta)matriz[pFila-1][pColumna-1].pulsar();
            if(!matriz[pFila-1][pColumna].descubierta)matriz[pFila-1][pColumna].pulsar();
            if(!matriz[pFila][pColumna-1].descubierta)matriz[pFila][pColumna-1].pulsar();
        }
        // arriba (menos las 2 esquinas)
        if(pFila==0&&pColumna!=0&&pColumna!=juego.columnas-1){
            if(!matriz[pFila][pColumna-1].descubierta)matriz[pFila][pColumna-1].pulsar();
            if(!matriz[pFila][pColumna+1].descubierta)matriz[pFila][pColumna+1].pulsar();
            if(!matriz[pFila+1][pColumna-1].descubierta)matriz[pFila+1][pColumna-1].pulsar();
            if(!matriz[pFila+1][pColumna].descubierta)matriz[pFila+1][pColumna].pulsar();
            if(!matriz[pFila+1][pColumna+1].descubierta)matriz[pFila+1][pColumna+1].pulsar();
        }
        // abajo (menos las 2 esquinas)
        if(pFila == juego.filas-1 && pColumna != 0 && pColumna != juego.columnas-1){
            if(!matriz[pFila-1][pColumna-1].descubierta)matriz[pFila-1][pColumna-1].pulsar();
            if(!matriz[pFila-1][pColumna].descubierta)matriz[pFila-1][pColumna].pulsar();
            if(!matriz[pFila-1][pColumna+1].descubierta)matriz[pFila-1][pColumna+1].pulsar();
            if(!matriz[pFila][pColumna-1].descubierta)matriz[pFila][pColumna-1].pulsar();
            if(!matriz[pFila][pColumna+1].descubierta)matriz[pFila][pColumna+1].pulsar();
        }
        // izquierda (menos las 2 esquinas)
        if(pColumna == 0 && pFila != 0 && pFila != juego.filas-1){
            if(!matriz[pFila-1][pColumna].descubierta)matriz[pFila-1][pColumna].pulsar();
            if(!matriz[pFila-1][pColumna+1].descubierta)matriz[pFila-1][pColumna+1].pulsar();
            if(!matriz[pFila][pColumna+1].descubierta)matriz[pFila][pColumna+1].pulsar();
            if(!matriz[pFila+1][pColumna].descubierta)matriz[pFila+1][pColumna].pulsar();
            if(!matriz[pFila+1][pColumna+1].descubierta)matriz[pFila+1][pColumna+1].pulsar();
        }
        // derecha (menos las 2 esquinas)
        if(pColumna == juego.columnas-1 && pFila != 0 && pFila != juego.filas-1){
            if(!matriz[pFila-1][pColumna-1].descubierta)matriz[pFila-1][pColumna-1].pulsar();
            if(!matriz[pFila-1][pColumna].descubierta)matriz[pFila-1][pColumna].pulsar();
            if(!matriz[pFila][pColumna-1].descubierta)matriz[pFila][pColumna-1].pulsar();
            if(!matriz[pFila+1][pColumna-1].descubierta)matriz[pFila+1][pColumna-1].pulsar();
            if(!matriz[pFila+1][pColumna].descubierta)matriz[pFila+1][pColumna].pulsar();
        }
         
        if(pColumna != 0 && pColumna != juego.columnas-1 && pFila != 0 && pFila != juego.filas-1){// casillas del centro (menos las de los bordes)
            if(!matriz[pFila-1][pColumna-1].descubierta)matriz[pFila-1][pColumna-1].pulsar();
            if(!matriz[pFila-1][pColumna].descubierta)matriz[pFila-1][pColumna].pulsar();
            if(!matriz[pFila-1][pColumna+1].descubierta)matriz[pFila-1][pColumna+1].pulsar();
            if(!matriz[pFila][pColumna-1].descubierta)matriz[pFila][pColumna-1].pulsar();
            if(!matriz[pFila][pColumna+1].descubierta)matriz[pFila][pColumna+1].pulsar();
            if(!matriz[pFila+1][pColumna-1].descubierta)matriz[pFila+1][pColumna-1].pulsar();
            if(!matriz[pFila+1][pColumna].descubierta)matriz[pFila+1][pColumna].pulsar();
            if(!matriz[pFila+1][pColumna+1].descubierta)matriz[pFila+1][pColumna+1].pulsar();
             
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
            {
                 
                if(Casilla.this.getIcon()== null){
                 
                Casilla.this.setIcon(bandera);
                Casilla.this.esPulsableIzq = false;
                Casilla.this.banderaPuesta = true;
                }
                 
                else
                {
                    Casilla.this.setIcon(null);
                    Casilla.this.esPulsableIzq = true;
                    Casilla.this.banderaPuesta = false;
                }
            } }
 
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
    	