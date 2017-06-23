package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;

/**
 * De klasse waar deze specifieke kaart wordt aangemaakt
 *
 * @author Alex de Bruin, s1103096
 * @author Mees Kluivers, s1102358
 * @version 3.0
 */
public class BeschavingskaartGereedschap extends UnicastRemoteObject implements IBeschavingskaart {

	private BeschavingskaartStatus status;
	private int waarde;
	private boolean naastTableau = false;
	private int kosten;
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;

	/**
	 * De contructor van de speciefieke kaart
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param waarde  de waarde van het gereedschap dat meegegeven wordt
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 * @param naastTableau  de boolean die aangeeft of de kaart naast het tableau ligt of niet
	 */
	public BeschavingskaartGereedschap(String asset, int waarde, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten, boolean naastTableau) throws RemoteException{
		this.naastTableau = naastTableau;
		this.waarde = waarde;
		this.asset = asset;

	}

	/** @return Of dat de kaart naast het tableau ligt. */
	public boolean isNaastTableau() {
		return naastTableau;
	}

	/**
	 * Update of de kaart naast het tableau is neergelegd.
	 * @param naastTableau  Of de kaart naast het tableau word gelegd.
	 */
	public void setNaastTableau(boolean naastTableau){
		this.naastTableau = naastTableau;

	}

	@Override
	/** {@inheritDoc} */
	public int getKosten() {
		return kosten;
	}

	@Override
	/** {@inheritDoc} */
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		if( naastTableau == false) {
			naastTableau = true;
		} else {
			IDobbelsteenWorp dw = speler.getSpel().getDobbelsteenWorp();
			dw.addTotaal(1);
		}
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

