package domainlayer.beschavingskaart;

import java.rmi.RemoteException;

/**
 * @author Alex de Bruin
 * @version 0.1
 *
 * <br>
* <br>
* Dit is de kaart die de speler naast zijn tableau legt en later kan in wisselen voor grondstoffen.
 */
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartNaarKeuze extends Beschavingskaart {

	private Image asset;
	private int kosten;
	private BeschavingskaartStatus status;
	private IBeschavingskaartAchtergrond achtergrond;
	private boolean isNaastTableau;
	private Middel middelen;
	ImageView imageView = new ImageView(asset);

	public BeschavingskaartNaarKeuze(Image asset, IBeschavingskaartAchtergrond achtergrond, boolean isNaastTableau, Middel middelen) throws RemoteException{
		this.achtergrond = achtergrond;
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

	public Image getAsset() {
		return asset;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public Middel getMiddelen() {
		return middelen;
	}


}
