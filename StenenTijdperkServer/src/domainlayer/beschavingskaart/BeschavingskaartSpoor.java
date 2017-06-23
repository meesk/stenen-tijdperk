package domainlayer.beschavingskaart;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;
import domainlayer.skeleton.spoor.ISpoor;
import stenentijdperk.StenenTijdperk;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Dit is de constructor die de kaarten die Voedselspoor punten dragen en kaarten die puntenSpoor puntendragen aanmaakt.
 *
 * @author Alex de Bruin, s1103096
 * @version 3.0
 */
public class BeschavingskaartSpoor extends UnicastRemoteObject implements IBeschavingskaart{

	private int waarde;
	private int kosten;
	private BeschavingskaartStatus status;
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;

	/**
	 * De constructoor van deze speciefieke Beschavingskaart
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 * @param waarde  de waarde waarmee het spoor opgehoogd moet worden
	 */
	BeschavingskaartSpoor(String asset, int waarde, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
	 this.waarde = waarde;
	 this.asset = asset;
	}

	@Override
	/** {@inheritDoc} */
	public int getKosten() {
		return kosten;
	}

	@Override
	/** {@inheritDoc} */
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		//actie uitvoeren
		if(waarde == 1){
			ISpeelbord speelbord = StenenTijdperk.getSpel().getSpeelbord();
			ISpoor voedselspoor = speelbord.getVoedselspoor();
			int productie = voedselspoor.getProductie(speler);
			if(productie < 10){
				voedselspoor.verhoogPunten(speler, 1);
			}
		} else {
			ISpeelbord speelbord = StenenTijdperk.getSpel().getSpeelbord();
			ISpoor puntenspoor = speelbord.getPuntenspoor();
			puntenspoor.verhoogPunten(speler, 3);
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

	@Override
	/** {@inheritDoc} */
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	/** @return De waarde van deze beschavingskaart. */
	public int getWaarde() {
		return waarde;
	}


}
