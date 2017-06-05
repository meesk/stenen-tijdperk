package domainlayer.huttegels;

import domainlayer.Middelen;
import domainlayer.Speler;

public class HuttegelStandaard implements IHuttegel {

	private int waarde;
	private Middelen[] middelen;

	public HuttegelStandaard(Middelen... middelen) {
		this.middelen = middelen;
	}

	@Override
	public void berekenWaarde() {
		waarde = 0;
		for (Middelen middel : middelen) {
			waarde += middel.getWaarde();
		}
	}

	@Override
	public void uitvoerenActie(Speler speler) {
		for (Middelen middel : middelen) {
			speler.ontvangMiddel(middel);
		}
		berekenWaarde();
		//@@TODO: toevoegen waarde aan puntenspoor
	}

}
