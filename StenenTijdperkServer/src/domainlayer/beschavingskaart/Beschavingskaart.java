package domainlayer.beschavingskaart;

import domainlayer.BeschavingskaartStatus;
import domainlayer.Speler;
import javafx.scene.image.Image;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*<br>
* <br>
* Dit is een abstracte klasse waar alle beschavingskaarten van overerven.
*/


public abstract class Beschavingskaart {
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

	public void betaalMiddelen(){

	}

	public void betalling(){

	}

	public abstract int getKosten();

	public abstract void uitvoerenActie(Speler ISpeler);
}

