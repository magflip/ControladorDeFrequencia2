package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Users;
import view.Login;

public class CheckUserNPsw {
	
	public CheckUserNPsw()  {
		
	}

	public Users testkUserNPsw() {
		String U;
		String P;
//		new Login();

		U = Login.getuName();
		P = Login.getuPsw();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("controledefrequencia2");

		EntityManager em = emf.createEntityManager();

		String userQuery = "select u.* from Users u where name = \"" + U + "\"";

		Query query = em.createNativeQuery(userQuery, Users.class);

		@SuppressWarnings("unchecked")
		List<Users> items = (List<Users>) query.getResultList();

		if (!items.isEmpty()) {
			if (items.get(0).getPsw().equals(P)) {
				System.out.println("Login efetuado com sucesso!");
				return items.get(0);
			} else {
				System.out.println("Usuário ou senha inválidos (2)");
				em.close();
				emf.close();
				return null;
			}
		} else {
			System.out.println("Usuário ou senha inválidos (1)");
			em.close();
			emf.close();
		}
		
		em.close();
		emf.close();
		return  null;

	}

}
