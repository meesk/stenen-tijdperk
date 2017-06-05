package domainlayer.huttegels;

import domainlayer.Middelen;
import domainlayer.Speler;

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
