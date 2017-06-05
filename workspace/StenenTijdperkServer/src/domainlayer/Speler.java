package domainlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class Speler {

	private Spel spel;
	private List<Stamlid> stamleden;
	private Map<Middelen, Integer> middelen;

	public Speler(Spel spel) {
		this.spel = spel;
		stamleden = new ArrayList<>();
		middelen = new HashMap<>();
		middelen.put(Middelen.VOEDSEL, 0);
		middelen.put(Middelen.HOUT, 0);
		middelen.put(Middelen.LEEM, 0);
		middelen.put(Middelen.STEEN, 0);
		middelen.put(Middelen.GOUD, 0);
	}
	
	public void ontvangMiddel(Middelen middel) {
		ontvangMiddelen(middel, 1);
	}
	
	public void ontvangMiddelen(Middelen middel, int aantal) {
		middelen.put(middel, middelen.get(middel) + aantal);
	}

	public void ontvangStamlid(Stamlid stamlid) {
		stamleden.add(stamlid);
	}

	public void gebruikStamlid(Stamlid stamlid) {
		stamleden.remove(stamlid);
	}

	public Spel getSpel() {
		return spel;
	}


}
