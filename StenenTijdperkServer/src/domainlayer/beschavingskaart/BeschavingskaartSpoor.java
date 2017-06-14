package domainlayer.beschavingskaart;

import domainlayer.Speler;
import domainlayer.skeleton.ISpeler;

/*@Author Alex de Bruin, s1103096
*@Version 0.1
*/

import domainlayer.skeleton.spoor.ISpoor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BeschavingskaartSpoor extends Beschavingskaart{

	private Image asset;
	private ISpoor spoor;
	private IBeschavingskaartAchtergrond achtergrond;
	ImageView imageView = new ImageView(asset);

	BeschavingskaartSpoor(Image asset, ISpoor spoor, IBeschavingskaartAchtergrond achtergrond){
		this.spoor = spoor;
		this.achtergrond = achtergrond;
	}

	@Override
	public int getKosten() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) {
		// TODO Auto-generated method stub

	}


}
