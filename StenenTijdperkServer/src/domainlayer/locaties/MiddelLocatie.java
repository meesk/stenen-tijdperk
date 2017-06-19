package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domainlayer.Speler;
import domainlayer.Stamlid;
import domainlayer.Tableau;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;

/**
 * @author Erwin Olie s1103026,
 * @author Tristan Caspers s1102755
 * @version	0.3
 */
public class MiddelLocatie extends Locatie {

	// Het type middel dat deze locatie bevat.
	private Middel middel;

	public MiddelLocatie(int x, int y, int width, int height, List<Point> cirkels, Middel middel) throws RemoteException {
		super(x, y, width, height, cirkels);
		this.middel = middel;
	}

	// ISpeler of Speler in uitvoerenActie() parameters?
	/** 14 Verzamelen Middelen **/
	public void uitvoerenActie(Speler speler) {
		// Teruggeven Stamleden
		Tableau tableau = null;
		try {
			tableau = speler.getTableau();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		List<IStamlid> stamleden = super.stamleden.stream().filter(s -> {
			try {
				return s.getSpeler() == speler;
			} catch (RemoteException e1) {
				e1.printStackTrace();
				return false;
			}
		}).collect(Collectors.toList());
		tableau.ontvangStamleden(stamleden);
		super.verwijderStamleden(stamleden);

		// Middelen Toevoegen
		try {
			tableau.ontvangMiddelen(middel, speler.getSpel().getDobbelsteenWorp().getTotaal() / middel.getWaarde());
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		// Update Views
		super.notifyObservers();
		tableau.notifyObservers();
	}

	@Override
	public void uitvoerenActie(ISpeler speler) {
		// TODO Auto-generated method stub
	}
}
