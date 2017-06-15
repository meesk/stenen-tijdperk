package domainlayer.beschavingskaart;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* Dit is de contructor voor de dobbeltabel beschavingskaart waar een speler dobbelt en alle spelers een dobbelsteen kiezen.
*/

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;


public class BeschavingskaartDobbeltabel extends Beschavingskaart {


	BeschavingskaartDobbeltabel(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten){
		super(asset, achtergrond, status, kosten);
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) {
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
