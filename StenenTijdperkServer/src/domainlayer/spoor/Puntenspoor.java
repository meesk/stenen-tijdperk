package domainlayer.spoor;

<<<<<<< HEAD
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



=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;

/**
 * @author Erwin Olie s1103026
 * @version 0.2
 */
public class Puntenspoor implements ISpoor {

	private Map<ISpeler, Integer> markeerstenen;
<<<<<<< HEAD

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

=======

	public Puntenspoor() {
		markeerstenen = new HashMap<ISpeler, Integer>();
	}

	public Map<ISpeler, Integer> getMarkeerstenen() {
		return markeerstenen;
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438
	}

	@Override
	public Map<ISpeler, Integer> getMarkeerstenen() {
		return null;

		// ook aanpassen!!!!
	}

}
