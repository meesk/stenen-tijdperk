package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;
import proceslayer.LocatieController;


/**
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

	/**
	 * De constructor die deze kaart aanmaakt
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 */
	public BeschavingskaartDobbeltabel(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		this.achtergrond = achtergrond;
		this.asset = asset;
	}

	@Override
	/**{@inheritDoc}*/
	public int getKosten() {
		return kosten;
	}

	@Override
	/**{@inheritDoc}*/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// TODO
		// Speler haalt stamlid van de kaart af
		// Speler betaalt de kaart
		// Uitvoeren Actie
		// Speler werpt dobbelstenen
		// Speler kiest een dobbelsteen uit, deze dobbelsteen wordt onbeschikbaar gemaakt
		// De overige spelers kiezen er ook een uit
		// Speler krijgt de kaart op zijn tableau
	}

	@Override
	/**{@inheritDoc}*/
	public BeschavingskaartStatus getStatus() {
		return status;
	}

	@Override
	/**{@inheritDoc}*/
	public void setStatus(BeschavingskaartStatus status) {
		this.status = status;
	}

	@Override
	/**{@inheritDoc}*/
	public String getAsset() {
		return asset;
	}

	@Override
	/**{@inheritDoc}*/
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

}
