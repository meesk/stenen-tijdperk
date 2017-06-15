package domainlayer.beschavingskaart;

import java.rmi.RemoteException;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de constructor voor de andere gereedschapskaart waar de speler een gereedschaps fische krijgt.
*
*/

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartGereedschapFishe extends Beschavingskaart {

	private Image asset;
	private int kosten;
	private BeschavingskaartStatus status;
	private IBeschavingskaartAchtergrond achtergrond;
	ImageView imageView = new ImageView(asset);
	BeschavingskaartGereedschapFishe(Image asset, IBeschavingskaartAchtergrond achtergrond) throws RemoteException{
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
