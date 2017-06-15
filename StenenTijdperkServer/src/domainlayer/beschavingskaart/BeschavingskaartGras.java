package domainlayer.beschavingskaart;

<<<<<<< HEAD
/**@Author Alex de Bruin, s1103096
*@Version 0.1
*
*<br>
* <br>
* Dit is de klasse waar alle kaarten op extenden als ze een groene achtergrond hebben
*/

import domainlayer.Symbool;
=======
import domainlayer.enums.Symbool;
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438

public class BeschavingskaartGras implements IBeschavingskaartAchtergrond {

	private Symbool symbool;

	BeschavingskaartGras(Symbool symbool){
		this.symbool = symbool;
	}
}
