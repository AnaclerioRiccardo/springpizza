package it.epicode.be.springpizza.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Classe che modella il menu con tutti i prodotti organizzati per categorie
 *
 **/

public class Menu {

	private final List<Pizza> menuPizza = new ArrayList<>();
	private final List<PizzaTopping> menuTopping = new ArrayList<>();
	private final List<Drink> menuDrink = new ArrayList<>();
	private final List<Franchising> menuFranchising = new ArrayList<>();

	public List<Pizza> getMenuPizza() {
		return menuPizza;
	}

	public List<PizzaTopping> getMenuTopping() {
		return menuTopping;
	}

	public List<Drink> getMenuDrink() {
		return menuDrink;
	}

	public List<Franchising> getMenuFranchising() {
		return menuFranchising;
	}
	
}
