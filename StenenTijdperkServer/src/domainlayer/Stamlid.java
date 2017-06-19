package domainlayer;

import domainlayer.skeleton.IStamlid;

/**
 * Stamlid.java<br>
 * Een klasse waar de stamleden worden aangemaakt.
 *
 * @author	Erwin Olie, s1103026
 * @version	1.0
 */
public class Stamlid  implements IStamlid{
	private Speler speler;

	public Stamlid(Speler speler) {
		this.speler = speler;
	}

	public Speler getSpeler() {
		return speler;
	}
}
