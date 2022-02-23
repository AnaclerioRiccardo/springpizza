package it.epicode.be.springpizza.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Ordine {
	
	//Attributi
	private static Integer num = 0;
	
	private int id;
	private Stato stato;
	private int nCoperti;
	@Value("${springpizza.costo}")
	private double costo;	//da valorizzare per mezzo di un param di conf
	private Tavolo tavolo;
	private Map<MenuItem, Integer> elementi = new HashMap<>();
	
	public Ordine(int nc, Tavolo tavolo, Map<MenuItem, Integer> elementi, double costo) {
		id = num++;
		this.stato = Stato.INCORSO;
		this.tavolo = tavolo;
		this.elementi = elementi;
		this.costo=costo;
		tavolo.setOccupato(true);
		setnCoperti(nc);
	}
	
	public Ordine() {}
	
	//Getter e setter
	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	public int getnCoperti() {
		return nCoperti;
	}

	public void setnCoperti(int nc) {
		if(nc<1 || nc>tavolo.getnMaxCoperti())
			nc=1;
		this.nCoperti = nc;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public int getId() {
		return id;
	}
	
	public Map<MenuItem, Integer> getElementi() {
		return elementi;
	}

	public void setElementi(Map<MenuItem, Integer> elementi) {
		this.elementi = elementi;
	}

	public double importoTotale() {
		double impTot = costo*nCoperti;
		for(MenuItem mi: elementi.keySet()) {
			impTot+=mi.getPrice()*elementi.get(mi);
		}
		return impTot;
	}
	
	@Override
	public String toString() {
		String s = "Tavolo n: "+tavolo.getId()+" Coperti: "+nCoperti+" Importo totale: "+importoTotale()+"\n";
		return s;
	}

}
