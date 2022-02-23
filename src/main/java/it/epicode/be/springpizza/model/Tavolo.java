package it.epicode.be.springpizza.model;

public class Tavolo {
	
	//Attributo
	private static int num = 0;
	private int id;
	private int nMaxCoperti;
	private boolean occupato = false;
	
	//Costruttore
	public Tavolo(int nMaxCoperti) {
		id = num++;
		this.nMaxCoperti = nMaxCoperti;
	}

	//Getter e Setter
	public int getnMaxCoperti() {
		return nMaxCoperti;
	}

	public void setnMaxCoperti(int nMaxCoperti) {
		this.nMaxCoperti = nMaxCoperti;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

	public int getId() {
		return id;
	}
	
}
