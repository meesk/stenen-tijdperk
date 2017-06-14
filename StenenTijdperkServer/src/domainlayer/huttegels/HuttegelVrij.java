package domainlayer.huttegels;

import domainlayer.Speler;
import domainlayer.skeleton.huttegels.IHuttegel;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class HuttegelVrij implements IHuttegel {

	private int min;
	private int max;
	
	public HuttegelVrij(int min, int max){
		this.min = min;
		this.max = max;
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
