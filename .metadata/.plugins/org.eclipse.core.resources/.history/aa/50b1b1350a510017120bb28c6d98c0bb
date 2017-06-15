package domainlayer.beschavingskaart;

import domainlayer.BeschavingskaartStatus;
import domainlayer.Speler;
import javafx.scene.image.Image;

/*@Author Alex de Bruin, s1103096
*@Version 0.1
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

	public BeschavingskaartStatus getStatus(){
		return status;
	}

	public abstract int getKosten();

	public abstract void uitvoerenActie(Speler ISpeler);

	public void betaalMiddelen(){

	}

	public void betalling(){

	}
}

