package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import stenentijdperk.StenenTijdperk;

/**
* BeschavingskaartDobbeltabel.java
* De klasse waarin deze specifieke kaart wordt aangemaakt.
*
* @author Alex de Bruin, s1103096
* @author Tristan Caspers, s1102755
* @version 3.0
*/

public class BeschavingskaartDobbeltabel extends UnicastRemoteObject implements IBeschavingskaart {

	private int kosten;
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;
	private BeschavingskaartStatus status;

	/**De constructor die deze kaart aanmaakt
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 */
	BeschavingskaartDobbeltabel(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		this.achtergrond = achtergrond;
		this.asset = asset;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	/**{@inheritDoc}*/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// Speler haalt stamlid van de kaart af
		// Speler betaalt de kaart
		// Uitvoeren Actie
		// Speler werpt dobbelstenen
		// Speler kiest een dobbelsteen uit, deze dobbelsteen wordt onbeschikbaar gemaakt
		// De overige spelers kiezen er ook 1 uit
		// Speler krijgt de kaart op zijn tableau
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
