package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;

/**
* @author Alex de Bruin, s1103096
* @version 0.1
*
*<br>
* <br>
* Dit is de constructor voor de extra kaart pakken kaart, de speler krijgt een extra gesloten kaart.
*/


public class BeschavingskaartExtraKaart extends UnicastRemoteObject implements IBeschavingskaart {


	private IBeschavingskaartAchtergrond achtergrond;
	private String asset;
	private int kosten;
	private BeschavingskaartStatus status;

	BeschavingskaartExtraKaart(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		this.achtergrond = achtergrond;
		this.asset = asset;
		this.kosten = kosten;
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
