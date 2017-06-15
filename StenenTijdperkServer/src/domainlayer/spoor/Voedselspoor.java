package domainlayer.spoor;

import java.util.HashMap;
import java.util.Map;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;

/**	@author Alex de Bruin, s1103096
 *  <br>Erwin olie. s1103026
 * 	@Version 0.1
 *
 * <br>
 * <br>
 * Dit is de klasse die het Voedselspoor aanmaakt en bijhoudt.
 */

public class Voedselspoor implements ISpoor {

	private Map<ISpeler, Integer> markeerstenen;

	public Voedselspoor() {
		markeerstenen = new HashMap<ISpeler, Integer>();
	}

	@Override
	public void verwijderPunten(ISpeler speler, int aantal) {
		markeerstenen.put(speler, markeerstenen.get(speler) - aantal);
	}

	@Override
	public void verhoogPunten(ISpeler speler, int aantal) {
		markeerstenen.put(speler, markeerstenen.get(speler) + aantal);
	}



	public Map<ISpeler, Integer> getMarkeerstenen() {
		return markeerstenen;
	}

	public int getProductie(ISpeler speler) {
		return markeerstenen.get(speler);
	}

	public void verhoogProductie(ISpeler speler) {
		markeerstenen.put(speler, markeerstenen.get(speler) + 1);

	}

	public void notifyObservers() {

	}



}
