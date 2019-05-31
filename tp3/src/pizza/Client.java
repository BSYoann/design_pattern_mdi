package pizza;

public class Client extends Personne {

	final protected long NumeroCarteCredit;
	
	public Client(long numeroTelephone, String adresse, String nom, long NumeroCarteCredit) {
		super(numeroTelephone, adresse, nom);
		this.NumeroCarteCredit = NumeroCarteCredit;
	}

}
