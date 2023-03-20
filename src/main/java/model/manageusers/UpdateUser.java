package model.manageusers;

import model.DAOusers;
import model.Users;

public class UpdateUser {
	
	public UpdateUser(Users uOld, Users uNew) {

		DAOusers dao = new DAOusers();
		if (uNew.getName() != "")
			uOld.setName(uNew.getName());
		
		if (uNew.getPsw() != "")
			uOld.setPsw(uNew.getPsw());
		
		if (uNew.getPermission() != null)
			uOld.setPermission(uNew.getPermission());
		
		dao.updateUserAtomic(uOld);
	}

}
