package domainlayer.spoor;

import java.util.HashMap;
import java.util.Map;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;

/**
 * @author Erwin Olie s1103026
 * @version 0.2
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
		// TODO Auto-generated method stub
		return 0;
	}

	public void verhoogProductie(ISpeler speler) {
		// TODO Auto-generated method stub

	}

	public void notifyObservers() {
		// TODO Auto-generated method stub

	}

}
