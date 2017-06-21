package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import domainlayer.enums.Middel;
import domainlayer.locaties.Akker;
import domainlayer.locaties.Gereedschapmaker;
import domainlayer.locaties.Hut;
import domainlayer.locaties.Locatie;
import domainlayer.locaties.LocatieFactory;
import domainlayer.locaties.MiddelLocatie;
import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;
import domainlayer.spoor.Puntenspoor;
import domainlayer.spoor.Voedselspoor;

/**
 * Speelbord.java
 * Een klasse waar het speelbord wordt aangemaakt.
 *
 * @author	Erwin Olie, s1103026
 * @version	1.0
 */
public class Speelbord extends UnicastRemoteObject implements ISpeelbord {

	private Spel spel;

	private List<ILocatie> locaties;
	private ISpoor[] sporen;
	private ILocatie laatstGekozenLcatie;

	public Speelbord(Spel spel) throws RemoteException {
		this.spel = spel;
		locaties = LocatieFactory.getInstance().getLocaties();
		sporen = new ISpoor[] {
			new Voedselspoor(), new Puntenspoor()
		};
	}

	public void setLaatstGekozenLocatie(ILocatie locatie) {
		this.laatstGekozenLcatie = locatie;
	}

	public ILocatie getLaatstGekozenLocatie() {
		return laatstGekozenLcatie;

	}
	public ISpoor getVoedselspoor() {
		for (ISpoor spoor : sporen) {
			if (spoor instanceof Voedselspoor) {
				return (Voedselspoor)spoor;
			}
		}
		return null;
	}

	public ISpoor getPuntenspoor() {
		for (ISpoor spoor : sporen) {
			if (spoor instanceof Puntenspoor) {
				return (Puntenspoor)spoor;
			}
		}
		return null;
	}
	
	public boolean heeftStamleden(ISpeler speler) throws RemoteException {
		for (ILocatie locatie : locaties) {
			for (IStamlid stamlid : locatie.getStamleden()) {
				if (speler.getKleur().equals(stamlid.getSpeler().getKleur())) {
					return true;
				}
			}
		}
		return false;
	}

	public List<ILocatie> getLocaties() {
		return locaties;
	}

	public Spel getSpel() {
		return spel;
	}

	@Override
	public ISpoor[] getSporen() throws RemoteException {
		return sporen;
	}

}
