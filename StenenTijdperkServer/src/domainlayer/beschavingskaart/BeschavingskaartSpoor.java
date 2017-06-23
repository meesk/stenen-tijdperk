package domainlayer.beschavingskaart;

/**
 * BeschavingskaartSpoor.java
* Dit is de constructor die de kaarten die Voedselspoor punten dragen en kaarten die puntenSpoor puntendragen aanmaakt.
* @author Alex de Bruin, s1103096
* @version 3.0
*

*/

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.spoor.ISpoor;
import stenentijdperk.StenenTijdperk;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;


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
	 * @throws RemoteException
	 */
	BeschavingskaartSpoor(String asset, int waarde, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
	 this.waarde = waarde;
	 this.asset = asset;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
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
		// verwijderen stamleden
//		ITableau tableau = speler.getTableau();
//		List<IStamlid> stamleden = super.stamleden.stream().filter(s -> {
//			try {
//				return s.getSpeler() == speler;
//			} catch (RemoteException e) {
//				e.printStackTrace();
//				return false;
//			}
//		}).collect(Collectors.toList());
//		tableau.ontvangStamleden(stamleden);
//		super.verwijderStamleden(stamleden);

		// Beschavingskaart naar tableau
		//moet denk niet hier

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

	@Override
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public int getWaarde() {
		return waarde;
	}


}
