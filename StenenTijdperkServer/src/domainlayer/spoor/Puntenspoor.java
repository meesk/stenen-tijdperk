package domainlayer.spoor;

import java.util.HashMap;
import java.util.Map;
import domainlayer.skeleton.ISpeler;
import java.util.HashMap;
import java.util.Map;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;

/**
 * @author Erwin Olie s1103026
 * @Author Alex de Bruin, s1103096
 * @version 0.2
 *
 * <br>
 * <br>
 * Dit is de klasse die het Puntenspoor bij houdt en aanmaakt.
 */
public class Puntenspoor implements ISpoor {

	private Map<ISpeler, Integer> markeerstenen;

	public Puntenspoor() {
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


}
