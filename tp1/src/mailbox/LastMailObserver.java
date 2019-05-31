package mailbox;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LastMailObserver extends JLabel implements IObserver {

	@Override
	public void update(Subject s) {
		setText("\nDernier mail : " + ((MailBox) s).getLastMail().toString());
	}

}
