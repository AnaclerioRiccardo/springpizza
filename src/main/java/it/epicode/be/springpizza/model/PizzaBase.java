package it.epicode.be.springpizza.model;

/**
 *
 * Classe che implementa una pizza di base da cui si ottengono tutte le altre
 * che devono comparire direttamente nel menu
 *
 **/
public class PizzaBase implements Pizza {

	private Integer calories;
	private String name;
	private Double price;

	public PizzaBase(String name, Double price, Integer calories) {
		this.calories = calories;
		this.name = name;
		this.price = price;
	}

	@Override
	public Integer getCalories() {
		return this.calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String getMenuItemLine() {
		return this.name + " - calories: " + this.calories + " - price: " + this.price;
	}

}
