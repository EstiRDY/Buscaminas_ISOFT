package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ListaGanadores {
	
	private List<Ganador> listaRanking;

	public ListaGanadores(){listaRanking = new ArrayList<Ganador>();}
	
	public Iterator<Ganador> getIterator()
	{
		return listaRanking.iterator();
	}
	
	public void add(Ganador ganador) {
		listaRanking.add(ganador);
		
	}

}
