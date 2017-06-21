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

/**
 * @author Erwin Olie, s1103026
 * @author Tristan Caspers, s1102755
 * @version	0.2
 */
public abstract class Locatie extends UnicastRemoteObject implements ILocatie {

	private int x, y;
	private int width, height;
	private List<Point> cirkels;
	protected List<IStamlid> stamleden;
	private List<ILocatieObserver> observers;

	public Locatie(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.cirkels = cirkels;
		stamleden = new ArrayList<>();
		observers = new ArrayList<>();
	}

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
	public abstract void uitvoerenActie(ISpeler speler) throws RemoteException;

	public void addObserver(LocatieView observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		for (ILocatieObserver observer : observers) {
			try {
				observer.modelChanged(this);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	public void verwijderStamleden(List<IStamlid> stamleden) {
		for (IStamlid stamlid : stamleden) {
			this.stamleden.remove(stamlid);
		}
	}

	// Nog speler specifiek maken
	@Override
	public List<IStamlid> getStamleden() {
		return stamleden;
	}

	@Override
	public List<IStamlid> getStamleden(ISpeler speler) throws RemoteException {

		List<IStamlid> lijstSpelerStamleden = new ArrayList<>();
		for(IStamlid stamlid : stamleden) {
			if (stamlid.getSpeler().equals(speler))
			lijstSpelerStamleden.add(stamlid);
		}
		return lijstSpelerStamleden;

	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public List<Point> getCirkels() {
		return cirkels;
	}

	public void betaalMiddelen() {

	}

	private void plaatsStamlid(ISpeler speler) throws RemoteException {
		IStamlid stamlid = speler.getTableau().popStamlid();
		stamleden.add(stamlid);
	}

	@Override
	public void plaatsStamleden(ISpeler speler, int aantal) throws RemoteException {
		for (int i = 0; i < aantal; i++) {
			plaatsStamlid(speler);
		}
		notifyObservers();
	}
	
	@Override
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
	public void registerObserver(ILocatieObserver observer) {
		observers.add(observer);
	}
}
