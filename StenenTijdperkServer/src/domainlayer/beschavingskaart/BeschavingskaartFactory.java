package domainlayer.beschavingskaart;

/*@author Alex de Bruin, s1103096
 *@version 0.1
 */

import java.util.ArrayList;
import domainlayer.spoor.Puntenspoor;
import domainlayer.spoor.Voedselspoor;
import javafx.scene.image.Image;

import java.util.List;
import java.rmi.RemoteException;

import domainlayer.enums.Beschaving;
import domainlayer.enums.Middel;
import domainlayer.enums.Symbool;

public class BeschavingskaartFactory {

	private BeschavingskaartFactory instance;
	private List<Beschavingskaart> beschavingskaarten;


	public BeschavingskaartFactory() throws RemoteException{
		beschavingskaarten = new ArrayList<Beschavingskaart>() {{
			add(new BeschavingskaartSpoor(new Image("file:assets/Beschavingskaarten/Punten/01.png"), new Puntenspoor(3), new BeschavingskaartGras(Symbool.MUZIEK)));
			add(new BeschavingskaartSpoor(new Image("file:assets/Beschavingskaarten/Punten/02.png"), new Puntenspoor(3), new BeschavingskaartGras(Symbool.MUZIEK)));
			add(new BeschavingskaartSpoor(new Image("file:assets/Beschavingskaarten/Punten/03.png"), new Puntenspoor(3), new BeschavingskaartZand(3, Beschaving.HUTTENBOUWERS)));
			add(new BeschavingskaartSpoor(new Image("file:assets/Beschavingskaarten/Productie/02.png"), new Voedselspoor(1), new BeschavingskaartZand(1, Beschaving.BOEREN)));
			add(new BeschavingskaartSpoor(new Image("file:assets/Beschavingskaarten/Productie/01.png"), new Voedselspoor(1), new BeschavingskaartGras(Symbool.ZONNEWIJZER)));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Grondstof/01.png"), 1, new BeschavingskaartZand(1, Beschaving.MEDICIJNMANNEN), Middel.GOUD));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Grondstof/02.png"), 1, new BeschavingskaartZand(1, Beschaving.BOEREN), Middel.STEEN));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Grondstof/03.png"), 1, new BeschavingskaartZand(1, Beschaving.MEDICIJNMANNEN), Middel.STEEN));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Grondstof/04.png"), 1, new BeschavingskaartZand(2, Beschaving.MEDICIJNMANNEN), Middel.LEEM));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Grondstof/05.png"), 2, new BeschavingskaartGras(Symbool.WIEL),  Middel.STEEN));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Voedsel/01.png"), 2, new BeschavingskaartZand(2, Beschaving.HUTTENBOUWERS), Middel.VOEDSEL));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Voedsel/02.png"), 4, new BeschavingskaartZand(1, Beschaving.HUTTENBOUWERS), Middel.VOEDSEL));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Voedsel/03.png"), 3, new BeschavingskaartZand(2, Beschaving.BOEREN), Middel.VOEDSEL));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Voedsel/04.png"), 5, new BeschavingskaartGras(Symbool.MEDICIJNEN), Middel.VOEDSEL));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Voedsel/05.png"), 7, new BeschavingskaartGras(Symbool.POTTENBAKKEN), Middel.VOEDSEL));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Voedsel/06.png"), 1, new BeschavingskaartGras(Symbool.WEEFGETOUW), Middel.VOEDSEL));
			add(new BeschavingskaartMiddel(new Image("file:assets/Beschavingskaarten/Voedsel/07.png"), 3, new BeschavingskaartGras(Symbool.WEEFGETOUW), Middel.VOEDSEL));
			add(new BeschavingskaartExtraKaart(new Image("file:assets/Beschavingskaarten/kaart/01.png"), new BeschavingskaartGras(Symbool.SCHRIFT)));
			add(new BeschavingskaartDobbelen(new Image("file:assets/Beschavingskaarten/Grondstof/worp/01.png"),1 ,new Middel[] {Middel.STEEN }, new BeschavingskaartZand(1, Beschaving.MEDICIJNMANNEN)));
			add(new BeschavingskaartDobbelen(new Image("file:assets/Beschavingskaarten/Grondstof/Worp/02.png"),2 ,new Middel[] {Middel.HOUT }, new BeschavingskaartZand(2, Beschaving.MEDICIJNMANNEN)));
			add(new BeschavingskaartDobbelen(new Image("file:assets/Beschavingskaarten/Grondstof/Worp/03.png"),1 ,new Middel[] {Middel.GOUD }, new BeschavingskaartGras(Symbool.KUNST)));
			add(new BeschavingskaartGereedschap(new Image("file:assets/Beschavingskaarten/Gereedschap/01.png"), 2, new BeschavingskaartZand(2, Beschaving.GEREEDSCHAPMAKERS), false));
			add(new BeschavingskaartGereedschap(new Image("file:assets/Beschavingskaarten/Gereedschap/02.png"), 3, new BeschavingskaartZand(1, Beschaving.GEREEDSCHAPMAKERS), false));
			add(new BeschavingskaartGereedschap(new Image("file:assets/Beschavingskaarten/Gereedschap/03.png"), 4, new BeschavingskaartZand(1, Beschaving.GEREEDSCHAPMAKERS), false));
			add(new BeschavingskaartGereedschapFishe(new Image("file:assets/Beschavingskaarten/Gereedschap/nieuw/01.png"), new BeschavingskaartGras(Symbool.KUNST)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/01.png"), new BeschavingskaartGras(Symbool.SCHRIFT)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/02.png"), new BeschavingskaartGras(Symbool.ZONNEWIJZER)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/05.png"), new BeschavingskaartGras(Symbool.WIEL)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/10.png"), new BeschavingskaartGras(Symbool.POTTENBAKKEN)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/03.png"), new BeschavingskaartZand(1, Beschaving.HUTTENBOUWERS)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/04.png"), new BeschavingskaartZand(2, Beschaving.BOEREN)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/06.png"), new BeschavingskaartZand(2, Beschaving.GEREEDSCHAPMAKERS)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/07.png"), new BeschavingskaartZand(2, Beschaving.GEREEDSCHAPMAKERS)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/08.png"), new BeschavingskaartZand(1, Beschaving.BOEREN)));
			add(new BeschavingskaartDobbeltabel(new Image("file:assets/Beschavingskaarten/Dobbel/09.png"), new BeschavingskaartZand(2, Beschaving.HUTTENBOUWERS)));
			add(new BeschavingskaartNaarKeuze(new Image("file:assets/Beschavingskaarten/Grondstof/keuze/01.png"), new BeschavingskaartGras(Symbool.MEDICIJNEN), false, null));
		}};
	}
}
