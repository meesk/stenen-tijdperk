package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;

/**
 * @author Erwin Olie, s1103026
 * @version	0.2
 */
public class Hut extends Locatie {

	public Hut(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		super(x, y, width, height, cirkels);
	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// Verhogen aantal stamleden
		ITableau tableau = speler.getTableau();
		int aantalStamleden = tableau.getStamleden().size();
		if (aantalStamleden < 8) {
			tableau.krijgStamlid();
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

		// update locatie view
		super.notifyObservers();

		// update tableau view
		tableau.notifyObservers();*/


	}

}
