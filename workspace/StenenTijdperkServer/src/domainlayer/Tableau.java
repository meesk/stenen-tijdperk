package domainlayer;

<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;
import presentationlayer.TableauView;
import domainlayer.skeleton.IStamlid;

/**
 * Tableau.java
 * De model klassen voor het Tableau
 * @author Mees Kluivers, s1102358
 * @version 0.1
 *
 */

public class Tableau extends UnicastRemoteObject implements ITableau{
	
	private int gereedschap;
	private Speler speler;
	private List<Stamlid> stamleden;
	private Middel middelen;
	private List<TableauView> observers;

	protected Tableau() throws RemoteException {
		observers = new ArrayList<>();
	}

	public void addObserver(TableauView observer) {
		observers.add(observer);
	}
	
	public void notifyObservers() {
		for (TableauView observer : observers) {
			observer.modelChanged(this);
		}
	}
	
	public List<Stamlid> getStamleden(){
		return stamleden;
	}
	
	public void krijgStamlid(){
		Stamlid s = new Stamlid(speler);
		stamleden.add(s);
	}

	public void ontvangStamleden(List<Stamlid> stamleden2) {
		// TODO Auto-generated method stub
		
	}

>>>>>>> 02428e714a0cc4023c621104c5265cf7013645ea
}
