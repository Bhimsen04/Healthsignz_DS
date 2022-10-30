package com.practice;

public abstract class Pizza {
	void addToppings() {
		
	}
	
	void prepare() {
		createBase();
		addToppings();
	}
	
	void createBase() {
		//dough and give it a round shape
	}
}
