package model;

import java.time.Instant;
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
	private Instant newRegistry;
	@ManyToOne
	private Users user;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getNewRegistry() {
		return newRegistry;
	}

	public void setNewRegistry(Instant newRegistry) {
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

	public Entry(Users u, Instant i) {
		this.newRegistry = i;
		this.user = u;
	}
	
	public Entry(Long id, Date date) {
		this.id = id;
		this.newRegistry = date.toInstant();
	}
	
	

}
