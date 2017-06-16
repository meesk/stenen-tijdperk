package domainlayer.beschavingskaart;

/**
 * Dit is de factory die alle kaarten aan maakt en waar de kaarten hun specifieke eigenschappen krijgen.
 * @author Alex de Bruin, s1103096
 * @version 0.1
 */

import java.util.ArrayList;
import javafx.scene.image.Image;

import java.util.List;
import java.rmi.RemoteException;

import domainlayer.enums.Beschaving;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.enums.Middel;
import domainlayer.enums.Symbool;

public class BeschavingskaartFactory {

	private BeschavingskaartFactory instance;
	private List<Beschavingskaart> beschavingskaarten;


	public BeschavingskaartFactory() throws RemoteException{
		beschavingskaarten = new ArrayList<Beschavingskaart>() {{

			add(new BeschavingskaartSpoor("file:assets/Beschavingskaarten/Punten/01.png",3, new BeschavingskaartGras(Symbool.MUZIEK), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartSpoor("file:assets/Beschavingskaarten/Punten/02.png",3, new BeschavingskaartGras(Symbool.MUZIEK), BeschavingskaartStatus.VRIJ , 0));
			add(new BeschavingskaartSpoor("file:assets/Beschavingskaarten/Punten/03.png",3, new BeschavingskaartZand(3, Beschaving.HUTTENBOUWERS), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartSpoor("file:assets/Beschavingskaarten/Productie/02.png",1, new BeschavingskaartZand(1, Beschaving.BOEREN), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartSpoor("file:assets/Beschavingskaarten/Productie/01.png",1, new BeschavingskaartGras(Symbool.ZONNEWIJZER), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Grondstof/01.png", 1, new BeschavingskaartZand(1, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0, Middel.GOUD));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Grondstof/02.png", 1, new BeschavingskaartZand(1, Beschaving.BOEREN), BeschavingskaartStatus.VRIJ, 0, Middel.STEEN));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Grondstof/03.png", 1, new BeschavingskaartZand(1, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0, Middel.STEEN));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Grondstof/04.png", 1, new BeschavingskaartZand(2, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0, Middel.LEEM));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Grondstof/05.png", 2, new BeschavingskaartGras(Symbool.WIEL), BeschavingskaartStatus.VRIJ, 0, Middel.STEEN));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Voedsel/01.png", 2, new BeschavingskaartZand(2, Beschaving.HUTTENBOUWERS), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Voedsel/02.png", 4, new BeschavingskaartZand(1, Beschaving.HUTTENBOUWERS), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Voedsel/03.png", 3, new BeschavingskaartZand(2, Beschaving.BOEREN), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Voedsel/04.png", 5, new BeschavingskaartGras(Symbool.MEDICIJNEN), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Voedsel/05.png", 7, new BeschavingskaartGras(Symbool.POTTENBAKKEN), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Voedsel/06.png", 1, new BeschavingskaartGras(Symbool.WEEFGETOUW), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartMiddel("file:assets/Beschavingskaarten/Voedsel/07.png", 3, new BeschavingskaartGras(Symbool.WEEFGETOUW), BeschavingskaartStatus.VRIJ, 0, Middel.VOEDSEL));
			add(new BeschavingskaartExtraKaart("file:assets/Beschavingskaarten/kaart/01.png", new BeschavingskaartGras(Symbool.SCHRIFT), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbelen("file:assets/Beschavingskaarten/Grondstof/worp/01.png",1 ,new Middel[] {Middel.STEEN }, new BeschavingskaartZand(1, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbelen("file:assets/Beschavingskaarten/Grondstof/Worp/02.png",2 ,new Middel[] {Middel.HOUT }, new BeschavingskaartZand(2, Beschaving.MEDICIJNMANNEN), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbelen("file:assets/Beschavingskaarten/Grondstof/Worp/03.png",1 ,new Middel[] {Middel.GOUD }, new BeschavingskaartGras(Symbool.KUNST), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartGereedschap("file:assets/Beschavingskaarten/Gereedschap/01.png", 2, new BeschavingskaartZand(2, Beschaving.GEREEDSCHAPMAKERS), BeschavingskaartStatus.VRIJ, 0, false));
			add(new BeschavingskaartGereedschap("file:assets/Beschavingskaarten/Gereedschap/02.png", 3, new BeschavingskaartZand(1, Beschaving.GEREEDSCHAPMAKERS), BeschavingskaartStatus.VRIJ, 0, false));
			add(new BeschavingskaartGereedschap("file:assets/Beschavingskaarten/Gereedschap/03.png", 4, new BeschavingskaartZand(1, Beschaving.GEREEDSCHAPMAKERS), BeschavingskaartStatus.VRIJ, 0, false));
			add(new BeschavingskaartGereedschapFiche("file:assets/Beschavingskaarten/Gereedschap/nieuw/01.png", new BeschavingskaartGras(Symbool.KUNST), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/01.png", new BeschavingskaartGras(Symbool.SCHRIFT), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/02.png", new BeschavingskaartGras(Symbool.ZONNEWIJZER), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/05.png", new BeschavingskaartGras(Symbool.WIEL), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/10.png", new BeschavingskaartGras(Symbool.POTTENBAKKEN), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/03.png", new BeschavingskaartZand(1, Beschaving.HUTTENBOUWERS), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/04.png", new BeschavingskaartZand(2, Beschaving.BOEREN), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/06.png", new BeschavingskaartZand(2, Beschaving.GEREEDSCHAPMAKERS), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/07.png", new BeschavingskaartZand(2, Beschaving.GEREEDSCHAPMAKERS), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/08.png", new BeschavingskaartZand(1, Beschaving.BOEREN), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartDobbeltabel("file:assets/Beschavingskaarten/Dobbel/09.png", new BeschavingskaartZand(2, Beschaving.HUTTENBOUWERS), BeschavingskaartStatus.VRIJ, 0));
			add(new BeschavingskaartNaarKeuze("file:assets/Beschavingskaarten/Grondstof/keuze/01.png", new BeschavingskaartGras(Symbool.MEDICIJNEN), BeschavingskaartStatus.VRIJ, 0, false, null));
		}};
	}
}
