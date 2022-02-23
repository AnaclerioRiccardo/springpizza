package it.epicode.be.springpizza.model;

public enum Stato {
	
	PRONTO("P"),
	SERVITO("S"),
	INCORSO("C");
	
	private String sigla;

	private Stato(String sigla) {
		this.sigla = sigla;
	}

}
