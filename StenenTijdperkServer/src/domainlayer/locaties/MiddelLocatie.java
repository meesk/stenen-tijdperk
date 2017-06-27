package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.Speelbord;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;
import proceslayer.LocatieController;
import proceslayer.skeleton.ILocatieController;

/**
 * Deze klasse wordt gebruikt om een middel-locatie aan te maken.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public class MiddelLocatie extends Locatie {

	private Middel middel;

	/**
	 * Deze constructor zet een middel-locatie klaar.
	 * @param x  De X-positie van de locatie.
	 * @param y  De Y-positie van de locatie.
	 * @param width  De breedte van de locatie.
	 * @param height  De hoogte van de locatie.
	 * @param cirkels  Alle punten waar de cirkels zich bevinden.
	 * @param middel  Het type middel dat op deze locatie ligt.
	 */
	public MiddelLocatie(int x, int y, int width, int height, List<Point> cirkels, Middel middel) throws RemoteException {
		super(x, y, width, height, cirkels);
		this.middel = middel;
	}

	@Override
	/** {@inheritDoc} */
	public void uitvoerenActie(ISpeler speler, ILocatieController lController) throws RemoteException {
		// Teruggeven Stamleden
		ITableau tableau = speler.getTableau();
		tableau.ontvangMiddelen(middel, speler.getSpel().getDobbelsteenWorp().getTotaal() / middel.getWaarde());
	}

	@Override
	/** {@inheritDoc} */
	public boolean isWorpNodig() throws RemoteException {
		return true;
	}

}
