package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;

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
		ITableau tableau = speler.getTableau();
		int gereedschap = tableau.getTotaalGereedschap();
		if (gereedschap < 4) {
			tableau.geefGereedschapFiche();
		}
		else if (gereedschap < 12) {
			tableau.verhoogGereedschap();
		}
		// Teruggeven Stamleden
		/*List<IStamlid> stamleden = super.stamleden.stream().filter(s -> {
			try {
				return s.getSpeler() == speler;
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		}).collect(Collectors.toList());
		tableau.ontvangStamleden(stamleden);
		super.verwijderStamleden(stamleden);

		// Update Views (tableau)
		tableau.notifyObservers();

		// Update Views (locatie)
		super.notifyObservers();*/
	}

}
