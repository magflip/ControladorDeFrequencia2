package model.manageusers;

import model.DAOusers;
import model.Users;

public class ConsultUser {
	
	public ConsultUser(){
	}
	
	public Users ConsultUserByName(String name) {
		DAOusers dao = new DAOusers();
		return dao.consultUserByName(name);
	
	}
	
	public Users ConsultUserByID(long id) {
		DAOusers dao = new DAOusers();
		return dao.consultUserByID(id);
	
	}

}
