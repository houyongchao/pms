package Service;

import java.util.List;

import Dao.ContactDao;
import Entity.Contactnote;

public class ContactService {

	ContactDao dao = new ContactDao();

	public void saveNote(Contactnote note) {
		dao.saveNote(note);
	}

	public List<Contactnote> findAllNote() {
		return dao.findAllNote();
	}
	
	
}
