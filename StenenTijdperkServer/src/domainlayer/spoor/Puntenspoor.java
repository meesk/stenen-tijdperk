package domainlayer.spoor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import domainlayer.skeleton.ISpeler;
import java.util.HashMap;
import java.util.Map;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.spoor.ISpoor;

/**
 * @author Erwin Olie s1103026
 * @author Alex de Bruin, s1103096
 * @version 0.4
 *
 *
 * Dit is de klasse die het Puntenspoor bij houdt en aanmaakt.
 */
public class Puntenspoor extends UnicastRemoteObject implements ISpoor {

	private Map<ISpeler, Integer> markeerstenen;

	public Puntenspoor() throws RemoteException {
		markeerstenen = new HashMap<ISpeler, Integer>();
	}

	@Override
	public void verwijderPunten(ISpeler speler, int aantal) {
		markeerstenen.put(speler, markeerstenen.get(speler) - aantal);
	}

	@Override
	public void verhoogPunten(ISpeler speler, int aantal) {
		markeerstenen.put(speler, markeerstenen.get(speler) + aantal);
	}

	public int getProductie(ISpeler speler) {
		return markeerstenen.get(speler);
	}

	public void verhoogProductie(ISpeler speler, int waarde) {
		this.verhoogPunten(speler, waarde);

	}

	@Override
	public Map<ISpeler, Integer> getMarkeerstenen() throws RemoteException {
		return markeerstenen;
	}
	
	public int getMarkeerSteen(ISpeler speler) throws RemoteException {
		return markeerstenen.get(speler);
		
	}


}
