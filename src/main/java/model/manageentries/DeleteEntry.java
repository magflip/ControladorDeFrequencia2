package model.manageentries;

import model.DAOentries;
import model.Entry;

public class DeleteEntry {
	
	public DeleteEntry(Entry e) {
		
		DAOentries dao = new DAOentries();
		dao.deleteEntry(e);
		
	}

}
