package model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Entry {

	@Id
	@GeneratedValue
	private long id;
	private Date newRegistry;
	@ManyToOne
	private Users user;
	
	

	public Date getNewRegistry() {
		return newRegistry;
	}

	public void setNewRegistry(Date newRegistry) {
		this.newRegistry = newRegistry;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}


	public Entry() {
	}

	public Entry(Date newRegistry, Users user) {
		this.newRegistry = newRegistry;
		this.user = user;
	}
	
	

}
