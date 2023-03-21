package model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOentries {

	EntityManagerFactory emf;
	EntityManager em;

	public DAOentries() {

	}

	public void createEMF() {
		this.emf = Persistence.createEntityManagerFactory("controledefrequencia2");
	}

	public void openDBconnection() {
		this.em = this.emf.createEntityManager();
	}

	public void openDAO() {
		createEMF();
		openDBconnection();

	}

	public void closeDAO() {
		this.em.close();
		this.emf.close();

	}
	
	public void createEntry(Entry e) {
		openDAO();
		this.em.getTransaction().begin();
		this.em.persist(e);
		this.em.getTransaction().commit();

		closeDAO();
	}

}
