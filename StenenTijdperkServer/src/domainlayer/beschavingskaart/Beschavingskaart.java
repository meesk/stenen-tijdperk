package domainlayer.beschavingskaart;

import java.rmi.RemoteException;
import domainlayer.Speler;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.locaties.Locatie;
import domainlayer.skeleton.ISpeler;
import javafx.scene.image.Image;

/**
* Dit is een abstracte klasse waar alle beschavingskaarten van overerven.\
*
*
*
*
*
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
*

*/


public abstract class Beschavingskaart extends Locatie {
	public Beschavingskaart() {
		super(1);
	}

	protected String asset;
	protected IBeschavingskaartAchtergrond achtergrond;
	protected BeschavingskaartStatus status;
	protected int kosten;

	public Beschavingskaart(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten){
		super(1);
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

