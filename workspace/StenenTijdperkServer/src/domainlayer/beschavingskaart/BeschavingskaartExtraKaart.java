package domainlayer.beschavingskaart;

/*@Author Alex de Bruin, s1103096
*@Version 0.1
*/

import java.rmi.RemoteException;

import domainlayer.Speler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartExtraKaart extends Beschavingskaart {

	private Image asset;
	private IBeschavingskaartAchtergrond achtergrond;
	ImageView imageView = new ImageView(asset);
	BeschavingskaartExtraKaart(Image asset, IBeschavingskaartAchtergrond achtergrond){
		this.achtergrond = achtergrond;
		this.asset = asset;
	}
	@Override
	public int getKosten() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void uitvoerenActie(Speler ISpeler) {
		// TODO Auto-generated method stub

	}
}
