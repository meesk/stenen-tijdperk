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

/**	@author Alex de Bruin, s1103096
 *  <br>Erwin olie. s1103026
 * 	@Version 0.1
 *
 * <br>
 * <br>
 * Dit is de klasse die het Voedselspoor aanmaakt en bijhoudt.
 */

public class Voedselspoor extends UnicastRemoteObject implements ISpoor {

	private Map<String, Integer> markeerstenen;
	private List<ISpoorObserver> observers;
	private Point[] punten;

	public Voedselspoor() throws RemoteException {
		markeerstenen = new HashMap<String, Integer>();
		observers = new ArrayList<>();
		initPunten();
	}

	private void initPunten() {
		punten = new Point[11];
		for (int i = 0; i < 11; i++) {
			punten[i] = new Point(36, 560 - 29 * i);
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



	public Map<String, Integer> getMarkeerstenen() {
		return markeerstenen;
	}

	public int getProductie(ISpeler speler) throws RemoteException {
		return markeerstenen.get(speler.getKleur());
	}

	public void verhoogProductie(ISpeler speler) throws RemoteException {
		markeerstenen.put(speler.getKleur(), markeerstenen.get(speler.getKleur()) + 1);

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