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
	private Map<Middel, Integer> middelen;

	public Speler(Spel spel) {
		this.spel = spel;
		stamleden = new ArrayList<>();
		middelen = new HashMap<>();
		middelen.put(Middel.VOEDSEL, 0);
		middelen.put(Middel.HOUT, 0);
		middelen.put(Middel.LEEM, 0);
		middelen.put(Middel.STEEN, 0);
		middelen.put(Middel.GOUD, 0);
	}
	
	public void ontvangMiddel(Middel middel) {
		ontvangMiddelen(middel, 1);
	}
	
	public void ontvangMiddelen(Middel middel, int aantal) {
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
