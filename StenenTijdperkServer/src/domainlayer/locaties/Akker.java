package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;
import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;
import stenentijdperk.StenenTijdperk;

/**
 * Deze klasse wordt gebruikt om een akker-locatie aan te maken.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public class Akker extends Locatie {

	/**
	 * Deze constructor zet een akker-locatie klaar.
	 * @param x  De X-positie van de locatie.
	 * @param y  De Y-positie van de locatie.
	 * @param width  De breedte van de locatie.
	 * @param height  De hoogte van de locatie.
	 * @param cirkels  Alle punten waar de cirkels zich bevinden.
	 */
	public Akker(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		super(x, y, width, height, cirkels);
	}

	@Override
	/** {@inheritDoc} */
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// Verhogen Voedselspoor
		ISpeelbord speelbord = StenenTijdperk.getSpel().getSpeelbord();
		ISpoor voedselspoor = speelbord.getVoedselspoor();
		int productie = voedselspoor.getProductie(speler);
		if (productie < 10) {
			voedselspoor.verhoogPunten(speler, 1);
		}
	}

	@Override
	/** {@inheritDoc} */
	public boolean isWorpNodig() throws RemoteException {
		return false;
	}
}
