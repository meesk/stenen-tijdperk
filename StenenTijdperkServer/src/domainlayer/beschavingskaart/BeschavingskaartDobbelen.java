package domainlayer.beschavingskaart;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;
import stenentijdperk.StenenTijdperk;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;
import domainlayer.Tableau;

/**
 * BeschavingskaartDobbelen.java
 * De klasse waar deze specifieke kaart wordt aangemaakt
 * @author Alex de Bruin, s1103096
 * @version 3.0
 *
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
	public int getKosten() {
		return kosten;
	}

	public void setKosten(int kosten) {

	}

	@Override
	/**{@inheritDoc}*/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		//ontvangen middelen aan de hand van de gegooide ogen.
		//int in gebruik gereedschap aanpassen
	//	this.tableau.gebruikGereedschap(1);

	//	StenenTijdperk.getSpel().getDobbelsteenWorp().werp(2);
	//	this.tableau.ontvangMiddelen(this.getMiddel(), StenenTijdperk.getSpel().getDobbelsteenWorp().getTotaal() / this.getMiddel().getWaarde());
	//	tableau.ontvangenBeschavingskaarten(this);


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

	}

	@Override
	public BeschavingskaartStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(BeschavingskaartStatus status){
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

	public Middel getMiddel() {
		return middel;
	}

}
