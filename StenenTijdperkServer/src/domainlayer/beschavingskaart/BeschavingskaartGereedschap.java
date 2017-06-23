package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.dobbelstenen.DobbelsteenWorp;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;

/**
 * BeschavingskaartGereedschap.java
 * De klasse waar deze specifieke kaart wordt aangemaakt
 *
 * @Author Alex de Bruin, s1103096
 * @Version 3.0
 */


public class BeschavingskaartGereedschap extends UnicastRemoteObject implements IBeschavingskaart {

	private BeschavingskaartStatus status;
	private int waarde;
	private boolean naastTableau = false;
	private int kosten;
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;


	/**De contructor van de speciefieke kaart
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param waarde  de waarde van het gereedschap dat meegegeven wordt
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 * @param naastTableau  de boolean die aangeeft of de kaart naast het tableau ligt of niet
	 */
	BeschavingskaartGereedschap(String asset, int waarde, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten, boolean naastTableau) throws RemoteException{
		this.naastTableau = naastTableau;
		this.waarde = waarde;
		this.asset = asset;

	}

	public boolean isNaastTableau() {
		return naastTableau;
	}
	public void setNaastTableau(boolean naastTableau){
		this.naastTableau = naastTableau;

	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	/**{@inheritDoc}
	 */
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		if( naastTableau == false) {
			naastTableau = true;
		} else {
		IDobbelsteenWorp dw = speler.getSpel().getDobbelsteenWorp();
		// Voeg 1 extra oog aan de worp toe
		dw.addTotaal(1);
	//	dw.setTotaal(1);
		}

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
