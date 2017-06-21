package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domainlayer.Speelbord;
import domainlayer.Stamlid;
import domainlayer.Tableau;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
import domainlayer.spoor.Voedselspoor;

/**
 * @author Erwin Olie, s1103026
 * @version 0.3
 */
public class Akker extends Locatie {

	public Akker(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		super(x, y, width, height, cirkels);
	}

	@Override
	/** @see Sequentie Diagram: 10 Gebruiken Akker **/
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// Verhogen Voedselspoor
		Speelbord speelbord = super.speelbord;
		Voedselspoor voedselspoor = (Voedselspoor)speelbord.getVoedselspoor();
		int productie = voedselspoor.getProductie(speler);
		if (productie < 10) {
			voedselspoor.verhoogProductie(speler);
		}

		// Teruggeven Stamleden
		ITableau tableau = speler.getTableau();
		List<IStamlid> stamleden = super.stamleden.stream().filter(s -> {
			try {
				return s.getSpeler() == speler;
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		})
				.collect(Collectors.toList());
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
