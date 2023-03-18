package model.manageusers;

import model.DAOusers;
import model.Users;

public class CreateUser {

	public CreateUser(String name, String password, String permission) {

		DAOusers dao = new DAOusers();
		Users user = new Users(name, password);
		try {
			user.convertStringToPermission(permission);
		} catch (Exception e) {
			System.out.println("A permissão informada não existe.");
		}
		
		dao.createUserAtomic(user);
	}

}
