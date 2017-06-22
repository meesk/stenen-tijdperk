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
 * @author Erwin Olie, s1103026
 * @version	0.2
 */
public class Hut extends Locatie {

	public Hut(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		super(x, y, width, height, cirkels);
	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// Verhogen aantal stamleden
		ITableau tableau = speler.getTableau();
		List<ILocatie> locaties = speler.getSpel().getSpeelbord().getLocaties();
		List<IStamlid> stamleden = new ArrayList<IStamlid>();
		int aantalStamleden = 0;
		int aantalleden = 0;
		
		for(ILocatie l : locaties){
			stamleden.addAll(l.getStamleden());
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
	public boolean isWorpNodig() throws RemoteException {
		return false;
	}

}
