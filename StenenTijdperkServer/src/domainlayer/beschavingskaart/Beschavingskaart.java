package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.locaties.Locatie;
import domainlayer.skeleton.ISpeler;

/**
* Beschavingskaart.java
* Een klasse waarbij de beschavingskaarten algemeen worden aangemaakt.
*
* @author Alex de Bruin, s1103096
* @version 1.0
*/


public abstract class Beschavingskaart extends Locatie {
	public Beschavingskaart() throws RemoteException {
		super(-1, -1, -1, -1, null);
	}

	protected String asset;
	protected IBeschavingskaartAchtergrond achtergrond;
	protected BeschavingskaartStatus status;
	protected int kosten;

	public Beschavingskaart(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten) throws RemoteException{
		super(-1, -1, -1, -1, null);
		this.asset = asset;
		this.achtergrond = achtergrond;
		this.status = status;
		this.kosten = kosten;
	}
	public IBeschavingskaartAchtergrond getAchtergrond(){
		return achtergrond;
	}

	public String getAsset(){
		return asset;
	}

	public abstract BeschavingskaartStatus getStatus();
	public abstract void setStatus(BeschavingskaartStatus status);
	public abstract void uitvoerenActie(ISpeler speler) throws RemoteException;
	public abstract int getKosten();

	public void betaalMiddelen(){

	}

	public void betalling(){

	}


}

