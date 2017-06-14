package domainlayer.beschavingskaart;

/*@Author Alex de Bruin, s1103096
*@Version 0.1
*/

import java.rmi.RemoteException;

import domainlayer.Speler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartGereedschap extends Beschavingskaart {

	private Image asset;
	private int waarde;
	private IBeschavingskaartAchtergrond achtergrond;
	private boolean isNaastTableau = false;
	ImageView imageView = new ImageView(asset);
	//private Gereedschap gereedschap;
	BeschavingskaartGereedschap(Image asset, int waarde, IBeschavingskaartAchtergrond achtergrond, boolean isNaastTableau){
		this.waarde = waarde;
		this.achtergrond = achtergrond;
		this.isNaastTableau = isNaastTableau;
		this.asset = asset;
	}

	public void setIsNaastTableau(boolean change){
		isNaastTableau = change;

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
