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
* @version 3.0
*/


public class Beschavingskaart extends Locatie {

	protected String asset;
	protected IBeschavingskaartAchtergrond achtergrond;
	protected BeschavingskaartStatus status;
	protected int kosten;
	private int index;
/**
 * Deze beschavingskaart constructoor wordt gebruikt om een locatie aan te maken van het type beschavingskaart
 * @param x  De horizontale waarde van de beschavingskaart op het speelbord
 * @param y  de verticale waarde van de beschavingskaart op het spelbord
 * @param width  de wijdte van de kaart
 * @param height  de hoogte van de kaart
 * @param cirkels  het aantal plaatsen dat de kaart heeft
 * @param index  de plek waar de kaart ligt op het speelbord
 */

	public Beschavingskaart(int x, int y, int width, int height, List<Point> cirkels, int index) throws RemoteException {
		super(x, y, width, height, cirkels);
		this.index = index;
	}

	/**
	 * Deze beschavingskaart constructoor wordt gebruikt om een beschavingskaart te maken
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 *
	 */
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
	/**
	 * betaal middelen??
	 */
	public void betaalMiddelen() {

	}

	/***/
	public void betaling() {

	}

	@Override
	/**{@inheritDoc}*/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		IBeschavingskaart beschavingskaart = StenenTijdperk.getSpel().getSpeelbord().popBeschavingskaart(index);
		// Betaalview om de kaart te kopen van een x (1, 2, 3 of 4) aantal grondstoffen
		speler.getTableau().geefBeschavingskaart(beschavingskaart);
		beschavingskaart.uitvoerenActie(speler);
		StenenTijdperk.getSpel().getSpeelbord().popBeschavingskaart(index);
		super.notifyObservers();

	}

	@Override
	/**{@inheritDoc}*/
	public boolean isWorpNodig() throws RemoteException {
		return false;
	}
}

