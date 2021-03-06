package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;
import proceslayer.LocatieController;

/**
* De klasse waarin deze specifieke kaart wordt aangemaakt.
*
* @author Alex de Bruin, s1103096
* @author Tristan Caspers, s1102755
* @version 3.0
*/
public class BeschavingskaartExtraKaart extends UnicastRemoteObject implements IBeschavingskaart {

	private IBeschavingskaartAchtergrond achtergrond;
	private String asset;
	private int kosten;
	private BeschavingskaartStatus status;

	/**
	 * De constructor van deze kaart
	 * @param asset  een string waarde die de verwijzing naar de afbeelding afmaakt
	 * @param achtergrond  het soort achtergrond dat de kaart heeft
	 * @param status  is de kaart vrij of niet vrij
	 * @param kosten  wat kost de kaart
	 */
	public BeschavingskaartExtraKaart(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException {
		this.achtergrond = achtergrond;
		this.asset = asset;
		this.kosten = kosten;
	}

	@Override
	/**{@inheritDoc}*/
	public int getKosten() {
		return kosten;
	}

	@Override
	/**{@inheritDoc}*/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {

//		System.out.println("Beschavingskaart \n ___________________________________________________________");
//		System.out.println("1");
//		System.out.println(speler.getSpel());
//		System.out.println("2");
//		System.out.println(speler.getSpel().getSpeelbord());
//		System.out.println("3");
//		System.out.println(speler.getSpel().getSpeelbord().getKaarten());
//		System.out.println("4");
//		System.out.println(speler.getSpel().getSpeelbord().getKaarten().get(3));
//		System.out.println("5");
//		System.out.println(speler.getSpel().getSpeelbord().getKaarten().get(speler.getSpel().getSpeelbord().getKaarten().size()));
//		System.out.println("6");
//		System.out.println("HOI");


		//speler.getSpel().getSpeelbord().getKaarten().get(speler.getSpel().getSpeelbord().getKaarten().size() - 1);
	//	System.out.println("Kaart is toegevoegd, denk ik!");
	}

	@Override
	/**{@inheritDoc}*/
	public BeschavingskaartStatus getStatus() {
		return status;
	}

	@Override
	/**{@inheritDoc}*/
	public void setStatus(BeschavingskaartStatus status) {
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
}
