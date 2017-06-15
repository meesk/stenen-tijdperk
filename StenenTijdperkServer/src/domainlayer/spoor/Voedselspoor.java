package domainlayer.spoor;

import java.util.HashMap;
import java.util.Map;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;

/**
 * @author Erwin Olie s1103026
 * @version 0.3
 */
public class Voedselspoor implements ISpoor {

	private Map<ISpeler, Integer> markeerstenen;

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

	}

}
