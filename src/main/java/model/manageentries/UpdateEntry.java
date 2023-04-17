package model.manageentries;

import java.time.Instant;

import model.DAOentries;
import model.DAOusers;
import model.Entry;
import model.Users;

public class UpdateEntry {
	
	public UpdateEntry(Entry e) {
		
		DAOentries dao = new DAOentries();
		dao.updateEntry(e);

	}

}
