package domainlayer.beschavingskaart;

<<<<<<< HEAD
/**
 * @author Alex de Bruin, s1103096
 * @version 0.1
 *
 * <br>
* <br>
* dit is de veelvoudige klassen die voedsel en grondstoffen die op de kaart staan aan de speler geven.
 */

import domainlayer.BeschavingskaartStatus;

/*@Author Alex de Bruin, s1103096
*@Version 0.1
*/

import domainlayer.Middel;
=======
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438
import domainlayer.Speler;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartMiddel extends Beschavingskaart {


	private Image asset;
	private int kosten;
	private BeschavingskaartStatus status;
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

	public int getWaarde() {
		return Waarde;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public Middel[] getMiddel() {
		return middel;
	}

}
