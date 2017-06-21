package domainlayer.beschavingskaart;

/**
*  Dit is de constructor voor de andere gereedschapskaart waar de speler een gereedschaps fische krijgt.
*
* @author Alex de Bruin, s1103096
* @version 0.1
*/

import java.rmi.RemoteException;

import domainlayer.Tableau;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;


public class BeschavingskaartGereedschapFiche extends Beschavingskaart {


	BeschavingskaartGereedschapFiche(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		super(asset, achtergrond, status, kosten);

	}
	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		ITableau tableau = speler.getTableau();
		// Verhoog het gereedschap op het tableau van de speler
		int gereedschap = tableau.getTotaalGereedschap();
		if (gereedschap < 4) {
			tableau.geefGereedschapFiche();
		}
		else if (gereedschap < 16) {
			tableau.verhoogGereedschap();
		}
		tableau.notifyObservers();
	}

	@Override
	public BeschavingskaartStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(BeschavingskaartStatus status) {
		this.status = status;
	}

	public String getAsset() {
		return asset;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}
}
