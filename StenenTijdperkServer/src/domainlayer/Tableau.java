package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domainlayer.skeleton.ITableau;
import presentationlayer.TableauView;

/**
 * @author Tristan Caspers s1102755
 * @version 0.1
 */

// MOET NOG AANGEPAST WORDEN IN VERBAND MET SPELER.JAVA ANDERS ONTSTAAT DUBBELE CODE
public class Tableau extends UnicastRemoteObject implements ITableau {

	private List<Stamlid> stamleden;
	private Speler speler;
	private Map<Middel, Integer> middelen;
	private List<TableauView> observers;

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

	public void voedenStamleden(Map<Middel, Integer> middelen){
		middelen.keySet();
	}

	public void gebruikStamlid(Stamlid stamlid) {
		stamleden.remove(stamlid);
	}

	public List<Stamlid> getStamleden(){
		return stamleden;
	}

	public void notifyObservers() {
		for (TableauView observer : observers) {
			observer.modelChanged(this);
		}
	}

	public void krijgStamlid(){
		Stamlid s = new Stamlid(speler);
		stamleden.add(s);
	}

	public void ontvangStamleden(List<Stamlid> stamleden2) {

	}
}