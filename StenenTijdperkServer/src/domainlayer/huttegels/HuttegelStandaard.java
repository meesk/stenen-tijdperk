package domainlayer.huttegels;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

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
	
	private Map<Middel, Integer> getMiddelMap() {
		Map<Middel, Integer> result = new HashMap<Middel, Integer>();
		result.put(Middel.HOUT, 0);
		result.put(Middel.LEEM, 0);
		result.put(Middel.STEEN, 0);
		result.put(Middel.GOUD, 0);
		for (Middel middel : middelen) {
			result.put(middel, result.get(middel) + 1);
		}
		return result;
	}

	@Override
	public boolean uitvoerenActie(ISpeler speler) throws RemoteException {
		Map<Middel, Integer> cost = getMiddelMap();
		for (Middel middel : cost.keySet()) {
			if (cost.get(middel) > speler.getTableau().getMiddelen().get(middel)) {
				return false;
			}
		}
		berekenWaarde();
		speler.getSpel().getSpeelbord().getPuntenspoor().verhoogPunten(speler, waarde);
		return true;
	}

	@Override
	public String getAsset() throws RemoteException {
		return asset;
	}
}
