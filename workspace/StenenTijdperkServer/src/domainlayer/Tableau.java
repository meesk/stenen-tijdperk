package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domainlayer.skeleton.ITableau;

/**
 * @author Tristan Caspers s1102755
 * @version 0.1
 */

// MOET NOG AANGEPAST WORDEN SAMEN MET SPELER.JAVA
public class Tableau extends UnicastRemoteObject implements ITableau {

	private List<Stamlid> stamleden;
	private Map<Middel, Integer> middelen;

	public Tableau() throws RemoteException {
		stamleden = new ArrayList<>();
		middelen = new HashMap<>();
		middelen.put(Middel.VOEDSEL, 0);
		middelen.put(Middel.HOUT, 0);
		middelen.put(Middel.LEEM, 0);
		middelen.put(Middel.STEEN, 0);
		middelen.put(Middel.GOUD, 0);
	}

	public void ontvangMiddel(Middel middel) {
		ontvangMiddelen(middel, 1);
	}

	public void ontvangMiddelen(Middel middel, int aantal) {
		middelen.put(middel, middelen.get(middel) + aantal);
	}

	public void ontvangStamlid(Stamlid stamlid) {
		stamleden.add(stamlid);
	}

	public void gebruikStamlid(Stamlid stamlid) {
		stamleden.remove(stamlid);
	}
}
