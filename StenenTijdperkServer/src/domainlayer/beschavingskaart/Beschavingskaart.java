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

<<<<<<< HEAD
	public abstract void setStatus(BeschavingskaartStatus status);
=======
	public abstract void uitvoerenActie(ISpeler speler);
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438

	public void betaalMiddelen(){

	}

	public void betalling(){

	}

	public abstract int getKosten();

	public abstract void uitvoerenActie(Speler ISpeler);
}

