package domainlayer.beschavingskaart;

import domainlayer.Speler;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.locaties.Locatie;
import domainlayer.skeleton.ISpeler;
import javafx.scene.image.Image;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*<br>
* <br>
* Dit is een abstracte klasse waar alle beschavingskaarten van overerven.
*/


public abstract class Beschavingskaart extends Locatie {
	public Beschavingskaart() {
		super(1);
	}

	private Image asset;
	private IBeschavingskaartAchtergrond achtergrond;
	private BeschavingskaartStatus status;
	protected int kosten;

	public IBeschavingskaartAchtergrond getAchtergrond(){
		return achtergrond;
	}

	public Image getAsset(){
		return asset;
	}

	public abstract BeschavingskaartStatus getStatus();
	public abstract void setStatus(BeschavingskaartStatus status);
	public abstract void uitvoerenActie(ISpeler speler);
	public abstract int getKosten();

	public void betaalMiddelen(){

	}

	public void betalling(){

	}


}

