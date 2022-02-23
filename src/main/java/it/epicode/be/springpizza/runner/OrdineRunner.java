package it.epicode.be.springpizza.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.springpizza.config.MenuConfig;
import it.epicode.be.springpizza.model.DrinkWine;
import it.epicode.be.springpizza.model.FranchisingMug;
import it.epicode.be.springpizza.model.Menu;
import it.epicode.be.springpizza.model.MenuItem;
import it.epicode.be.springpizza.model.Ordine;
import it.epicode.be.springpizza.model.PizzaMargherita;
import it.epicode.be.springpizza.model.Tavolo;

@Component
public class OrdineRunner implements CommandLineRunner {
	
	//Attributo
	private Logger log = LoggerFactory.getLogger(OrdineRunner.class);
	@Value("${springpizza.costo}")
	private double costo;
	

	@Override
	public void run(String... args) throws Exception {
		
		Tavolo t = new Tavolo(4);
		HashMap<MenuItem, Integer> piatti= new HashMap<>();
		piatti.put(new PizzaMargherita(), 4);
		piatti.put(new DrinkWine(), 4);
		piatti.put(new FranchisingMug(), 2);

		Ordine o = new Ordine(4, t, piatti, costo);
		
		log.info(o.toString());
	}

}
