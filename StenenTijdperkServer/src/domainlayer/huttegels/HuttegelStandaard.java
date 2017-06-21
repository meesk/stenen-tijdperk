package domainlayer.huttegels;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.huttegels.IHuttegel;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public class HuttegelStandaard extends UnicastRemoteObject implements IHuttegel {

	private String asset;
	private int waarde;
	private Middel[] middelen;

	public HuttegelStandaard(String asset, Middel... middelen) throws RemoteException {
		this.asset = asset;
		this.middelen = middelen;
	}

	@Override
	public void berekenWaarde() {
		waarde = 0;
		for (Middel middel : middelen) {
			waarde += middel.getWaarde();
		}
	}

	@Override
	public void uitvoerenActie(ISpeler speler) {
		for (Middel middel : middelen) {
			try {
				speler.getTableau().ontvangMiddel(middel);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		berekenWaarde();
		//@@TODO: toevoegen waarde aan puntenspoor
	}

	@Override
	public String getAsset() throws RemoteException {
		return asset;
	}
}
