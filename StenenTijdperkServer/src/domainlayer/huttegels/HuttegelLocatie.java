package domainlayer.huttegels;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.locaties.Locatie;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.huttegels.IHuttegel;
import stenentijdperk.StenenTijdperk;

public class HuttegelLocatie extends Locatie {

	private int index;
	
	public HuttegelLocatie(int x, int y, int width, int height, List<Point> cirkels, int index) throws RemoteException {
		super(x, y, width, height, cirkels);
		this.index = index;
	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		IHuttegel huttegel = StenenTijdperk.getSpel().getSpeelbord().getHuttegel(index);
		if (huttegel.uitvoerenActie(speler)) {
			StenenTijdperk.getSpel().getSpeelbord().popHuttegel(index);
			speler.getTableau().geefHuttegel(huttegel);
		}
		super.notifyObservers();
	}

	@Override
	public boolean isWorpNodig() throws RemoteException {
		return false;
	}

}
