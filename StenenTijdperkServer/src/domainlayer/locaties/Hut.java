package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.locaties.ILocatie;

/**
 * Deze klasse wordt gebruikt om een hut-locatie aan te maken.
 * 
 * @author Mees Kluivers, s1102358
 * @version 3.0
 */
public class Hut extends Locatie {

	/**
	 * Deze constructor zet een hut-locatie klaar.
	 * @param x  De X-positie van de locatie.
	 * @param y  De Y-positie van de locatie.
	 * @param width  De breedte van de locatie.
	 * @param height  De hoogte van de locatie.
	 * @param cirkels  Alle punten waar de cirkels zich bevinden.
	 */
	public Hut(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		super(x, y, width, height, cirkels);
	}

	@Override
	/** {@inheritDoc} */
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// Verhogen aantal stamleden
		ITableau tableau = speler.getTableau();
		List<ILocatie> locaties = speler.getSpel().getSpeelbord().getLocaties();
		List<IStamlid> stamleden = new ArrayList<IStamlid>();
		int aantalStamleden = 0;
		int aantalleden = 0;
		
		// Pak alle stamleden van het bord
		for(ILocatie l : locaties){
			stamleden.addAll(l.getStamleden());
			// Pake alle stamleden van de hut
			if(l.getX() == 318){
				List<IStamlid> hutStamleden = l.getStamleden();
				for(IStamlid s : hutStamleden){
					if(s.getSpeler().getKleur().equals(speler.getKleur())){
						aantalleden++;
					}
					
				}
			}
		}
		
		for(IStamlid s : stamleden){
			if(s.getSpeler().getKleur().equals(speler.getKleur())){
				aantalStamleden++;
			}
		}
		
		aantalStamleden += tableau.getStamleden().size();
		
		if (aantalStamleden < 10 && aantalleden == 2) {
			tableau.krijgStamlid();
		}

	}

	@Override
	/** {@inheritDoc} */
	public boolean isWorpNodig() throws RemoteException {
		return false;
	}

}
