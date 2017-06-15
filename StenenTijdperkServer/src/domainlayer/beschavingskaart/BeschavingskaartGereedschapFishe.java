package domainlayer.beschavingskaart;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de constructor voor de andere gereedschapskaart waar de speler een gereedschaps fische krijgt.
*
*/

import domainlayer.BeschavingskaartStatus;
import domainlayer.Speler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartGereedschapFishe extends Beschavingskaart {

	private Image asset;
	private int kosten;
	private BeschavingskaartStatus status;
	private IBeschavingskaartAchtergrond achtergrond;
	ImageView imageView = new ImageView(asset);
	BeschavingskaartGereedschapFishe(Image asset, IBeschavingskaartAchtergrond achtergrond){
		this.achtergrond = achtergrond;
	}
	@Override
	public int getKosten() {
		// TODO Auto-generated method stub
		return kosten;
	}
	@Override
	public void uitvoerenActie(Speler ISpeler) {
		// TODO Auto-generated method stub

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
	public Image getAsset() {
		return asset;
	}
	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}
}
