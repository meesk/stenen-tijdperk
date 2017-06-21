package domainlayer.beschavingskaart;

/**
 * @author Alex de Bruin, s1103096
 * @version 0.1
 *
 * <br>
* <br>
* dit is de veelvoudige klassen die voedsel en grondstoffen die op de kaart staan aan de speler geven.
 */

import java.rmi.RemoteException;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;


public class BeschavingskaartMiddel extends Beschavingskaart {


	private int Waarde;
	private Middel[] middel;

	public BeschavingskaartMiddel(String asset, int Waarde,  IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten, Middel... middel) throws RemoteException {
		super(asset, achtergrond, status, kosten);
		this.Waarde = Waarde;
		this.middel = middel;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) {

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
		return Waarde;
	}

	@Override
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public Middel[] getMiddel() {
		return middel;
	}

}
