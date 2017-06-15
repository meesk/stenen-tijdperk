package domainlayer.locaties;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import domainlayer.Speelbord;
import domainlayer.Stamlid;
import domainlayer.Tableau;
import domainlayer.skeleton.ISpeler;
import domainlayer.spoor.Voedselspoor;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.2
 */
public class Akker extends Locatie {

	public Akker() {
		super(1);
	}

	@Override
	/** @see Sequentie Diagram: 10 Gebruiken Akker **/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// Verhogen Voedselspoor
		Speelbord speelbord = super.speelbord;
		Voedselspoor voedselspoor = speelbord.getVoedselspoor();
		int productie = voedselspoor.getProductie(speler);
		if (productie < 10) {
			voedselspoor.verhoogProductie(speler);
		}

		// Teruggeven Stamleden
		Tableau tableau = speler.getTableau();
		List<Stamlid> stamleden = super.stamleden.stream().filter(s -> s.getSpeler() == speler).collect(Collectors.toList());
		tableau.ontvangStamleden(stamleden);
		super.verwijderStamleden(stamleden);

		// Update Views (locatie)
		super.notifyObservers();

		// Update Views (tableau)
		tableau.notifyObservers();

		// Update Views (voedselspoor)
		voedselspoor.notifyObservers();
	}
}
