package domainlayer.beschavingskaart;

import java.rmi.RemoteException;

import domainlayer.Speelbord;
/**
 * @author Alex de Bruin, s1103096
 * @version 0.1
 * <br>
* <br>
 * Dit is de constructor voor de beschavingskaart <br> waar je met een dobbelsteen moet gooien om een aantal middelen te verkrijgen.
 */
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.spoor.Voedselspoor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartDobbelen extends Beschavingskaart {


	private Image asset;
	private int kosten;
	private int waarde;
	private Middel[] middel;
	private IBeschavingskaartAchtergrond achtergrond;
	private BeschavingskaartStatus status;
	ImageView imageView = new ImageView(asset);

	public BeschavingskaartDobbelen(Image asset, int waarde, Middel[] middel, IBeschavingskaartAchtergrond achtergrond) throws RemoteException {
		this.asset = asset;
		this.waarde = waarde;
		this.middel = middel;
		this.achtergrond = achtergrond;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) {


	}

	@Override
	public domainlayer.enums.BeschavingskaartStatus getStatus() {
		return status;
	}

	public void setStatus(BeschavingskaartStatus status){
		this.status = status;
	}

	public Image getAsset() {
		return asset;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public int getWaarde() {
		return waarde;
	}

	public Middel[] getMiddel() {
		return middel;
	}

}
