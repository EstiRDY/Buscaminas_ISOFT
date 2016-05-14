package Controlador;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import Vista.VentanaMinas;

/**
 * Esta clase gestiona el cronometro de la partida y los eventos que pueden pararlo
 * Implementa el patron Observable y el Singleton
 *
 */
public class ControladorTimer extends Observable{
	private static ControladorTimer  mControladorTimer = new ControladorTimer ();

	private static final int TIEMPOINICIAL = -1;
	private static int segundos;
	private static Timer timer;
	static JLabel tiempo = VentanaMinas.getTemporizador();
	private static boolean freeze =  false;
	private static int tiempoFinal ;
	
	public ControladorTimer  ()
	{

		segundos = TIEMPOINICIAL;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (freeze == false){
				actualizarCont();}
			}
			
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	
	/**
	 * getControladorTimer
	 * Devuelve la instancia unica de la clase  
	 * @return el controlador del cronometro
	 */
		public static ControladorTimer getControladorTimer () {
		return mControladorTimer;
	}
	
	/**
	 * getContador
	 * Devuelve cuantos segundos llevamos de partida
	 * @return
	 */
	public int getContador() {
		return segundos;
	}
	public int getTiempoFinal(){return tiempoFinal;}
	public void setFreeze (boolean cong)
	{
		this.freeze = cong;
	}
	
	public void setContador(int seg) {
		this.segundos = seg;
	}
	
	/**
	 * pausar
	 * Si se ha ganado o perdido la partida, se para el cronometro y 
	 * se guarda el tiempo si se ha ganado*/
	 
	public static void pausar() {
		
				freeze = true;
				//timer.cancel();  //pausa pero no reinicia
				tiempo.setText(String.valueOf(segundos));
				tiempoFinal = segundos;

	}
	
	/**
	 * Actualiza el contador del tiempo
	 */
	private void actualizarCont() {
		segundos++;
		tiempo.setText(String.valueOf(segundos));
		setChanged();
		notifyObservers();

	
	}
}
