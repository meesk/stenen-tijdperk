package domainlayer.spoor;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import domainlayer.skeleton.ISpeler;
import java.util.HashMap;
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
		punten = new Point[] {
			new Point(100, 100)
		};
		observers = new ArrayList<>();
	}

	@Override
	public void verwijderPunten(ISpeler speler, int aantal) throws RemoteException {
		markeerstenen.put(speler.getKleur(), markeerstenen.get(speler.getKleur()) - aantal);
	}

	@Override
	public void verhoogPunten(ISpeler speler, int aantal) throws RemoteException {
		markeerstenen.put(speler.getKleur(), markeerstenen.get(speler.getKleur()) + aantal);
	}

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
	
	public int getMarkeerSteen(ISpeler speler) throws RemoteException {
		return markeerstenen.get(speler);
		
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
