package domainlayer;

import java.util.ArrayList;
import java.util.List;

import domainlayer.locaties.Akker;
import domainlayer.locaties.Gereedschapmaker;
import domainlayer.locaties.Hut;
import domainlayer.locaties.Locatie;
import domainlayer.locaties.MiddelLocatie;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class Speelbord {
	
	private Spel spel;
	private List<Locatie> locaties;
	
	public Speelbord(Spel spel) {
		this.spel = spel;
		locaties = new ArrayList<>();
		locaties.add(new MiddelLocatie(7, Middel.HOUT));
		locaties.add(new MiddelLocatie(7, Middel.LEEM));
		locaties.add(new MiddelLocatie(7, Middel.STEEN));
		locaties.add(new MiddelLocatie(7, Middel.GOUD));
		locaties.add(new MiddelLocatie(Middel.VOEDSEL));
		locaties.add(new Akker());
		locaties.add(new Hut());
		locaties.add(new Gereedschapmaker());
	}

	public Voedselspoor getVoedselspoor() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
