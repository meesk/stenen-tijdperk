package domainlayer.huttegels;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.huttegels.IHuttegel;


/**
 * Deze klasse wordt gebruikt om huttegels de definiëren waarbij een de speler
 * vrij grondstoffen mag kiezen.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public class HuttegelVrij extends UnicastRemoteObject implements IHuttegel {

	private String asset;
	private int min;
	private int max;
	
	/**
	 * Deze constructor zet een vrij-huttegel klaar.
	 * @param asset  De url van de asset.
	 * @param min  Het minimale aantal grondstoffen dat gekozen mag worden.
	 * @param max  Het maximale aantal gronfstoffen dat gekozen mag worden.
	 */
	public HuttegelVrij(String asset, int min, int max) throws RemoteException {
		this.asset = asset;
		this.min = min;
		this.max = max;
	}

	@Override
	/** {@inheritDoc} */
	public void berekenWaarde() {
		// TODO
	}
	
	@Override
	/** {@inheritDoc} */
	public boolean uitvoerenActie(ISpeler speler) {
		return true;
	}

	@Override
	/** {@inheritDoc} */
	public String getAsset() throws RemoteException {
		return asset;
	}
	
}
