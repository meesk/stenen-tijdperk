package domainlayer.huttegels;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.huttegels.IHuttegel;

/**
 * Deze klasse wordt gebruikt om huttegels de definiëren waarbij een de speler
 * onder voorwaarde zelf grondstoffen mag kiezen.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public class HuttegelKiezen extends UnicastRemoteObject implements IHuttegel {

	private String asset;
	private int aantal;
	private int soorten;

	/**
	 * Deze constructor zet een kies-huttegel klaar.
	 * @param asset  De url van de asset.
	 * @param aantal  De totale hoeveelheid grondstoffen.
	 * @param soorten  Het aantal verschillende soorten grondstoffen.
	 */
	public HuttegelKiezen(String asset, int aantal, int soorten) throws RemoteException {
		this.asset = asset;
		this.aantal = aantal;
		this.soorten = soorten;
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
