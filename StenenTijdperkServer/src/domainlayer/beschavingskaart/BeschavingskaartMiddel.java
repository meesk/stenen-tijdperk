package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;
import proceslayer.LocatieController;


/**
 * De klasse waar deze specifieke kaart wordt aangemaakt
 * @author Alex de Bruin, s1103096
 * @author Enzo Campfens, s1102421
 * @version 3.0
 */

public class BeschavingskaartMiddel extends UnicastRemoteObject implements IBeschavingskaart {

	private int waarde;
	private Middel middel;
	private int kosten;
	private BeschavingskaartStatus status;
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;

	/**
	 * De constructoor van de Speciefieke kaart
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param waarde  de waarde van de middelen die de speler ontvangt
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 * @param middel  het middel dat de speler met deze kaart kan kopen
	 */
	public BeschavingskaartMiddel(String asset, int waarde,  IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten, Middel middel) throws RemoteException {
		this.waarde = waarde;
		this.middel = middel;
		this.asset = asset;
	}

	@Override
	/** {@inheritDoc} */
	public int getKosten() {
		return kosten;
	}

	@Override
	/**{@inheritDoc}*/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		speler.getTableau().ontvangMiddelen(middel, waarde);
		speler.getTableau().ontvangenBeschavingskaarten(this);
	}

	@Override
	/** {@inheritDoc} */
	public BeschavingskaartStatus getStatus() {
		return status;
	}

	@Override
	/** {@inheritDoc} */
	public void setStatus(BeschavingskaartStatus status) {
		this.status = status;
	}

	@Override
	/** {@inheritDoc} */
	public String getAsset() {
		return asset;
	}

	/** @return De waarde van de beschavingskaart. */
	public int getWaarde() {
		return waarde;
	}

	@Override
	/** {@inheritDoc} */
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}
}
