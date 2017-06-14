package domainlayer.locaties;

import java.util.List;
import java.util.ArrayList;

import domainlayer.Speelbord;
import domainlayer.Stamlid;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.locaties.ILocatie;
import presentationlayer.LocatieView;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public abstract class Locatie implements ILocatie {

	private int cirkels;
	protected List<Stamlid> stamleden;
	private List<LocatieView> observers;
	protected Speelbord speelbord;

	public Locatie(int cirkels) {
		this.cirkels = cirkels;
		stamleden = new ArrayList<>();
		observers = new ArrayList<>();
	}

	public boolean plaatsStamlid(Stamlid stamlid) {
		if (stamleden.size() + 1 > cirkels) {
			return false;
		}
		stamleden.add(stamlid);
		stamlid.getSpeler().gebruikStamlid(stamlid);
		return true;
	}

	public abstract void uitvoerenActie(ISpeler speler);

	public void addObserver(LocatieView observer) {
		observers.add(observer);
	}
	
	public void notifyObservers() {
		for (LocatieView observer : observers) {
			observer.modelChanged(this);
		}
	}

	public void verwijderStamleden(List<Stamlid> stamleden) {
		for (Stamlid stamlid : stamleden) {
			this.stamleden.remove(stamlid);
		}
	}

}