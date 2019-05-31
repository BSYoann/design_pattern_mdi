package pizza;

public abstract class Personne {

	private long numeroTelephone;
	private String adresse;
	private String nom;

	public Personne(long numeroTelephone, String adresse, String nom) {
		super();
		this.numeroTelephone = numeroTelephone;
		this.adresse = adresse;
		this.nom = nom;
	}

}
