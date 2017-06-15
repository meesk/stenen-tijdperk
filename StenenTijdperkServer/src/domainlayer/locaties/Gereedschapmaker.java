package domainlayer.locaties;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import domainlayer.Stamlid;
import domainlayer.Tableau;
import domainlayer.skeleton.ISpeler;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.2
 */
public class Gereedschapmaker extends Locatie {

	public Gereedschapmaker() throws RemoteException {
		super(1);
	}

	@Override
	/** @see Sequentie Diagram: 11 Maken Gereedschap **/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		Tableau tableau = speler.getTableau();
		int gereedschap = tableau.getTotaalGereedschap();
		if (gereedschap < 4) {
			tableau.geefGereedschapFiche();
		}
		else if (gereedschap < 16) {
			tableau.verhoogGereedschap();
		}
		// Teruggeven Stamleden
		List<Stamlid> stamleden = super.stamleden.stream().filter(s -> s.getSpeler() == speler).collect(Collectors.toList());
		tableau.ontvangStamleden(stamleden);
		super.verwijderStamleden(stamleden);

		// Update Views (tableau)
		tableau.notifyObservers();
		
		// Update Views (locatie)
		super.notifyObservers();
	}

}
