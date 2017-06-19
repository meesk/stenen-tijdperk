package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import domainlayer.beschavingskaart.Beschavingskaart;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
import domainlayer.spoor.Puntenspoor;
import presentationlayer.TableauView;
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

	private List<ITableauObserver> observers;

	private int[] gereedschap;
	private boolean[] gereedschapGebruikt;

	public Tableau(Speler speler) throws RemoteException {
		this.speler = speler;
		stamleden = new ArrayList<>();
		kaarten = new ArrayList<>();
		middelen = new HashMap<Middel, Integer>() {{
			put(Middel.VOEDSEL, 0);
			put(Middel.HOUT, 0);
			put(Middel.LEEM, 0);
			put(Middel.STEEN, 0);
			put(Middel.GOUD, 0);
		}};

		observers = new ArrayList<>();

		gereedschap = new int[] { 0, 0, 0 };
		gereedschapGebruikt = new boolean[] { false, false, false };
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

	public List<IStamlid> getStamleden(){
		return stamleden;
	}

	public void ontvangenBeschavingskaarten(Beschavingskaart kaart) {
		kaarten.add(kaart);
	}

	public void notifyObservers() {
		for (ITableauObserver observer : observers) {
			try {
				observer.modelChanged(this);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	public void krijgStamlid() {
		Stamlid s = new Stamlid(speler);
		stamleden.add(s);
	}

	public void ontvangStamleden(List<IStamlid> stamleden) {
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
	public void resetGereedschapStatus() throws RemoteException {
		for(int i = 0; i <= getGereedschapGebruikt().length; i++)
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
	public boolean voedenStamleden(Map<Middel, Integer> middelen) throws RemoteException{

	    List<Integer> valuesVanSpeler = new ArrayList<Integer>(middelen.values());
	    List<Integer> ingevoerdeValues = new ArrayList<Integer>(this.middelen.values());
	    Integer aantalMiddelen = 0;
	    for (int i = 0; i < valuesVanSpeler.size(); i++) {
		    // Check of er niet teveel middelen zijn ingevult
	    	if (!(valuesVanSpeler.get(i) <= ingevoerdeValues.get(i)))
	    		return false;

    		aantalMiddelen = valuesVanSpeler.get(i);
	    }


	    // Check of er genoeg middelen zijn ingevult
	    if (stamleden.size() != aantalMiddelen)
	    	return false;

	    verwijderMiddelen(middelen);
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

	public void verliesPunten(){
		Puntenspoor puntenSpoor = speler.getSpel().getSpeelbord().getPuntenspoor();
		puntenSpoor.verwijderPunten(speler, 10);
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
}