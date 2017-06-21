package domainlayer.beschavingskaart;

/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de klasse waar alle kaarten met een zand achtergrond van overerven
*/

import domainlayer.enums.Beschaving;

public class BeschavingskaartZand implements IBeschavingskaartAchtergrond {


	private int factor;
	private Beschaving beschaving;

	public BeschavingskaartZand(int factor, Beschaving beschaving){
		this.factor = factor;
		this.beschaving = beschaving;

	}

}
