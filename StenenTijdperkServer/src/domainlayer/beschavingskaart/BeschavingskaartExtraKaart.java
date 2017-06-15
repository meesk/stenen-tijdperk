package domainlayer.beschavingskaart;

/**@Author Alex de Bruin, s1103096
*@Version 0.1
*
*<br>
* <br>
* Dit is de constructor voor de extra kaart pakken kaart, de speler krijgt een extra gesloten kaart.
*/


import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartExtraKaart extends Beschavingskaart {

	private Image asset;
	private int kosten;
	private BeschavingskaartStatus status;
	private IBeschavingskaartAchtergrond achtergrond;

	ImageView imageView = new ImageView(asset);
	BeschavingskaartExtraKaart(Image asset, IBeschavingskaartAchtergrond achtergrond){
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

	public Image getAsset() {
		return asset;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}
}
