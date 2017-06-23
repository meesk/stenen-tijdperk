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
 * @version	1.2
 */
public class Speelbord extends UnicastRemoteObject implements ISpeelbord {

	private Spel spel;

	private List<ILocatie> locaties;
	private ISpoor voedselSpoor;
	private ISpoor puntenSpoor;
	private ILocatie laatstGekozenLcatie;
	private List<IHuttegel>[] huttegels;
	private IBeschavingskaart[] beschavingskaarten;
	private List<IBeschavingskaart> kaarten;
//	private List<IBeschavingskaart>[] beschavingskaarten;
//	private List<IBeschavingskaart> alleKaarten;
//	int index;


	public Speelbord(Spel spel) throws RemoteException {
		this.spel = spel;
		locaties = LocatieFactory.getInstance().getLocaties();
		voedselSpoor = new Voedselspoor();
		puntenSpoor = new Puntenspoor();
		initHuttegels();
		initBeschavingskaarten();
	//	this.index = 4;
	}

	public List<IBeschavingskaart> getKaarten() {
		return kaarten;
	}
	private void initBeschavingskaarten(){
		kaarten = BeschavingskaartFactory.getInstance().getBeschavingskaarten();
		Collections.shuffle(kaarten);
		beschavingskaarten = new IBeschavingskaart[4];
		if(beschavingskaarten[1] == null) {
			doorSchuiven();

		}
	}

	public void doorSchuiven() {
		for(int i = 0; i < 4; i++){
			System.out.println("Kaarten worden doorgeschoven");
			this.beschavingskaarten[i] = kaarten.get(i);
		}
	}


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

	public List<IHuttegel>[] getHuttegels() {
		return huttegels;
	}

	public IBeschavingskaart[] getBeschavingskaarten(){
		return beschavingskaarten;
	}

	public void setBeschavingskaarten() {
		for (int i = 0; i < 4; i++) {
			if (beschavingskaarten[i] != null) {
				beschavingskaarten[i] = null;
			}
		}
	}

	public void setLaatstGekozenLocatie(ILocatie locatie) {
		this.laatstGekozenLcatie = locatie;
	}

	public ILocatie getLaatstGekozenLocatie() {
		return laatstGekozenLcatie;
	}

	@Override
	public ISpoor getVoedselspoor() {
		return voedselSpoor;
	}

	@Override
	public ISpoor getPuntenspoor() {
		return puntenSpoor;
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

	@Override
	public List<ILocatie> getLocaties() {
		return locaties;
	}

	public Spel getSpel() {
		return spel;
	}

	@Override
	public ISpoor[] getSporen() throws RemoteException {
		return new ISpoor[] { puntenSpoor, voedselSpoor };
	}

	@Override
	public IHuttegel popHuttegel(int index) throws RemoteException {
		IHuttegel huttegel = huttegels[index].get(0);
		huttegels[index].remove(0);
		return huttegel;
	}


	public IBeschavingskaart popBeschavingskaart(int index) throws RemoteException {
		IBeschavingskaart beschavingskaart = beschavingskaarten[index];
		beschavingskaarten[index] = null;
		kaarten.remove(index);
		return beschavingskaart;
	}

	@Override
	public IHuttegel getHuttegel(int index) throws RemoteException {
		IHuttegel huttegel = huttegels[index].get(0);
		return huttegel;
	}

	//@Override
	//public void addBeschavingskaart(int index) throws RemoteException {
		// TODO Auto-generated method stub
//	}

//	public void addBeschavingskaart(int index){
//		this.beschavingskaarten[index].add(alleKaarten.get(this.index));
//		index++;
//	}

}
