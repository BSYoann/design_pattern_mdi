package mailbox;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	@SuppressWarnings("deprecation")
	private void init() {

		System.out.println("init");
		
		JFrame f = new JFrame();
		f.setTitle("Test de JFrame");
		f.setSize(300, 100);

		JPanel p = new JPanel();

		f.add(p);

		// TODO Register observer
		CounterObserver co = new CounterObserver();
		MailBox.getInstance().attach(co);
		p.add(co);
		
		LastMailObserver lmo = new LastMailObserver();
		MailBox.getInstance().attach(lmo);
		p.add(lmo);

		f.setVisible(true);
		f.dispose();
		f.show();

	}

	private void runScenario() {
		MailBox mb = MailBox.getInstance();
		mb.addMail(new Mail("ESIR" + new Random().nextInt(), " Tp fini !"));
		System.out.println("Nombre de mails (par la boîte mail) : " + mb.getNbreMail());
		mb.notifyObservers();
	}

	public static void main(String[] args) throws InterruptedException {
		Main m = new Main();
		m.init();
		while (true) {
			Thread.sleep(3000);
			m.runScenario();
		}
	}
}