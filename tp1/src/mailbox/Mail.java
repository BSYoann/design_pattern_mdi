package mailbox;

public class Mail {
	
	String body;
	String subject;
	
	public Mail(String subject, String body) {
		this.subject = subject;
		this.body = body;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getBody() {
		return body;
	}
	
	@Override
	public String toString() {
		return "Subject: " + getSubject() + "\n\n" + getBody();
	}
}
