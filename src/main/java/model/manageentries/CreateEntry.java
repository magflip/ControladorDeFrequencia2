package model.manageentries;

import java.time.Instant;
import java.util.Date;

import model.DAOentries;
import model.Entry;
import model.Users;

public class CreateEntry {

	public CreateEntry(Users u, Instant i) {
		Entry e = new Entry(u, i);
		DAOentries dao = new DAOentries();
		dao.createEntry(e);
	}

}
