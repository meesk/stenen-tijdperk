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
 * @author Erwin Olie s1103026
 * @author Alex de Bruin, s1103096
 * @version 0.4
 *
 *
 * Dit is de klasse die het Puntenspoor bij houdt en aanmaakt.
 */
public class Puntenspoor extends UnicastRemoteObject implements ISpoor {

	private Map<String, Integer> markeerstenen;
	private Point[] punten;
	private List<ISpoorObserver> observers;

	public Puntenspoor() throws RemoteException {
		markeerstenen = new HashMap<String, Integer>();
		observers = new ArrayList<>();
		initPunten();
	}

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
	public void verwijderPunten(ISpeler speler, int aantal) throws RemoteException {
		markeerstenen.put(speler.getKleur(), markeerstenen.get(speler.getKleur()) - aantal);
	}

	@Override
	public void verhoogPunten(ISpeler speler, int aantal) throws RemoteException {
		markeerstenen.put(speler.getKleur(), markeerstenen.get(speler.getKleur()) + aantal);
	}

	@Override
	public int getProductie(ISpeler speler) {
		return markeerstenen.get(speler);
	}

	public void verhoogProductie(ISpeler speler, int waarde) throws RemoteException {
		this.verhoogPunten(speler, waarde);

	}

	@Override
	public Map<String, Integer> getMarkeerstenen() throws RemoteException {
		return markeerstenen;
	}

	@Override
	public int getMarkeerSteen(ISpeler speler) throws RemoteException {
		return markeerstenen.get(speler.getKleur());

	}

	@Override
	public Point[] getPunten() throws RemoteException {
		return punten;
	}

	@Override
	public void addSpeler(ISpeler speler) throws RemoteException {
		markeerstenen.put(speler.getKleur(), 0);
	}

	@Override
	public void registerObserver(ISpoorObserver observer) throws RemoteException {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() throws RemoteException {
		for (ISpoorObserver observer : observers) {
			observer.modelChanged(this);
		}
	}


}
