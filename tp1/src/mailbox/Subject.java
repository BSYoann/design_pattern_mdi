package mailbox;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	List<IObserver> observers = new ArrayList<IObserver>();
	
	public void attach(IObserver o) {
		observers.add(o);
	}
	public void detach(IObserver o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		observers.forEach( o -> o.update(this));
	}
	
}
