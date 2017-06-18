package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domainlayer.Stamlid;
import domainlayer.Tableau;
import domainlayer.skeleton.ISpeler;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.3
 */
public class Gereedschapmaker extends Locatie {

	public Gereedschapmaker(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		super(x, y, width, height, cirkels);
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
