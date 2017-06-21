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
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;


public class BeschavingskaartNaarKeuze extends Beschavingskaart {

	private boolean isNaastTableau;
	private Middel middelen;

	public BeschavingskaartNaarKeuze(String asset, IBeschavingskaartAchtergrond achtergrond, BeschavingskaartStatus status, int kosten, boolean isNaastTableau, Middel middelen) throws RemoteException{
		super(asset, achtergrond, status, kosten);
		this.isNaastTableau = isNaastTableau;
		this.middelen = middelen;
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
