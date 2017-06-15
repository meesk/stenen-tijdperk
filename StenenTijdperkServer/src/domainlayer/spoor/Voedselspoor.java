package domainlayer.spoor;

import java.util.HashMap;
<<<<<<< HEAD

/**	@author Alex de Bruin, s1103096
 * 	@Version 0.1
 *
 *<br>
* <br>
* Dit is de klasse die het Voedselspoor aanmaakt en bijhoudt.
 */

=======
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438
import java.util.Map;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;

/**
 * @author Erwin Olie s1103026
 * @version 0.3
 */
public class Voedselspoor implements ISpoor {

	private Map<ISpeler, Integer> markeerstenen;

<<<<<<< HEAD
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
=======
	public Voedselspoor() {
		markeerstenen = new HashMap<ISpeler, Integer>();
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
		// TODO Auto-generated method stub
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438

	}

}
