package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;

/**
* BeschavingskaartExtraKaart.java
* De klasse waarin deze specifieke kaart wordt aangemaakt.
*
* @author Alex de Bruin, s1103096
* @author Tristan Caspers, s1102755
* @version 1.0
*/

public class BeschavingskaartExtraKaart extends UnicastRemoteObject implements IBeschavingskaart {

	private IBeschavingskaartAchtergrond achtergrond;
	private String asset;
	private int kosten;
	private BeschavingskaartStatus status;

	BeschavingskaartExtraKaart(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException {
		this.achtergrond = achtergrond;
		this.asset = asset;
		this.kosten = kosten;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// Speler haalt stamlid van de kaart af
		// Speler betaalt de kaart
		// Uitvoeren Actie
		// Speler krijgt een random kaart van de stapel van het speelbord op zijn tableau
		// Speler krijgt kaart op zijn tableau

		speler.getTableau().geefBeschavingskaarten(speler.getSpel().getSpeelbord().getBeschavingskaarten()[1]);
//		System.out.println("Willekeurige beschavingskaart toegevoegd aan tableau");
	}

	@Override
	public BeschavingskaartStatus getStatus() {
		return status;
	}
	@Override
	public void setStatus(BeschavingskaartStatus status) {
		this.status = status;

	}

	@Override
	public String getAsset() {
		return asset;
	}

	@Override
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}
}
