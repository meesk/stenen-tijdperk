package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domainlayer.enums.Middel;
import domainlayer.skeleton.ITableau;
import presentationlayer.TableauView;

/**
 * @author Tristan Caspers s1102755
 * @author Erwin Olie s1103026
 * @version 0.3
 */

// MOET NOG AANGEPAST WORDEN IN VERBAND MET SPELER.JAVA ANDERS ONTSTAAT DUBBELE CODE
public class Tableau extends UnicastRemoteObject implements ITableau {

	private List<Stamlid> stamleden;
	private Speler speler;
	private Map<Middel, Integer> middelen;
	private List<TableauView> observers;
	private int[] gereedschap;
	
	public Tableau() throws RemoteException {
		stamleden = new ArrayList<>();
		middelen = new HashMap<Middel, Integer>() {{
			put(Middel.VOEDSEL, 0);
			put(Middel.HOUT, 0);
			put(Middel.LEEM, 0);
			put(Middel.STEEN, 0);
			put(Middel.GOUD, 0);
		}};
		gereedschap = new int[] { 0, 0, 0 };
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
		//
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

	public void ontvangStamleden(List<Stamlid> stamleden) {
		this.stamleden.addAll(stamleden);
	}

	public int getTotaalGereedschap() {
		int totaal = 0;
		for (int aantal : gereedschap) {
			totaal += aantal;
		}
		return totaal;
	}

	public void verhoogGereedschap() {
		int index = gereedschap.length - 1, totaal = 0;
		for (int i = gereedschap.length - 1; i >= 0; i--) {
			int aantal = gereedschap[i];
			totaal += aantal;
			if (gereedschap[index] >= aantal) {
				index = i;
			}
		}
		if (totaal % gereedschap.length == 0) {
			index = 0;
		}
		gereedschap[index]++;
	}

	public void geefGereedschapFiche() {
		//
		verhoogGereedschap();
	}
}