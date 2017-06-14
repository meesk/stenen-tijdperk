package domainlayer.spoor;

import java.util.HashMap;
import java.util.Map;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;

/**
 * @author Erwin Olie s1103026
 * @version 0.2
 */
public class Puntenspoor implements ISpoor {

	private Map<ISpeler, Integer> markeerstenen;

	public Puntenspoor() {
		markeerstenen = new HashMap<ISpeler, Integer>();
	}

	public Map<ISpeler, Integer> getMarkeerstenen() {
		return markeerstenen;
	}
}
