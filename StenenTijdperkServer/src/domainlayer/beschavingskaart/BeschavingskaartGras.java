package domainlayer.beschavingskaart;

import domainlayer.enums.Symbool;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;


/**
 * Dit is de klasse die een gras kaart de juiste achtergrond assets meegeeft
 * @author Alex de Bruin, s1103096
 * @version 3.0
 */


public class BeschavingskaartGras implements IBeschavingskaartAchtergrond {

	private Symbool symbool;

	/**
	 * de constructor van de gras achtergrond
	 * @param symbool  Dit is een enumeration die een symbool meegeeft die belangrijk is voor de eindberekening
	 */
	public BeschavingskaartGras(Symbool symbool){
		this.symbool = symbool;
	}
}
