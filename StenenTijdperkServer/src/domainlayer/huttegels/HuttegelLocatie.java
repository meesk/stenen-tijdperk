package domainlayer.huttegels;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.locaties.Locatie;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.huttegels.IHuttegel;
import stenentijdperk.StenenTijdperk;

/**
 * Deze klasse wordt gebruikt om een huttegel-locatie aan te maken.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public class HuttegelLocatie extends Locatie {

	private int index;

	/**
	 * Deze constructor zet een huttegel-locatie klaar.
	 * @param x  De X-positie van de locatie.
	 * @param y  De Y-positie van de locatie.
	 * @param width  De breedte van de locatie.
	 * @param height  De hoogte van de locatie.
	 * @param cirkels  Alle punten waar de cirkels zich bevinden.
	 * @param index  De index van de huttegel op het speelbord.
	 */
	public HuttegelLocatie(int x, int y, int width, int height, List<Point> cirkels, int index) throws RemoteException {
		super(x, y, width, height, cirkels);
		this.index = index;
	}

	@Override
	/** {@inheritDoc} */
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		IHuttegel huttegel = StenenTijdperk.getSpel().getSpeelbord().getHuttegel(index);
		if (huttegel.uitvoerenActie(speler)) {
			// Indien de huttegel gekocht is, geef deze aan de speler.
			StenenTijdperk.getSpel().getSpeelbord().popHuttegel(index);
			speler.getTableau().geefHuttegel(huttegel);
		}
		super.notifyObservers();
	}

	@Override
	/** {@inheritDoc} */
	public boolean isWorpNodig() throws RemoteException {
		return false;
	}
}

