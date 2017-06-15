package domainlayer.spoor;

/**
 * @Author Alex de Bruin, s1103096
 * @Version 0.1
 *
 * <br>
* <br>
* Dit is de klasse die het Puntenspoor bij houdt en aanmaakt.
 */

import java.util.HashMap;
import java.util.Map;
import domainlayer.skeleton.ISpeler;




import domainlayer.skeleton.spoor.ISpoor;

public class Puntenspoor implements ISpoor {

	private Map<ISpeler, Integer> markeerstenen;

	public Puntenspoor(ISpeler speler, int aantal) {
		markeerstenen = new HashMap<>();
		markeerstenen.put(speler, 0);
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

		// ook aanpassen!!!!
	}

}
