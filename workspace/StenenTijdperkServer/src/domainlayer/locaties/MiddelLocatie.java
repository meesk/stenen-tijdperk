package domainlayer.locaties;

import java.rmi.RemoteException;

import domainlayer.Middel;
import domainlayer.Speler;
import domainlayer.skeleton.ISpeler;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.2
 */
public class MiddelLocatie extends Locatie {

	// Het type middel dat deze locatie bevat.
	private Middel middel;

	public MiddelLocatie(Middel middel) {
		super(Integer.MAX_VALUE);
	}

	public MiddelLocatie(int cirkels, Middel middel) {
		super(cirkels);
		this.middel = middel;
	}

	/*@Override
	public void uitvoerenActie(Speler speler) {
		super.uitvoerenActie(speler);
		try {
			speler.ontvangMiddelen(middel, speler.getSpel().getDobbelsteenWorp().getTotaal() / middel.getWaarde());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}*/

	@Override
	public void uitvoerenActie(ISpeler speler) {
		// TODO Auto-generated method stub
		
	}

}
