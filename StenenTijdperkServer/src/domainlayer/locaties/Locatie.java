package domainlayer.locaties;

import java.util.List;
import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import domainlayer.Stamlid;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.locaties.ILocatie;
import presentationlayer.LocatieView;
import presentationlayer.skeleton.ILocatieObserver;
import proceslayer.LocatieController;
import proceslayer.skeleton.ILocatieController;

/**
 * Deze klasse wordt gebruikt om locaties op het speelbord te definiëren en te gebruiken.
 *
 * @author Erwin Olie, s1103026
 * @author Tristan Caspers, s1102755
 * @version 3.0
 */
public abstract class Locatie extends UnicastRemoteObject implements ILocatie {

	private int x, y;
	private int width, height;
	private List<Point> cirkels;
	private List<IStamlid> stamleden;
	private List<ILocatieObserver> observers;

	/**
	 * Deze constructor zet het locatie-model klaar.
	 * @param x  De X-positie van de locatie.
	 * @param y  De Y-positie van de locatie.
	 * @param width  De breedte van de locatie.
	 * @param height  De hoogte van de locatie.
	 * @param cirkels  Alle punten waar de cirkels zich bevinden.
	 */
	public Locatie(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.cirkels = cirkels;
		stamleden = new ArrayList<>();
		observers = new ArrayList<>();
	}

	/**
	 * Het plaatsen van een stamlid op de locatie.
	 * @param stamlid  De stamlid die geplaatst moet worden.
	 * @return Een boolean of de stamlid geplaatst mag worden.
	 */
	public boolean plaatsStamlid(Stamlid stamlid) {
		if (stamleden.size() + 1 > cirkels.size()) {
			return false;
		}
		stamleden.add(stamlid);
		try {
			stamlid.getSpeler().getTableau().gebruikStamlid(stamlid);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	/** {@inheritDoc} */
	public abstract void uitvoerenActie(ISpeler speler, ILocatieController lController) throws RemoteException;

	@Override
	/** {@inheritDoc} */
	public void notifyObservers() {
		for (ILocatieObserver observer : observers) {
			try {
				observer.modelChanged(this);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Het verwijderen van stamleden.
	 * @param stamleden  De stamleden die verwijderd moeten worden.
	 */
	public void verwijderStamleden(List<IStamlid> stamleden) {
		for (IStamlid stamlid : stamleden) {
			this.stamleden.remove(stamlid);
		}
	}

	@Override
	/** {@inheritDoc} */
	public List<IStamlid> getStamleden() {
		return stamleden;
	}

	@Override
	/** {@inheritDoc} */
	public List<IStamlid> getStamleden(ISpeler speler) throws RemoteException {

		List<IStamlid> lijstSpelerStamleden = new ArrayList<>();
		for(IStamlid stamlid : stamleden) {
			if (stamlid.getSpeler().equals(speler))
			lijstSpelerStamleden.add(stamlid);
		}
		return lijstSpelerStamleden;

	}

	@Override
	/** {@inheritDoc} */
	public int getX() {
		return x;
	}

	@Override
	/** {@inheritDoc} */
	public int getY() {
		return y;
	}

	@Override
	/** {@inheritDoc} */
	public int getWidth() {
		return width;
	}

	@Override
	/** {@inheritDoc} */
	public int getHeight() {
		return height;
	}

	@Override
	/** {@inheritDoc} */
	public List<Point> getCirkels() {
		return cirkels;
	}

	private void plaatsStamlid(ISpeler speler) throws RemoteException {
		IStamlid stamlid = speler.getTableau().popStamlid();
		stamleden.add(stamlid);
	}

	@Override
	/** {@inheritDoc} */
	public void plaatsStamleden(ISpeler speler, int aantal) throws RemoteException {
		for (int i = 0; i < aantal; i++) {
			plaatsStamlid(speler);
		}
		notifyObservers();
	}

	@Override
	/** {@inheritDoc} */
	public void verwijderStamlid(IStamlid stamlid) throws RemoteException {
		int index = -1;
		for (IStamlid s : stamleden) {
			if (s.equals(stamlid)) {
				index = stamleden.indexOf(s);
			}
		}
		stamleden.remove(index);
	}

	@Override
	/** {@inheritDoc} */
	public void registerObserver(ILocatieObserver observer) {
		observers.add(observer);
	}
}
