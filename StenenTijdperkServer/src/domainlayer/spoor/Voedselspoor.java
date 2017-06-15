package domainlayer.spoor;

import java.util.HashMap;

/**	@author Alex de Bruin, s1103096
 * 	@Version 0.1
 *
 *<br>
* <br>
* Dit is de klasse die het Voedselspoor aanmaakt en bijhoudt.
 */

import java.util.Map;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;

public class Voedselspoor implements ISpoor{

	Map<ISpeler, Integer> markeerstenen;

	Voedselspoor(ISpeler speler, int aantal){
		markeerstenen = new HashMap<>();
		markeerstenen.put(speler, 0);
	}

	@Override
	public void verwijderPunten(ISpeler speler, int aantal) {
		markeerstenen.put(speler, markeerstenen.get(speler) - aantal);
	}

	@Override
	public void verhoogPunten(ISpeler speler, int aantal) {
		markeerstenen.put(speler, markeerstenen.get(speler) + aantal);
	}

	@Override
	public Map<ISpeler, Integer> getMarkeerstenen() {
		return null;
		// moet nog veranderd worden maar hoe??
	}


	// doet dit niet precies het zelfde als die andere methode
	public Map<ISpeler, Integer> getProductie(int aantal) {
		return null;

	}

	public void verhoogProductie(int aantal) {

	}

}
