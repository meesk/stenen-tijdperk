package domainlayer.huttegels;

import domainlayer.Speler;

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
