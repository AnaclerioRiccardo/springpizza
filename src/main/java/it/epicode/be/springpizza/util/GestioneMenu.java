package it.epicode.be.springpizza.util;

import it.epicode.be.springpizza.config.MenuConfig;
import it.epicode.be.springpizza.model.CheeseTopping;
import it.epicode.be.springpizza.model.Menu;
import it.epicode.be.springpizza.model.PizzaFamilySize;
import it.epicode.be.springpizza.model.PizzaMargherita;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * Classe che gestisce il menu recuperando i bean dei vari prodotti
 * dall'Application Context
 *
 **/

public class GestioneMenu {

	private final Menu menu;
	private final ApplicationContext ctx;

	public GestioneMenu() {
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class); // legge i bean dal file di configurazione
		menu = (Menu) ctx.getBean("menu"); // recupera il bean corrispondente al menu dato il suo nome

	}

	public void stampaMenu() {
		System.out.println("******* Menu *******");
		System.out.println("PIZZA");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuItemLine()));
		System.out.println();

		System.out.println("TOPPINGS");
		menu.getMenuTopping().forEach(p -> System.out.println(p.getMenuItemLine()));
		System.out.println();

		System.out.println("DRINK");
		menu.getMenuDrink().forEach(p -> System.out.println(p.getMenuItemLine()));
		System.out.println();

		System.out.println("FRANCHISING");
		menu.getMenuFranchising().forEach(p -> System.out.println(p.getMenuItemLine()));

		System.out.println();

	}

	public void testTopping() {
		System.out.println("******* TEST TOPPING *******\n");

		PizzaMargherita pizza = (PizzaMargherita) ctx.getBean("pizzaMargherita");
		CheeseTopping topping1 = new CheeseTopping(pizza);
		System.out.println(topping1.getName());

		CheeseTopping topping2 = new CheeseTopping(topping1);
		System.out.println(topping2.getName());

		PizzaFamilySize toppingBig = new PizzaFamilySize(topping2);
		System.out.println(
				toppingBig.getName() + " - Calories: " + toppingBig.getCalories() + " Price: " + toppingBig.getPrice());
	}

}
