package domainlayer.beschavingskaart;

import java.rmi.RemoteException;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* Dit is de contructor voor de dobbeltabel beschavingskaart waar een speler dobbelt en alle spelers een dobbelsteen kiezen.
*/

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;


public class BeschavingskaartDobbeltabel extends Beschavingskaart {


	BeschavingskaartDobbeltabel(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		super(asset, achtergrond, status, kosten);
		this.achtergrond = achtergrond;
		this.asset = asset;

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

	@Override
	public String getAsset() {
		return asset;
	}

	@Override
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

}
