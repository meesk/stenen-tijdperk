package domainlayer.locaties;

import java.util.List;
import java.util.stream.Collectors;

import domainlayer.Speelbord;
import domainlayer.Stamlid;
import domainlayer.Tableau;
import domainlayer.Voedselspoor;
import domainlayer.skeleton.ISpeler;

/**
 * @author	Erwin Olie, s1103026
 * Mees Kluivers, s1102358
 *
 * @version	0.1
 */
public class Hut extends Locatie {

	public Hut() {
		super(2);
	}

	@Override
	public void uitvoerenActie(ISpeler speler) {
		// Verhogen aantal stamleden
		Tableau tableau = speler.getTableau();
		int aantalStamleden = tableau.getStamleden().size();
		if (aantalStamleden < 8) {
			tableau.krijgStamlid();
		}
		
		// Teruggeven Stamleden
		List<Stamlid> stamleden = super.stamleden.stream().filter(s -> s.getSpeler() == speler).collect(Collectors.toList());
		tableau.ontvangStamleden(stamleden);
		super.verwijderStamleden(stamleden);
		
		// update locatie view
		super.notifyObservers();

		// update tableau view
		tableau.notifyObservers();
		
		
	}

}
