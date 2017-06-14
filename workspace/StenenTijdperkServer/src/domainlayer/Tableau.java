package domainlayer;

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

}
