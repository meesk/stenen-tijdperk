package domainlayer.beschavingskaart;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
* <br>
* <br>
* Dit is de contructor voor de dobbeltabel beschavingskaart waar een speler dobbelt en alle spelers een dobbelsteen kiezen.
*/

import domainlayer.BeschavingskaartStatus;
import domainlayer.Speler;
import domainlayer.skeleton.ISpeler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartDobbeltabel extends Beschavingskaart {

	private Image asset;
	private BeschavingskaartStatus status;
	private int kosten;
	private IBeschavingskaartAchtergrond achtergrond;


	ImageView imageView = new ImageView(asset);

	BeschavingskaartDobbeltabel(Image asset, IBeschavingskaartAchtergrond achtergrond){
		this.achtergrond = achtergrond;
		this.asset = asset;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
<<<<<<< HEAD
	public void uitvoerenActie(Speler ISpeler) {
=======
	public void uitvoerenActie(ISpeler speler) {
		// TODO Auto-generated method stub
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438

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
