package model.manageusers;

import model.DAOusers;
import model.Users;

public class DeleteUser {
	
	public DeleteUser(long id) {

		DAOusers dao = new DAOusers();
		dao.DeleteUser(id);
		
		
	}

}

