package model.manageentries;

import java.time.Instant;
import java.util.Date;

import model.DAOentries;
import model.Entry;
import model.Users;

public class ConsultEntry {

	public ConsultEntry(Users u, Instant d) {
		Entry e = new Entry(u, d);
		DAOentries dao = new DAOentries();
		dao.createEntry(e);
	}

}
