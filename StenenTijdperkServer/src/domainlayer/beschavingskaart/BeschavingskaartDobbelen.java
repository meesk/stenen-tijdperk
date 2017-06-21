package domainlayer.beschavingskaart;

/**
 * @author Alex de Bruin, s1103096
 * @version 1.0
 *
 * Dit is de constructor voor de beschavingskaart <br> waar je met een dobbelsteen moet gooien om een aantal middelen te verkrijgen.
 */
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
import stenentijdperk.StenenTijdperk;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;
import domainlayer.Stamlid;
import domainlayer.Tableau;

public class BeschavingskaartDobbelen extends Beschavingskaart {


	private int kosten;
	private Middel middel;
	private Tableau tableau;

	public BeschavingskaartDobbelen(String asset, Middel middel, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException {
		super(asset, achtergrond, status, kosten);
		this.asset = asset;
		this.middel = middel;
		this.kosten = kosten;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	public void setKosten(int kosten) {

	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		//ontvangen middelen aan de hand van de gegooide ogen.
		//int in gebruik gereedschap aanpassen
		this.tableau.gebruikGereedschap(1);
		int totaalOgen = StenenTijdperk.getSpel().getDobbelsteenWorp().getTotaal();

		this.tableau.ontvangMiddelen(this.getMiddel(), totaalOgen / this.getMiddel().getWaarde());

		//verwijderen stamleden
		ITableau tableau = speler.getTableau();
		List<IStamlid> stamleden = super.stamleden.stream().filter(s -> {
			try {
				return s.getSpeler() == speler;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}).collect(Collectors.toList());
		tableau.ontvangStamleden(stamleden);
		super.verwijderStamleden(stamleden);

	}

	@Override
	public domainlayer.enums.BeschavingskaartStatus getStatus() {
		return status;
	}

	public void setStatus(BeschavingskaartStatus status){
		this.status = status;
	}

	public String getAsset() {
		return asset;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public Middel getMiddel() {
		return middel;
	}

}
