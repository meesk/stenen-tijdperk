package domainlayer.beschavingskaart;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de constructor voor de gereedschapskaart die naast het tableau komt te liggen.
*/


import domainlayer.BeschavingskaartStatus;
import domainlayer.Speler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartGereedschap extends Beschavingskaart {

	private Image asset;
	private int kosten;
	private BeschavingskaartStatus status;
	private int waarde;
	private IBeschavingskaartAchtergrond achtergrond;
	private boolean naastTableau = false;
	ImageView imageView = new ImageView(asset);


	BeschavingskaartGereedschap(Image asset, int waarde, IBeschavingskaartAchtergrond achtergrond, boolean naastTableau){
		this.waarde = waarde;
		this.achtergrond = achtergrond;
		this.naastTableau = naastTableau;
		this.asset = asset;
	}

	public boolean isNaastTableau() {
		return naastTableau;
	}
	public void setNaastTableau(boolean naastTableau){
		this.naastTableau = naastTableau;

	}

	@Override
	public int getKosten() {
		return kosten;
	}

	@Override
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

	public int getWaarde() {
		return waarde;
	}

	public IBeschavingskaartAchtergrond getAchtergrond() {
		return achtergrond;
	}

}
