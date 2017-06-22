package domainlayer.huttegels;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.huttegels.IHuttegel;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class HuttegelVrij extends UnicastRemoteObject implements IHuttegel {

	private String asset;
	private int min;
	private int max;
	
	public HuttegelVrij(String asset, int min, int max) throws RemoteException {
		this.asset = asset;
		this.min = min;
		this.max = max;
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
