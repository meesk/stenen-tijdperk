package domainlayer.huttegels;

import domainlayer.Speler;
import domainlayer.enums.Middel;
import domainlayer.skeleton.huttegels.IHuttegel;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class HuttegelStandaard implements IHuttegel {

	private int waarde;
	private Middel[] middelen;

	public HuttegelStandaard(Middel... middelen) {
		this.middelen = middelen;
	}

	@Override
	public void berekenWaarde() {
		waarde = 0;
		for (Middel middel : middelen) {
			waarde += middel.getWaarde();
		}
	}

	@Override
	public void uitvoerenActie(Speler speler) {
		for (Middel middel : middelen) {
			speler.ontvangMiddel(middel);
		}
		berekenWaarde();
		//@@TODO: toevoegen waarde aan puntenspoor
	}

}
