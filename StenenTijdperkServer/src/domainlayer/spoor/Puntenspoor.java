package domainlayer.spoor;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;
import presentationlayer.skeleton.ISpoorObserver;

/**
 * Dit is de klasse die het model voor het puntenspoor bevat.
 * 
 * @author Erwin Olie s1103026
 * @author Alex de Bruin, s1103096
 * @version 3.0
 */
public class Puntenspoor extends UnicastRemoteObject implements ISpoor {

	private Map<String, Integer> markeerstenen;
	private Point[] punten;
	private List<ISpoorObserver> observers;

	/** Deze constructor maakt enkele standaardwaarde aan. */
	public Puntenspoor() throws RemoteException {
		markeerstenen = new HashMap<String, Integer>();
		observers = new ArrayList<>();
		initPunten();
	}

	/** Deze methode genereerd de punten waar de markeerstenen visueel staan. */
	private void initPunten() {
		punten = new Point[30+20+30+20];
		for (int i = 0; i < 31; i++) {
			punten[i] = new Point(12 + 28 * i, 10);
		}
		for (int i = 0; i < 21; i++) {
			punten[30 + i] = new Point(12 + 28 * 30, 10 + i * 29);
		}
		for (int i = 0; i < 31; i++) {
			punten[30 + 20 + i] = new Point(12 + 28 * 30 - 28 * i, 10 + 20 * 29);
		}
		for (int i = 0; i < 20; i++) {
			punten[30 + 20 + 30 + i] = new Point(12 + 28 * 30 - 28 * 30, 10 + 20 * 29 - i * 29);
		}
	}

	@Override
	/** {@inheritDoc} */
	public void verwijderPunten(ISpeler speler, int aantal) throws RemoteException {
		markeerstenen.put(speler.getKleur(), markeerstenen.get(speler.getKleur()) - aantal);
	}

	@Override
	/** {@inheritDoc} */
	public void verhoogPunten(ISpeler speler, int aantal) throws RemoteException {
		markeerstenen.put(speler.getKleur(), markeerstenen.get(speler.getKleur()) + aantal);
	}

	@Override
	/** {@inheritDoc} */
	public int getProductie(ISpeler speler) {
		return markeerstenen.get(speler);
	}

	@Override
	/** {@inheritDoc} */
	public Map<String, Integer> getMarkeerstenen() throws RemoteException {
		return markeerstenen;
	}

	@Override
	/** {@inheritDoc} */
	public int getMarkeerSteen(ISpeler speler) throws RemoteException {
		return markeerstenen.get(speler.getKleur());

	}

	@Override
	/** {@inheritDoc} */
	public Point[] getPunten() throws RemoteException {
		return punten;
	}

	@Override
	/** {@inheritDoc} */
	public void addSpeler(ISpeler speler) throws RemoteException {
		markeerstenen.put(speler.getKleur(), 0);
	}

	@Override
	/** {@inheritDoc} */
	public void registerObserver(ISpoorObserver observer) throws RemoteException {
		observers.add(observer);
	}

	@Override
	/** {@inheritDoc} */
	public void notifyObservers() throws RemoteException {
		for (ISpoorObserver observer : observers) {
			observer.modelChanged(this);
		}
	}
}

