package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;
import proceslayer.LocatieController;

/**
* De klasse waar deze specifieke kaart wordt aangemaakt
*
* @author Alex de Bruin, s1103096
* @author Mees Kluivers, s1102358
* @version 3.0
*/

public class BeschavingskaartGereedschapFiche extends UnicastRemoteObject implements IBeschavingskaart {

	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;
	private BeschavingskaartStatus status;
	private int kosten;

	/**
	 * De contructor van deze speciefieke kaart
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 */
	public BeschavingskaartGereedschapFiche(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		this.asset = asset;
		this.achtergrond = achtergrond;
		this.status = status;
		this.kosten = kosten;

	}

	@Override
	/**{@inheritDoc} */
	public int getKosten() {
		return kosten;
	}

	@Override
	/**{@inheritDoc} */
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		ITableau tableau = speler.getTableau();
		// Verhoog het gereedschap op het tableau van de speler
		int gereedschap = tableau.getTotaalGereedschap();
		if (gereedschap < 4) {
			tableau.geefGereedschapFiche();
		}
		else if (gereedschap < 12) {
			tableau.verhoogGereedschap();
		}
		tableau.notifyObservers();
	}

	/**{@inheritDoc} */
	public BeschavingskaartStatus getStatus() {
		return status;
	}

	@Override
	/**{@inheritDoc} */
	public void setStatus(BeschavingskaartStatus status) {
		this.status = status;
	}

	@Override
	/**{@inheritDoc} */
	public String getAsset() {
		return asset;
	}

	@Override
	/**{@inheritDoc} */
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}
}
