package domainlayer.beschavingskaart;



/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de constructor voor de gereedschapskaart die naast het tableau komt te liggen.
*/

import java.rmi.RemoteException;

import domainlayer.Tableau;
import domainlayer.dobbelstenen.DobbelsteenWorp;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;


public class BeschavingskaartGereedschap extends Beschavingskaart {

	private BeschavingskaartStatus status;
	private int waarde;
	private boolean naastTableau = false;
	


	BeschavingskaartGereedschap(String asset, int waarde, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten, boolean naastTableau) throws RemoteException{
		super(asset, achtergrond, status, kosten );
		this.naastTableau = naastTableau;
		this.waarde = waarde;

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
		DobbelsteenWorp dw = speler.getSpel().getDobbelsteenWorp();
		// Voeg 1 extra oog aan de worp toe
		dw.setTotaal(1);
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

	public int getWaarde() {
		return waarde;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

}
