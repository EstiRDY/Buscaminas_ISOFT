package Vista;

import java.util.Observable;
import java.util.Observer;
import Controlador.ControladorContador;

public class ContadorMinas implements Observer {
	
	private ControladorContador controlador;
	
	public ContadorMinas(ControladorContador pControl)
	{
		controlador = pControl;
		controlador.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		System.out.println(controlador.getCounter());
		
	}

}
