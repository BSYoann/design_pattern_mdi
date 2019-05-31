package mailbox;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CounterObserver extends JLabel implements IObserver{
	
	@Override
	public void update(Subject s) {
		setText("\nNombre de mails : " + ((MailBox) s).getNbreMail());
	}
}
