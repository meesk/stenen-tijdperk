package domainlayer.beschavingskaart;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.locaties.Locatie;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import stenentijdperk.StenenTijdperk;

/**
* Beschavingskaart.java
* Een klasse waarbij de beschavingskaarten algemeen worden aangemaakt.
*
* @author Alex de Bruin, s1103096
* @author Tristan Caspers, s1102755
* @version 1.0
*/


public class Beschavingskaart extends Locatie {

	protected String asset;
	protected IBeschavingskaartAchtergrond achtergrond;
	protected BeschavingskaartStatus status;
	protected int kosten;
	private int index;

	public Beschavingskaart(int x, int y, int width, int height, List<Point> cirkels, int index) throws RemoteException {
		super(x, y, width, height, cirkels);
		this.index = index;
	}

	public Beschavingskaart(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		super(-1, 436, 94, 133, null);
		this.asset = asset;
		this.achtergrond = achtergrond;
		this.status = status;
		this.kosten = kosten;
	}
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public String getAsset() {
		return asset;
	}

//	public abstract BeschavingskaartStatus getStatus();
//	public abstract void setStatus(BeschavingskaartStatus status);

//	public abstract int getKosten();

	@Override
	public void betaalMiddelen() {

	}

	public void betaling() {

	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		IBeschavingskaart beschavingskaart = StenenTijdperk.getSpel().getSpeelbord().popBeschavingskaart(index);
		// Betaalview om de kaart te kopen van een x (1, 2, 3 of 4) aantal grondstoffen
		speler.getTableau().geefBeschavingskaart(beschavingskaart);
		beschavingskaart.uitvoerenActie(speler);
		StenenTijdperk.getSpel().getSpeelbord().popBeschavingskaart(index);
		super.notifyObservers();

	}

	@Override
	public boolean isWorpNodig() throws RemoteException {
		return false;
	}
}

