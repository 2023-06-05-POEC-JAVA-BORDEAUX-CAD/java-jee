package com.bigcorp.crm.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AttributeOverride(name ="name", column = @Column(name="nome"))
public class Pizzeria extends AbstractRestaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	protected String pizzaName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	
	
}
