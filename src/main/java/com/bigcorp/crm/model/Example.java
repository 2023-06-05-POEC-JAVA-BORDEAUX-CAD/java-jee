package com.bigcorp.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXAMPLE")
public class Example {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {	
		this.id = id;
	}

}
