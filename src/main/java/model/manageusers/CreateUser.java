package model.manageusers;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.DAOusers;
import model.Users;

public class CreateUser {

	public CreateUser(String name, String password, String permission) {

		DAOusers dao = new DAOusers();
		Users user = new Users(name, password);
		user.convertStringToPermission(permission);
		dao.createUserAtomic(user);
	}

}
