package domainlayer.beschavingskaart;

import domainlayer.Speler;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartMiddel extends Beschavingskaart {

	private Image asset;
	private int kosten;
	private int Waarde;
	private IBeschavingskaartAchtergrond achtergrond;
	private Middel[] middel;
	ImageView imageView = new ImageView(asset);

	public BeschavingskaartMiddel(Image asset, int Waarde, IBeschavingskaartAchtergrond achtergrond, Middel... middel) {
		this.middel = middel;
		this.Waarde = Waarde;
		this.achtergrond = achtergrond;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) {


	}


}
