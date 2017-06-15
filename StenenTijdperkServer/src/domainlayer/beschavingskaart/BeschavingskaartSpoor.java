package domainlayer.beschavingskaart;

<<<<<<< HEAD
=======
import domainlayer.Speler;
import domainlayer.skeleton.ISpeler;
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de constructor die de kaarten die Voedselspoor punten dragen en kaarten die puntenSpoor puntendragen aanmaakt.
*/

import domainlayer.BeschavingskaartStatus;
import domainlayer.Speler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartSpoor extends Beschavingskaart{

	private Image asset;
	private int waarde;
	private int kosten;
	private BeschavingskaartStatus status;
	private IBeschavingskaartAchtergrond achtergrond;

	ImageView imageView = new ImageView(asset);

	BeschavingskaartSpoor(Image asset, int waarde, IBeschavingskaartAchtergrond achtergrond){
		this.waarde = waarde;
		this.achtergrond = achtergrond;
	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
<<<<<<< HEAD
	public void uitvoerenActie(Speler ISpeler) {
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
=======
	public void uitvoerenActie(ISpeler speler) {
		// TODO Auto-generated method stub
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438

	public int getWaarde() {
		return waarde;
	}


}
