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
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;
import domainlayer.spoor.Puntenspoor;
import domainlayer.spoor.Voedselspoor;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.3
 */
public class Speelbord extends UnicastRemoteObject implements ISpeelbord {

	private Spel spel;


	private List<ILocatie> locaties;
	private ISpoor[] sporen;

	public Speelbord(Spel spel) throws RemoteException {
		this.spel = spel;
		locaties = LocatieFactory.getInstance().getLocaties();
		sporen = new ISpoor[] {
			new Voedselspoor(), new Puntenspoor()
		};
	}

	public Voedselspoor getVoedselspoor() {
		for (ISpoor spoor : sporen) {
			if (spoor instanceof Voedselspoor) {
				return (Voedselspoor)spoor;
			}
		}
		return null;
	}

	public Puntenspoor getPuntenspoor() {
		for (ISpoor spoor : sporen) {
			if (spoor instanceof Puntenspoor) {
				return (Puntenspoor)spoor;
			}
		}
		return null;
	}

	public List<ILocatie> getLocaties() {
		return locaties;
	}

	public Spel getSpel() {
		return spel;
	}

}
