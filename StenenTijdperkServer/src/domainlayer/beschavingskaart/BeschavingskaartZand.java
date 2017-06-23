package domainlayer.beschavingskaart;

/**
 * BeschavingskaartZand.java
* Dit is de klasse waar alle kaarten met een zand achtergrond van overerven
* @author Alex de Bruin, s1103096
* @version 3.0
*/

import domainlayer.enums.Beschaving;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaartAchtergrond;

public class BeschavingskaartZand implements IBeschavingskaartAchtergrond {


	private int factor;
	private Beschaving beschaving;

	/**
	 *De constructor van de zand achtergrond
	 * @param factor  de hoeveelheid de beschaving meetelt in de eindtelling
	 * @param beschaving  de soort achtergrondzand het is
	 */
	public BeschavingskaartZand(int factor, Beschaving beschaving){
		this.factor = factor;
		this.beschaving = beschaving;

	}

}
