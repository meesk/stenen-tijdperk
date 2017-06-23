package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domainlayer.beschavingskaart.BeschavingskaartFactory;
import domainlayer.huttegels.HuttegelFactory;
import domainlayer.locaties.LocatieFactory;
import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.huttegels.IHuttegel;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;
import domainlayer.spoor.Puntenspoor;
import domainlayer.spoor.Voedselspoor;

/**
 * Speelbord.java
 * Een klasse waar het speelbord wordt aangemaakt.
 *
 * @author	Erwin Olie, s1103026
 * @author  Mees Kluivers, s1102358
 * @version	1.2
 */
public class Speelbord extends UnicastRemoteObject implements ISpeelbord {

	private Spel spel;

	private List<ILocatie> locaties;
	private ISpoor voedselSpoor;
	private ISpoor puntenSpoor;
	ILocatie laatstGekozenLcatie;
	private List<IHuttegel>[] huttegels;
	public IBeschavingskaart[] beschavingskaarten;
	private List<IBeschavingskaart> kaarten;

	/**
	 * Het initialiseren van het model speelbord
	 * @param spel  Het model spel
	 */
	public Speelbord(Spel spel) throws RemoteException {
		this.spel = spel;
		locaties = LocatieFactory.getInstance().getLocaties();
		voedselSpoor = new Voedselspoor();
		puntenSpoor = new Puntenspoor();
		initHuttegels();
		initBeschavingskaarten();
	}

	/** @return Alle beschavingskaarten in het spel. */
	public List<IBeschavingskaart> getKaarten() {
		return kaarten;
	}
	
	/** Maakt een nieuwe lijst aan met beschavingskaarten. */
	private void initBeschavingskaarten(){
		kaarten = BeschavingskaartFactory.getInstance().getBeschavingskaarten();
		Collections.shuffle(kaarten);
		beschavingskaarten = new IBeschavingskaart[4];
		if(beschavingskaarten[1] == null) {
			doorschuiven();
		}
	}

	/** Schuift de beschavingskaarten door op het speelbord */
	public void doorschuiven() {
		for(int i = 0; i < 4; i++){
			System.out.println("Kaarten worden doorgeschoven");
			this.beschavingskaarten[i] = kaarten.get(i);
		}
	}

	/** Het aanmaken van de lijst van huttegels */
	private void initHuttegels() {
		huttegels = new List[4];
		for (int i = 0; i < 4; i++) {
			huttegels[i] = new ArrayList<>();
		}
		List<IHuttegel> huttegels = HuttegelFactory.getInstance().getHuttegels();
		Collections.shuffle(huttegels);
		for (int i = 0; i < 28; i++) {
			this.huttegels[i / 7].add(huttegels.get(i));
		}
	}

	@Override
	/**{@inheritDoc}*/
	public List<IHuttegel>[] getHuttegels() {
		return huttegels;
	}

	@Override
	/**{@inheritDoc}*/
	public IBeschavingskaart[] getBeschavingskaarten(){
		return beschavingskaarten;
	}
	
	/**
	 * Verander de laatst gekozen locatie van de speler.
	 * @param locatie  De laatste locatie.
	 */
	public void setLaatstGekozenLocatie(ILocatie locatie) {
		this.laatstGekozenLcatie = locatie;
	}

	/** @return De laatst gekozen locatie */
	public ILocatie getLaatstGekozenLocatie() {
		return laatstGekozenLcatie;
	}

	@Override
	/** {@inheritDoc} */
	public ISpoor getVoedselspoor() {
		return voedselSpoor;
	}

	@Override
	/** {@inheritDoc} */
	public ISpoor getPuntenspoor() {
		return puntenSpoor;
	}

	/** Check of een speler stamleden heeft op een locatie */
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

	@Override
	/** {@inheritDoc} */
	public List<ILocatie> getLocaties() {
		return locaties;
	}

	@Override
	/** {@inheritDoc} */
	public ISpoor[] getSporen() throws RemoteException {
		return new ISpoor[] { puntenSpoor, voedselSpoor };
	}

	@Override
	/** {@inheritDoc} */
	public IHuttegel popHuttegel(int index) throws RemoteException {
		IHuttegel huttegel = huttegels[index].get(0);
		huttegels[index].remove(0);
		return huttegel;
	}

	@Override
	/** {@inheritDoc} */
	public IBeschavingskaart popBeschavingskaart(int index) throws RemoteException {
		IBeschavingskaart beschavingskaart = beschavingskaarten[index];
		beschavingskaarten[index] = null;
		kaarten.remove(index);
		return beschavingskaart;
	}

	@Override
	/** {@inheritDoc} */
	public IHuttegel getHuttegel(int index) throws RemoteException {
		IHuttegel huttegel = huttegels[index].get(0);
		return huttegel;
	}
}
