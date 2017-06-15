package domainlayer.beschavingskaart;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de constructor die de kaarten die Voedselspoor punten dragen en kaarten die puntenSpoor puntendragen aanmaakt.
*/

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;
import domainlayer.spoor.Puntenspoor;
import domainlayer.spoor.Voedselspoor;
import domainlayer.Speelbord;
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
	public void uitvoerenActie(ISpeler speler) {
		if(waarde == 1){
			Speelbord speelbord = super.speelbord;
			Voedselspoor voedselspoor = speelbord.getVoedselspoor();
			int productie = voedselspoor.getProductie(speler);
			if(productie < 10){
				voedselspoor.verhoogProductie(speler);
			}
		} else {
			Speelbord speelbord = super.speelbord;
			Puntenspoor puntenspoor = speelbord.getPuntenspoor();
			puntenspoor.verhoogProductie(speler, waarde);
		}
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

	public int getWaarde() {
		return waarde;
	}


}
