package domainlayer.locaties;

import java.util.List;
import java.util.ArrayList;

import domainlayer.Speler;
import domainlayer.Stamlid;
import domainlayer.skeleton.locaties.ILocatie;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class Locatie implements ILocatie {

	private int cirkels;
	private List<Stamlid> stamleden;

	public Locatie(int cirkels) {
		this.cirkels = cirkels;
		stamleden = new ArrayList<>();
	}

	public boolean plaatsStamlid(Stamlid stamlid) {
		if (stamleden.size() + 1 > cirkels) {
			return false;
		}
		stamleden.add(stamlid);
		stamlid.getSpeler().gebruikStamlid(stamlid);
		return true;
	}

	public void uitvoerenActie(Speler speler) {
		for (Stamlid stamlid : stamleden) {
			if (stamlid.getSpeler() != speler) {
				continue;
			}
			stamlid.getSpeler().ontvangStamlid(stamlid);
		}
		stamleden.removeIf(stamlid -> stamlid.getSpeler() == speler);
	}

}
