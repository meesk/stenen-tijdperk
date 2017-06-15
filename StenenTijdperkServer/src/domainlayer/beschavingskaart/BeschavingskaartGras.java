package domainlayer.beschavingskaart;

/**
* Dit is de klasse waar alle kaarten op extenden als ze een groene achtergrond hebben
*@Author Alex de Bruin, s1103096
*@Version 0.1
*/

import domainlayer.enums.Symbool;


public class BeschavingskaartGras implements IBeschavingskaartAchtergrond {

	private Symbool symbool;

	BeschavingskaartGras(Symbool symbool){
		this.symbool = symbool;
	}
}
