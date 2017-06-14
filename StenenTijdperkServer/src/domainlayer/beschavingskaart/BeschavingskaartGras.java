package domainlayer.beschavingskaart;

/*@Author Alex de Bruin, s1103096
*@Version 0.1
*/

import domainlayer.Symbool;

public class BeschavingskaartGras implements IBeschavingskaartAchtergrond {

	private Symbool symbool;

	BeschavingskaartGras(Symbool symbool){
		this.symbool = symbool;
	}
}
