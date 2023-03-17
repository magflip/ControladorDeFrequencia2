package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DAOusers {

	EntityManagerFactory emf;
	EntityManager em;

	public DAOusers() {

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

	public void createUserAtomic(Users u) {
		openDAO();

		this.em.getTransaction().begin();
		this.em.persist(u);
		this.em.getTransaction().commit();

		closeDAO();

	}

	public Users consultUserByID(long uid) {
		openDAO();

		Users user = this.em.find(Users.class, uid);

		closeDAO();
		
		return user;

	}
	
	public Users consultUserByName(String name) {
		openDAO();

		String userQuery = "select u.* from Users u where name = \"" + name + "\"";

		Query query = em.createNativeQuery(userQuery, Users.class);

		@SuppressWarnings("unchecked")
		List<Users> items = (List<Users>) query.getResultList();

		Users user = items.get(0);

		closeDAO();
		
		return user;

	}

}
