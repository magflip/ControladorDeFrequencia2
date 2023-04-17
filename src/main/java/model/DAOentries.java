package model;

import java.sql.PreparedStatement;
import java.time.Instant;
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
	
	public List<Entry> consultEntries(Long id, Date d) {
		openDAO();
		
		
		String entryQuery = "select * from Entry e where user_id = ? and newRegistry >= ?" ;
//		String entryQuery = "select * from entry e where user_id = " + id ;

		Query query = em.createNativeQuery(entryQuery, Entry.class).setParameter(1, id).setParameter(2, d);
		@SuppressWarnings("unchecked")
		List<Entry> items = (List<Entry>) query.getResultList();

//		Entry entry = items.get(0);
		

		closeDAO();
		
		return items;

	}
	
	public void updateEntry(Entry e) {
		openDAO();

		this.em.getTransaction().begin();
		this.em.merge(e);
		this.em.getTransaction().commit();

		closeDAO();

	}
	
	public void deleteEntry(Entry e) {
		openDAO();

		this.em.getTransaction().begin();
		Entry eToDelete = this.em.find(Entry.class, e.getId());
		this.em.remove(eToDelete);
		this.em.getTransaction().commit();
		

		closeDAO();

	}

}
