package domainlayer.beschavingskaart;
/*Author Alex de Bruin, s1103096
 * 		 Erwin Olie, s1103026
 *Versie 0.1*/
import java.rmi.RemoteException;

import domainlayer.Speler;
import domainlayer.enums.Beschaving;
import domainlayer.enums.Middel;
import domainlayer.enums.Symbool;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartDobbelen extends Beschavingskaart {



	private Image asset;
	private int Waarde;
	private Middel[] middel;
	private IBeschavingskaartAchtergrond achtergrond;
	ImageView imageView = new ImageView(asset);

	public BeschavingskaartDobbelen(Image asset, int Waarde, Middel[] middel, IBeschavingskaartAchtergrond achtergrond) {
		this.asset = asset;
		this.Waarde = Waarde;
		this.middel = middel;
		this.achtergrond = achtergrond;
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
