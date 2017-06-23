package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import domainlayer.beschavingskaart.Beschavingskaart;
import domainlayer.beschavingskaart.BeschavingskaartFactory;
import domainlayer.beschavingskaart.BeschavingskaartGras;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.huttegels.IHuttegel;
import domainlayer.spoor.Puntenspoor;
import presentationlayer.skeleton.ITableauObserver;

/**
 * Tableau.java<br>
 * Een klasse waar de tableau's worden aangemaakt.
 *
 * @author Tristan Caspers, s1102755
 * @author Erwin Olie, s1103026
 * @author Alex de Bruin, s1103096
 * @version 1.0
 */
public class Tableau extends UnicastRemoteObject implements ITableau {

	private List<IStamlid> stamleden;
	private Speler speler;
	private Map<Middel, Integer> middelen;
	private List<IBeschavingskaart> kaarten;
	private List<IHuttegel> huttegels;
	private List<ITableauObserver> observers;
	private boolean heeftBetaalt;

	private int[] gereedschap;
	private boolean[] gereedschapGebruikt;

	
	/**
	 * Het initialiseren van het tableau model
	 * @param speler  De speler van het tableau
	 * @throws RemoteException
	 */
	public Tableau(Speler speler) throws RemoteException {
		this.speler = speler;
		stamleden = new LinkedList<>();
		kaarten = new ArrayList<>();
		middelen = new HashMap<Middel, Integer>();

		middelen.put(Middel.VOEDSEL, 0);
		middelen.put(Middel.HOUT, 0);
		middelen.put(Middel.LEEM, 0);
		middelen.put(Middel.STEEN, 0);
		middelen.put(Middel.GOUD, 0);

		huttegels = new ArrayList<>();
		observers = new ArrayList<>();

		gereedschap = new int[] { 0, 0, 0 };
		gereedschapGebruikt = new boolean[] { false, false, false };
	}

	@Override
	public void ontvangMiddel(Middel middel) {
		ontvangMiddelen(middel, 1);
	}

	@Override
	public void ontvangMiddelen(Middel middel, int aantal) {
		middelen.put(middel, middelen.get(middel) + aantal);
	}

	public void ontvangStamlid(Stamlid stamlid) {
		stamleden.add(stamlid);
	}

	@Override
	public void gebruikStamlid(Stamlid stamlid) {
		stamleden.remove(stamlid);
	}

	@Override
	public List<IStamlid> getStamleden(){
		return stamleden;
	}

	@Override
	public void geefBeschavingskaarten(IBeschavingskaart kaart) {
		kaarten.add(kaart);
	}

	@Override
	public void notifyObservers() {
		for (ITableauObserver observer : observers) {
			try {
				observer.modelChanged(this);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void krijgStamlid() throws RemoteException {
		Stamlid s = new Stamlid(speler);
		stamleden.add(s);
	}

	@Override
	public void ontvangStamleden(List<IStamlid> stamleden) {
		this.stamleden.addAll(stamleden);
	}

	@Override
	public int getTotaalGereedschap() {
		int totaal = 0;
		for (int aantal : gereedschap) {
			totaal += aantal;
		}
		return totaal;
	}

	@Override
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
		notifyObservers();
	}

	@Override
	public void geefGereedschapFiche() {
		//
		verhoogGereedschap();
	}

	public void gebruikGereedschap(int index) throws RemoteException {
		speler.getSpel().getDobbelsteenWorp().addTotaal(gereedschap[index]);
		gereedschapGebruikt[index] = true;
		notifyObservers();

	}
	
	@Override
	public void resetGereedschapStatus() throws RemoteException {
		for(int i = 0; i < getGereedschapGebruikt().length; i++)
			gereedschapGebruikt[i] = false;
		notifyObservers();
		}

	public void verwijderMiddelen(Map<Middel, Integer> middelen){
		for (Entry<Middel, Integer> entry : middelen.entrySet()) {
			// Verwijder de middelen uit de lijst van middelen van het tableau
		    this.middelen.replace(entry.getKey(), this.middelen.get(entry.getKey()), this.middelen.get(entry.getKey()) - entry.getValue());
		}
	}

	/**
	 * Kijkt of middelen genoeg zijn, en of het tableau deze middelen heeft.
	 * @param middelen het aantal middelen dat in het betaalscherm is ingevoerd
	 * @return boolean true (stamleden gevoed), false (stamleden niet gevoed)
	 * @throws RemoteException
	 */
	@Override
	public boolean voedenStamleden(Map<Middel, Integer> middelen) throws RemoteException{

	    Integer aantalMiddelen = 0;

		for (Entry<Middel, Integer> entry : this.middelen.entrySet()) {
			//Check of er niet te teveel middelen zijn ingevult
		    if(entry.getValue() < middelen.get(entry.getKey())){
		    	return false;
		    }
		    aantalMiddelen += middelen.get(entry.getKey());
		}


	    // Check of er genoeg middelen zijn ingevult
		int aantal = stamleden.size() - speler.getSpel().getSpeelbord().getVoedselspoor().getMarkeerSteen(speler);
		if (aantal != aantalMiddelen){
	    	return false;
	    }

	    verwijderMiddelen(middelen);

	    notifyObservers();
		return true;
	}

	/**
	 * Verlies 10 punten op het voedselspoor
	 */
	@Override
	public boolean verliesPunten(){
		try {
			Puntenspoor puntenSpoor = (Puntenspoor)speler.getSpel().getSpeelbord().getPuntenspoor();
			puntenSpoor.verwijderPunten(speler, 10);

		} catch (RemoteException e) {
			return false;
		}

		return true;
	}

	@Override
	public void registerObserver(ITableauObserver observer) throws RemoteException {
		observers.add(observer);
		notifyObservers();
	}

	@Override
	public int[] getGereedschap() throws RemoteException {
		return gereedschap;
	}

	@Override
	public boolean[] getGereedschapGebruikt() throws RemoteException {
		return gereedschapGebruikt;
	}

	@Override
	public ISpeler getSpeler() throws RemoteException {
		return speler;
	}

	@Override
	public Map<Middel, Integer> getMiddelen() {
		return middelen;
	}

	public List<IBeschavingskaart> getKaarten() {
			return kaarten;

	}

	@Override
	public List<IHuttegel> getHuttegels() {
		return huttegels;
	}

	public List<ITableauObserver> getObservers() {
		return observers;
	}

	@Override
	public void setBetaalt(boolean betaalt){
		this.heeftBetaalt = betaalt;
	}

	@Override
	public boolean getBetaalt(){
		return heeftBetaalt;
	}

	@Override
	public IStamlid popStamlid() throws RemoteException {
		return (IStamlid)((LinkedList)stamleden).pop();
	}

	@Override
	public void geefHuttegel(IHuttegel huttegel) throws RemoteException {
		huttegels.add(huttegel);
		notifyObservers();
	}

	public void geefBeschavingskaart(IBeschavingskaart beschavingskaart) throws RemoteException {
		kaarten.add(beschavingskaart);
		notifyObservers();
	}

	@Override
	public void ontvangenBeschavingskaarten(IBeschavingskaart kaart) throws RemoteException {
		// TODO Auto-generated method stub

	}
}