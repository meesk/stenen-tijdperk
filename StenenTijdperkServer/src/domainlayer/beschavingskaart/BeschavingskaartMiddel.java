package domainlayer.beschavingskaart;

/**
 * @author Alex de Bruin, s1103096
 * @author Enzo Campfens, s1102421
 * @version 0.2
 *
 * dit is de veelvoudige klassen die voedsel en grondstoffen die op de kaart staan aan de speler geven.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;


public class BeschavingskaartMiddel extends UnicastRemoteObject implements IBeschavingskaart {


	private int waarde;
	private Middel middel;
	private int kosten;
	private BeschavingskaartStatus status;
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;

	public BeschavingskaartMiddel(String asset, int waarde,  IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten, Middel middel) throws RemoteException {
		this.waarde = waarde;
		this.middel = middel;
		this.asset = asset;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {

		System.out.println("*** beschavingskaartmiddel test ***");
		System.out.println("Aantal : " + waarde + ", middel : " + middel);
		speler.getTableau().ontvangMiddelen(middel, waarde);
		speler.getTableau().ontvangenBeschavingskaarten(this);
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

	public int getWaarde() {
		return waarde;
	}

	@Override
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

}
