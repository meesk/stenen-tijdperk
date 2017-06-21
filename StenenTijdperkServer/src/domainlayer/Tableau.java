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
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
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
	private List<Beschavingskaart> kaarten;
	private List<IHuttegel> huttegels;
	private List<ITableauObserver> observers;
	private boolean heeftBetaalt;

	private int[] gereedschap;
	private boolean[] gereedschapGebruikt;

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

	public void ontvangenBeschavingskaarten(Beschavingskaart kaart) {
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

	/**
	 * Methode zorgt ervoor dat de gereedschaps punten opgeteld worden bij de dobbelstenen
	 * @author Alex de Bruin, s1103096
	 * @param positie
	 */
	public void gebruikGereedschap(int plaats/* de plaats dat op geklikt is*/) throws RemoteException {
		plaats -= 1;
		this.speler.getSpel().getDobbelsteenWorp().setTotaal(gereedschap[plaats]);


	}

	/**
	 * Deze methode zet het gereedschap op gebruikt.
	 *
	 * @author Alex de Bruin, s1103096
	 */

	public void setGereedschapStatus(int positie) {
		gereedschapGebruikt[positie] = true;

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
		    System.out.println("Nieuwe middelen: " + this.middelen.get(entry.getKey()));
		}
	}

	/**
	 * Kijkt of middelen genoeg zijn, en of het tableau deze middelen heeft.
	 * @author Mees Kluivers, s1102358
	 * @param middelen
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
		System.out.println("speler voedselspoor: " + speler.getSpel().getSpeelbord().getVoedselspoor().getMarkeerSteen(speler));
	    if (aantal != aantalMiddelen){
	    	return false;
	    }

	    verwijderMiddelen(middelen);

	    notifyObservers();
		return true;
	}

	/**
	 * @author Mees Kluivers, s1102358
	 * @param middelen
	 * @return true (betaald), false (niet betaald)
	 */
	public boolean betalen(Map<Middel, Integer> middelen){

	    List<Integer> values = new ArrayList<Integer>(middelen.values());
	    List<Integer> values1 = new ArrayList<Integer>(this.middelen.values());
	    Integer aantalMiddelen = 0;
	    for (int i = 0; i < values.size(); i++) {
		    // Check of er niet teveel middelen zijn ingevult
	    	if (!(values.get(i) <= values1.get(i)))
	    		return false;

    		aantalMiddelen = values.get(i);
	    }

	    if (stamleden.size() != aantalMiddelen)
	    	return false;

		return true;
	}

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

	public List<Beschavingskaart> getKaarten() {
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
}