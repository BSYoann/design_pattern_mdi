package mailbox;

import java.util.ArrayList;
import java.util.List;

public class MailBox extends Subject {

	List<Mail> mail = new ArrayList<Mail>();
	private static MailBox instance = null;

	private MailBox() {
	}

	public static MailBox getInstance() {
		if (instance == null)
			instance = new MailBox();
		return instance;
	}

	public void addMail(Mail m) {
		mail.add(m);
	}
	
	public boolean isEmpty() {
		return mail.isEmpty();
	}

	public Mail getLastMail() {
		return mail.get(mail.size() - 1);
	}

	public Integer getNbreMail() {
		return mail.size();
	}
}
