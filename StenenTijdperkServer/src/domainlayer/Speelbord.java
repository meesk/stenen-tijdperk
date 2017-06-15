package domainlayer;

import java.util.ArrayList;
import java.util.List;

import domainlayer.enums.Middel;
import domainlayer.locaties.Akker;
import domainlayer.locaties.Gereedschapmaker;
import domainlayer.locaties.Hut;
import domainlayer.locaties.Locatie;
import domainlayer.locaties.MiddelLocatie;
import domainlayer.skeleton.spoor.ISpoor;
import domainlayer.spoor.Puntenspoor;
import domainlayer.spoor.Voedselspoor;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.2
 */
public class Speelbord {

	private Spel spel;
	private List<Locatie> locaties;
	private ISpoor[] sporen;

	public Speelbord(Spel spel) {
		this.spel = spel;
		locaties = new ArrayList<Locatie>() {{
			add(new MiddelLocatie(7, Middel.HOUT)); //Bos
			add(new MiddelLocatie(7, Middel.LEEM)); //Leemgroeve
			add(new MiddelLocatie(7, Middel.STEEN)); // Steengroeve
			add(new MiddelLocatie(7, Middel.GOUD)); //Rivier
			add(new MiddelLocatie(Middel.VOEDSEL)); //jacht
			add(new Akker()); //akker
			add(new Hut()); //hut
			add(new Gereedschapmaker()); //gereedschapsmaker
		}};
		sporen = new ISpoor[] {
			new Voedselspoor(), new Puntenspoor()
		};
	}

	public Voedselspoor getVoedselspoor() {
		for (ISpoor spoor : sporen) {
			if (spoor instanceof Voedselspoor) {
				return (Voedselspoor)spoor;
			}
		}
		return null;
	}

	public Puntenspoor getPuntenspoor() {
		for (ISpoor spoor : sporen) {
			if (spoor instanceof Puntenspoor) {
				return (Puntenspoor)spoor;
			}
		}
		return null;
	}

}
