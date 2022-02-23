package it.epicode.be.springpizza;

import it.epicode.be.springpizza.util.GestioneMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPizzaApplication.class, args);

		// richiama la classe utility per la stampa del menu
		GestioneMenu stampa = new GestioneMenu();
		stampa.stampaMenu();
		stampa.testTopping();
	}

}
