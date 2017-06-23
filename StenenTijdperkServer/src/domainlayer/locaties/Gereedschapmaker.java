package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;

/**
 * Deze klasse wordt gebruikt om een gereedschapmaker-locatie aan te maken.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public class Gereedschapmaker extends Locatie {

	/**
	 * Deze constructor zet een gereedschapmaker-locatie klaar.
	 * @param x  De X-positie van de locatie.
	 * @param y  De Y-positie van de locatie.
	 * @param width  De breedte van de locatie.
	 * @param height  De hoogte van de locatie.
	 * @param cirkels  Alle punten waar de cirkels zich bevinden.
	 */
	public Gereedschapmaker(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		super(x, y, width, height, cirkels);
	}

	@Override
	/** {@inheritDoc} */
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// ontvangen gereedschap
		ITableau tableau = speler.getTableau();
		int gereedschap = tableau.getTotaalGereedschap();
		if (gereedschap < 4) {
			tableau.geefGereedschapFiche();
		}
		else if (gereedschap < 12) {
			tableau.verhoogGereedschap();
		}
	}

	@Override
	/** {@inheritDoc} */
	public boolean isWorpNodig() throws RemoteException {
		return false;
	}

}
