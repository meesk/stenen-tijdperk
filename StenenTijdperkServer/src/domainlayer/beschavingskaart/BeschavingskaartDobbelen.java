package domainlayer.beschavingskaart;

<<<<<<< HEAD
/**
 * @author Alex de Bruin, s1103096
 * @version 0.1
 * <br>
* <br>
 * Dit is de constructor voor de beschavingskaart <br> waar je met een dobbelsteen moet gooien om een aantal middelen te verkrijgen.
 */
import domainlayer.BeschavingskaartStatus;
import domainlayer.Middel;
import domainlayer.Speler;
=======
import domainlayer.Speler;
import domainlayer.enums.Beschaving;
import domainlayer.enums.Middel;
import domainlayer.enums.Symbool;
import domainlayer.skeleton.ISpeler;
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartDobbelen extends Beschavingskaart {


	private Image asset;
	private int kosten;
	private int Waarde;
	private Middel[] middel;


	private IBeschavingskaartAchtergrond achtergrond;
	private BeschavingskaartStatus status;
	ImageView imageView = new ImageView(asset);

	public BeschavingskaartDobbelen(Image asset, int Waarde, Middel[] middel, IBeschavingskaartAchtergrond achtergrond) {
		this.asset = asset;
		this.Waarde = Waarde;
		this.middel = middel;
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

	public void setStatus(BeschavingskaartStatus status){
		this.status = status;
	}

	public Image getAsset() {
		return asset;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

	public int getWaarde() {
		return Waarde;
	}

	public Middel[] getMiddel() {
		return middel;
=======
	public void uitvoerenActie(ISpeler speler) {
		// TODO Auto-generated method stub
		
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438
	}

}
