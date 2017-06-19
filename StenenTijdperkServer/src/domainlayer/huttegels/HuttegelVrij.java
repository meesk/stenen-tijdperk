package domainlayer.huttegels;

import domainlayer.skeleton.ISpeler;
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
	public void uitvoerenActie(ISpeler speler) {
		//
	}
	
}
