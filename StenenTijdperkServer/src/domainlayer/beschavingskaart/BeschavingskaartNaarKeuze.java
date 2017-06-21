package domainlayer.beschavingskaart;


/**
 * @author Alex de Bruin
 * @version 0.1
 *
 * <br>
* <br>
* Dit is de kaart die de speler naast zijn tableau legt en later kan in wisselen voor grondstoffen.
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;


public class BeschavingskaartNaarKeuze extends UnicastRemoteObject implements IBeschavingskaart {

	private boolean isNaastTableau;
	private Middel middelen;
	private int kosten;
	private BeschavingskaartStatus status;
	private String asset;
	private IBeschavingskaartAchtergrond achtergrond;

	public BeschavingskaartNaarKeuze(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten, boolean isNaastTableau, Middel middelen) throws RemoteException{
		this.isNaastTableau = isNaastTableau;
		this.middelen = middelen;
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
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public void setStatus(BeschavingskaartStatus status) {
		this.status = status;
	}
	public boolean isNaastTableau() {
		return isNaastTableau;
	}

	public void setNaastTableau(boolean isNaastTableau) {
		this.isNaastTableau = isNaastTableau;
	}

	@Override
	public String getAsset() {
		return asset;
	}

	@Override
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public Middel getMiddelen() {
		return middelen;
	}


}
