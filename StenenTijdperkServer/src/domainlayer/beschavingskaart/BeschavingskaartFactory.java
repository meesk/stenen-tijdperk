package domainlayer.beschavingskaart;

/**
 * BeschavingskaartFactory.java
 * Dit is de factory die alle kaarten aan maakt en waar de kaarten hun specifieke eigenschappen krijgen.
 *
 * @author Alex de Bruin, s1103096
 * @author Tristan Caspers, s1102755
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;

import domainlayer.enums.Beschaving;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.enums.Symbool;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;

public class BeschavingskaartFactory {

	private static BeschavingskaartFactory instance;
	private List<IBeschavingskaart> beschavingskaarten;

	/** Het initialiseren van dit model. */
	public BeschavingskaartFactory() throws RemoteException{
		beschavingskaarten = new ArrayList<IBeschavingskaart>() {{

			add(new BeschavingskaartSpoor("punten/01.png",3, new BeschavingskaartGras(Symbool.MUZIEK), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartSpoor("punten/02.png",3, new BeschavingskaartGras(Symbool.MUZIEK), BeschavingskaartStatus.VRIJ , 0));
			add(new BeschavingskaartSpoor("punten/03.png",3, new BeschavingskaartZand(3, Beschaving.HUTTENBOUWERS), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartSpoor("productie/01.png",1, new BeschavingskaartGras(Symbool.ZONNEWIJZER), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartSpoor("productie/02.png",1, new BeschavingskaartZand(1, Beschaving.BOEREN), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartMiddel("grondstof/01.png", 1, new BeschavingskaartZand(1, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0, Middel.GOUD));
			add(new BeschavingskaartMiddel("grondstof/02.png", 1, new BeschavingskaartZand(1, Beschaving.BOEREN), BeschavingskaartStatus.VRIJ, 0, Middel.STEEN));
			add(new BeschavingskaartMiddel("grondstof/03.png", 1, new BeschavingskaartZand(1, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0, Middel.STEEN));
			add(new BeschavingskaartMiddel("grondstof/04.png", 1, new BeschavingskaartZand(2, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0, Middel.LEEM));
			add(new BeschavingskaartMiddel("grondstof/05.png", 2, new BeschavingskaartGras(Symbool.WIEL), BeschavingskaartStatus.VRIJ, 0, Middel.STEEN));
			add(new BeschavingskaartMiddel("voedsel/01.png", 2, new BeschavingskaartZand(2, Beschaving.HUTTENBOUWERS), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("voedsel/02.png", 4, new BeschavingskaartZand(1, Beschaving.HUTTENBOUWERS), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("voedsel/03.png", 3, new BeschavingskaartZand(2, Beschaving.BOEREN), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("voedsel/04.png", 5, new BeschavingskaartGras(Symbool.MEDICIJNEN), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("voedsel/05.png", 7, new BeschavingskaartGras(Symbool.POTTENBAKKEN), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("voedsel/06.png", 1, new BeschavingskaartGras(Symbool.WEEFGETOUW), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("voedsel/07.png", 3, new BeschavingskaartGras(Symbool.WEEFGETOUW), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartExtraKaart("kaart/01.png", new BeschavingskaartGras(Symbool.SCHRIFT), BeschavingskaartStatus.VRIJ, 0));
		//	add(new BeschavingskaartDobbelen("grondstof/worp/01.png", Middel.STEEN, new BeschavingskaartZand(1, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0));
		//	add(new BeschavingskaartDobbelen("grondstof/worp/02.png", Middel.HOUT, new BeschavingskaartZand(2, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0));
		//	add(new BeschavingskaartDobbelen("grondstof/worp/03.png", Middel.GOUD, new BeschavingskaartGras(Symbool.KUNST), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartGereedschap("gereedschap/01.png", 2, new BeschavingskaartZand(2, Beschaving.GEREEDSCHAPMAKERS), BeschavingskaartStatus.VRIJ, 0, false));
			add(new BeschavingskaartGereedschap("gereedschap/02.png", 3, new BeschavingskaartZand(1, Beschaving.GEREEDSCHAPMAKERS), BeschavingskaartStatus.VRIJ, 0, false));
			add(new BeschavingskaartGereedschap("gereedschap/03.png", 4, new BeschavingskaartZand(1, Beschaving.GEREEDSCHAPMAKERS), BeschavingskaartStatus.VRIJ, 0, false));
			add(new BeschavingskaartNaarKeuze("grondstof/keuze/01.png", new BeschavingskaartGras(Symbool.MEDICIJNEN), BeschavingskaartStatus.VRIJ, 0, false, null));
		}};
	}

	public IBeschavingskaart getBeschavingskaart(int plaats) {
		return beschavingskaarten.get(plaats);
	}

	public List<IBeschavingskaart> getBeschavingskaarten(){
		return beschavingskaarten;
	}


	public static BeschavingskaartFactory getInstance() {
		if (instance == null) {
			try {
				instance = new BeschavingskaartFactory();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
