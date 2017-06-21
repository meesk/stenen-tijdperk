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
		
		for(ILocatie l : locaties){
			stamleden.addAll(l.getStamleden());
		}
		
		for(IStamlid s : stamleden){
			if(s.getSpeler().getKleur().equals(speler.getKleur())){
				aantalStamleden++;
			}
		}
		
		aantalStamleden += tableau.getStamleden().size();
		if (aantalStamleden < 10) {
			tableau.krijgStamlid();
		}

		// Teruggeven Stamleden
		/*List<IStamlid> stamleden = super.stamleden.stream().filter(s -> {
			try {
				return s.getSpeler() == speler;
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
		}).collect(Collectors.toList());
		tableau.ontvangStamleden(stamleden);
		super.verwijderStamleden(stamleden);

		// update locatie view
		super.notifyObservers();

		// update tableau view
		tableau.notifyObservers();*/


	}

}
