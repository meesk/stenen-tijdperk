package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.dobbelstenen.DobbelsteenWorp;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de constructor voor de gereedschapskaart die naast het tableau komt te liggen.
*/


public class BeschavingskaartGereedschap extends UnicastRemoteObject implements IBeschavingskaart {

	private BeschavingskaartStatus status;
	private int waarde;
	private boolean naastTableau = false;
	private int kosten;
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;


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
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		IDobbelsteenWorp dw = speler.getSpel().getDobbelsteenWorp();
		// Voeg 1 extra oog aan de worp toe
		//dw.addTotaal(1);
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
