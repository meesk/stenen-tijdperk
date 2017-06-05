package domainlayer.locaties;

import java.rmi.RemoteException;

import domainlayer.Middelen;
import domainlayer.Speler;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.2
 */
public class MiddelLocatie extends Locatie {

	// Het type middel dat deze locatie bevat.
	private Middelen middel;
	
	public MiddelLocatie(Middelen middel) {
		super(Integer.MAX_VALUE);
	}
	
	public MiddelLocatie(int cirkels, Middelen middel) {
		super(cirkels);
		this.middel = middel;
	}

	@Override
	public void uitvoerenActie(Speler speler) {
		super.uitvoerenActie(speler);
		try {
			speler.ontvangMiddelen(middel, speler.getSpel().getDobbelsteenWorp().getTotaal() / middel.getWaarde());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
