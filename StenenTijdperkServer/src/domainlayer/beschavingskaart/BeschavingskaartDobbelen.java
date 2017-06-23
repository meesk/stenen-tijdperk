package domainlayer.beschavingskaart;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import domainlayer.Tableau;

/**
 * De klasse waar deze specifieke kaart wordt aangemaakt
 * @author Alex de Bruin, s1103096
 * @version 3.0
 */
public class BeschavingskaartDobbelen extends UnicastRemoteObject implements IBeschavingskaart {

	private int kosten;
	private Middel middel;
	private Tableau tableau;
	private String asset;
	private BeschavingskaartStatus status;
	private IBeschavingskaartAchtergrond achtergrond;

	/**
	 * De Constructor voor deze specifieke kaart
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param middel  Het middel waar voor gedobbeld kan worden
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 */
	public BeschavingskaartDobbelen(String asset, Middel middel, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException {
		this.asset = asset;
		this.middel = middel;
		this.kosten = kosten;
		this.achtergrond = achtergrond;
	}

	@Override
	/**{@inheritDoc}*/
	public int getKosten() {
		return kosten;
	}

	/**
	 * Verander hoeveel middelen de beschavingskaart kost.
	 * @param kosten  De nieuwe kosten.
	 */
	public void setKosten(int kosten) {
		// TODO
	}

	@Override
	/**{@inheritDoc}*/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// TODO
		//ontvangen middelen aan de hand van de gegooide ogen.
		//int in gebruik gereedschap aanpassen
	}

	@Override
	/**{@inheritDoc}*/
	public BeschavingskaartStatus getStatus() {
		return status;
	}

	@Override
	/**{@inheritDoc}*/
	public void setStatus(BeschavingskaartStatus status){
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

	/** @return Het middel waarom gedobbeld kan worden. */
	public Middel getMiddel() {
		return middel;
	}

}
