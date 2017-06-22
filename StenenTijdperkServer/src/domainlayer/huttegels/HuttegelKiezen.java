package domainlayer.huttegels;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.huttegels.IHuttegel;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class HuttegelKiezen extends UnicastRemoteObject implements IHuttegel {

	private String asset;
	private int aantal;
	private int soorten;
	
	public HuttegelKiezen(String asset, int aantal, int soorten) throws RemoteException {
		this.asset = asset;
		this.aantal = aantal;
		this.soorten = soorten;
	}

	@Override
	public void berekenWaarde() {
		//
	}
	
	@Override
	public boolean uitvoerenActie(ISpeler speler) {
		return true;
	}

	@Override
	public String getAsset() throws RemoteException {
		return asset;
	}
	
}
