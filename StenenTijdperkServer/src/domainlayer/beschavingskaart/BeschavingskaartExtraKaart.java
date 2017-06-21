package domainlayer.beschavingskaart;

import java.rmi.RemoteException;

/**@Author Alex de Bruin, s1103096
*@Version 0.1
*
*<br>
* <br>
* Dit is de constructor voor de extra kaart pakken kaart, de speler krijgt een extra gesloten kaart.
*/


import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;


public class BeschavingskaartExtraKaart extends Beschavingskaart {



	BeschavingskaartExtraKaart(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		super(asset, achtergrond, status, kosten);
		this.achtergrond = achtergrond;
		this.asset = asset;
}

	@Override
	public int getKosten() {
		// TODO Auto-generated method stub
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
