package it.epicode.be.springpizza.config;

import it.epicode.be.springpizza.model.CheeseTopping;
import it.epicode.be.springpizza.model.Drink;
import it.epicode.be.springpizza.model.DrinkLemonade;
import it.epicode.be.springpizza.model.DrinkWater;
import it.epicode.be.springpizza.model.DrinkWine;
import it.epicode.be.springpizza.model.Franchising;
import it.epicode.be.springpizza.model.FranchisingMug;
import it.epicode.be.springpizza.model.FranchisingShirt;
import it.epicode.be.springpizza.model.HamTopping;
import it.epicode.be.springpizza.model.Menu;
import it.epicode.be.springpizza.model.MenuItem;
import it.epicode.be.springpizza.model.OnionsTopping;
import it.epicode.be.springpizza.model.Ordine;
import it.epicode.be.springpizza.model.PineappleTopping;
import it.epicode.be.springpizza.model.Pizza;
import it.epicode.be.springpizza.model.PizzaFamilySize;
import it.epicode.be.springpizza.model.PizzaHawaiian;
import it.epicode.be.springpizza.model.PizzaMargherita;
import it.epicode.be.springpizza.model.PizzaSalami;
import it.epicode.be.springpizza.model.PizzaTopping;
import it.epicode.be.springpizza.model.SalamiTopping;
import it.epicode.be.springpizza.model.Tavolo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * Classe che definisce i bean corrispondenti ai vari prodotti del menu e crea
 * un nuovo menu popolandolo opportunamente
 *
 **/

@Configuration
public class MenuConfig {

	@Bean
	public Menu menu() {

		Menu menu = new Menu();

		// Pizza
		menu.getMenuPizza().add(pizzaMargherita());
		menu.getMenuPizza().add(pizzaHawaiian());
		menu.getMenuPizza().add(pizzaSalami());
		//non passando un istanza in pizzaFamilySize, Spring istanzia il bean marcato con primary tra le classi che implementano pizza
		//Senza il primary ottengo un errore xk spring non sa quale implementazione usare
		menu.getMenuPizza().add(pizzaFamilySize(null));	
		

		// Toppings
		menu.getMenuTopping().add(toppingCheese(null));
		menu.getMenuTopping().add(toppingHam(null));
		menu.getMenuTopping().add(toppingOnions(null));
		menu.getMenuTopping().add(toppingPineapple(null));
		menu.getMenuTopping().add(toppingSalami(null));

		// Drinks
		menu.getMenuDrink().add(drinkLemonade());
		menu.getMenuDrink().add(drinkWater());
		menu.getMenuDrink().add(drinkWine());

		// Franchising
		menu.getMenuFranchising().add(franchisingMug());
		menu.getMenuFranchising().add(franchisingShirt());
		return menu;

	}

	@Bean
	@Primary  // imposta il bean di default quando si utilizza come parametro una interfaccia
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}

	@Bean
	public PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}

	@Bean
	public PizzaFamilySize pizzaFamilySize(Pizza pizza) {
		return new PizzaFamilySize(pizza);
	}

	@Bean
	public Drink drinkLemonade() {
		return new DrinkLemonade();
	}

	@Bean
	public PizzaTopping toppingCheese(Pizza pizza) {
		return new CheeseTopping(pizza);
	}

	@Bean
	public PizzaTopping toppingHam(Pizza pizza) {
		return new HamTopping(pizza);
	}

	@Bean
	public PizzaTopping toppingOnions(Pizza pizza) {
		return new OnionsTopping(pizza);
	}

	@Bean
	public PizzaTopping toppingPineapple(Pizza pizza) {
		return new PineappleTopping(pizza);
	}

	@Bean
	public PizzaTopping toppingSalami(Pizza pizza) {
		return new SalamiTopping(pizza);
	}

	@Bean
	public Drink drinkWater() {
		return new DrinkWater();
	}

	@Bean
	public Drink drinkWine() {
		return new DrinkWine();
	}

	@Bean
	public Franchising franchisingMug() {
		return new FranchisingMug();
	}

	@Bean
	public Franchising franchisingShirt() {
		return new FranchisingShirt();
	}
	
}
