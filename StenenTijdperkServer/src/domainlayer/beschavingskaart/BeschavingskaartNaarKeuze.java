package domainlayer.beschavingskaart;

/*@Author Alex de Bruin, s1103096
*@Version 0.1
*/
import java.rmi.RemoteException;

import domainlayer.Middel;
import domainlayer.Speler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartNaarKeuze extends Beschavingskaart {

	private Image asset;
	private IBeschavingskaartAchtergrond achtergrond;
	private boolean isNaastTableau;
	private Middel middelen;
	ImageView imageView = new ImageView(asset);

	public BeschavingskaartNaarKeuze(Image asset, IBeschavingskaartAchtergrond achtergrond, boolean isNaastTableau, Middel middelen){
		this.achtergrond = achtergrond;
		this.isNaastTableau = isNaastTableau;
		this.middelen = middelen;
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
