package Vista;

import java.util.Observable;
import java.util.Observer;
import Controlador.ControladorContador;

public class ContadorMinas implements Observer {
	
	private ControladorContador controlador;
	ControladorContador cc = new ControladorContador();
	ContadorMinas cm = new ContadorMinas(cc);
	
	public ContadorMinas(ControladorContador pControl)
	{
		controlador = pControl;
		controlador.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		System.out.println(controlador.getCounter());
		int contadorBanderas = 0;
		cc.setCounter(contadorBanderas );
		this.update(cc,cm);

	}

}
