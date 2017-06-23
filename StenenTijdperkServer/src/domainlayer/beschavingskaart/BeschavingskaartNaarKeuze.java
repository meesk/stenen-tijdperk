package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;


/**
 * De klasse waar deze specifieke kaart wordt aangemaakt.<br>
 * Dit is de kaart die de speler naast zijn tableau legt en later kan in wisselen voor grondstoffen.
 * @author Alex de Bruin, s1103096
 * @version 3.0
 */
public class BeschavingskaartNaarKeuze extends UnicastRemoteObject implements IBeschavingskaart {

	private boolean isNaastTableau;
	private Middel middelen;
	private int kosten;
	private BeschavingskaartStatus status;
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;

	/**
	 * De constructoor van deze specifieke kaart
	 * @param asset  de url van de afbeelding
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 * @param isNaastTableau  is de boolean die aangeeft of de beschavingskaart naast het tableau ligt of niet
	 * @param middelen  de middelen ie de speler kiest als hij de kaart wil gebruiken
	 */
	public BeschavingskaartNaarKeuze(String asset, IBeschavingskaartAchtergrond achtergrond,
			BeschavingskaartStatus status, int kosten, boolean isNaastTableau, Middel middelen) throws RemoteException {
		this.isNaastTableau = isNaastTableau;
		this.middelen = middelen;
		this.asset = asset;
	}

	@Override
	/** {@inheritDoc} */
	public int getKosten() {
		return kosten;
	}

	@Override
	/** {@inheritDoc} */
	public void uitvoerenActie(ISpeler speler) {
		// TODO
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

	/** @return Of de kaart naast het tableau is neergelegd. */
	public boolean isNaastTableau() {
		return isNaastTableau;
	}

	/**
	 * Update of de kaart naast het tableau is neergelegd.
	 * @param isNaastTableau  Of de kaart naast het tableau word gelegd.
	 */
	public void setNaastTableau(boolean isNaastTableau) {
		this.isNaastTableau = isNaastTableau;
	}

	@Override
	/** {@inheritDoc} */
	public String getAsset() {
		return asset;
	}

	@Override
	/** {@inheritDoc} */
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	/** @return De gekozen middelen. */
	public Middel getMiddelen() {
		return middelen;
	}
}

