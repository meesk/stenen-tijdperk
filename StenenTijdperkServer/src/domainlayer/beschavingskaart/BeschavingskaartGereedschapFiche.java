package domainlayer.beschavingskaart;

/**
*  Dit is de constructor voor de andere gereedschapskaart waar de speler een gereedschaps fische krijgt.
*
* @author Alex de Bruin, s1103096
* @version 0.1
*/

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;


public class BeschavingskaartGereedschapFiche extends UnicastRemoteObject implements IBeschavingskaart {

	
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;
	private BeschavingskaartStatus status;
	private int kosten;

	BeschavingskaartGereedschapFiche(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		this.asset = asset;
		this.achtergrond = achtergrond;
		this.status = status;
		this.kosten = kosten;

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

	@Override
	public String getAsset() {
		return asset;
	}

	@Override
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}
}
