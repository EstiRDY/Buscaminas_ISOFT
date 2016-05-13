package modelo;

import java.util.Observable;
import java.util.Observer;
import Controlador.ControladorContador;
import Vista.VentanaMinas;

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
		//int contadorBanderas = 0;
		cc.setCounter(Juego.getInstance(0).clickDerechos);
		this.update(cc,cm);
		if(VentanaMinas.getcontadorMinas().getText().equals("0"))
		{
			System.out.println("no puedes poner mas banderas");
		}
		//NO FUNCIONA
	}

}
