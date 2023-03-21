package model.manageentries;

import java.util.Date;

import model.DAOentries;
import model.Entry;
import model.Users;

public class CreateEntry {

	public CreateEntry(Users u, Date d) {
		Entry e = new Entry(d, u);
		DAOentries dao = new DAOentries();
		dao.createEntry(e);
	}

}
