package domainlayer.huttegels;

import domainlayer.Speler;
import domainlayer.enums.Middel;
import domainlayer.skeleton.huttegels.IHuttegel;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class HuttegelKiezen implements IHuttegel {

	private int aantal;
	private int soorten;
	
	public HuttegelKiezen(int aantal, int soorten){
		this.aantal = aantal;
		this.soorten = soorten;
	}

	@Override
	public void berekenWaarde() {
		//
	}
	
	@Override
	public void uitvoerenActie(Speler speler) {
		//
	}
	
}
