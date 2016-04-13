package Controlador;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Esta clase representa el modulo que gestiona los semaforos.
 * Implementa los patrones Singleton y Observable
 * 
 * @author mikel <------------------------------------////////////////////////////////////
 *
 */
public class ControladorTimer  extends Observable{
	private static ControladorTimer  mControladorTimer = new ControladorTimer ();
	private boolean eventoGanarOPerder; 
	private static final int TIEMPOMAX = 15;
	private int cont;
	private Timer timer = null;
	
	private ControladorTimer  ()
	{
		eventoGanarOPerder = false;
		cont = TIEMPOMAX;
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				actualizarCont();
			}		
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timerTask, 0, 1000);
	}
	
	/**
	 * getGestorSemaforos
	 * Devuelve la instancia unica de la clase
	 * @return el gestor de semaforos
	 */
	public static ControladorTimer  getControladorTimer () {
		return mControladorTimer;
	}
	
	/**
	 * getContador
	 * Devuelve cuantos segundos quedan para cambiar la luz del semaforo
	 * @return
	 */
	public int getContador() {
		return cont;
	}
	
	/**
	 * estaVerde
	 * Devuelve true si el semaforo esta verda para los peatones y falso en caso contrario
	 * @return
	 */
	public boolean hayEvento() {
		return eventoGanarOPerder;
	}
	
	/**
	 * ponerVerde
	 * Si el semafor esta rojo para los peatones, lo pone en verde
	 */
	public void pausar() {
		if (!hayEvento()) {
			cont = TIEMPOMAX;
			eventoGanarOPerder = true;
			// Notificar el cambio
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * Actualiza el contador del tiempo. Cuando llega a 0 cambia el color de la luz
	 */
	private void actualizarCont() {
		cont--;
		if (cont == 0) {
			cont = TIEMPOMAX;
			eventoGanarOPerder = !eventoGanarOPerder;
		}
		// Notifica el cambio en el estado
		setChanged();
		notifyObservers();
		
	}
}
