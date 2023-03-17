package model;

import java.time.LocalDate;

public class Registry {
	
	private LocalDate newRegistry;
	private String name;
	public LocalDate getNewRegistry() {
		return newRegistry;
	}
	public void setNewRegistry(LocalDate newRegistry) {
		this.newRegistry = newRegistry;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Registry(LocalDate newRegistry, String name) {
		this.newRegistry = newRegistry;
		this.name = name;
	}


	
	
	
	

}
