package com.prototype;

import java.io.Serializable;

public class Dog implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5518998591955476396L;

	private String name;
	
	private String color;
	
	public Dog(String name, String color) {
		this.name = name;
		
		this.color = color;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", color=" + color + "]";
	}
	
	

}
