package domainlayer.beschavingskaart;

/*@Author Alex de Bruin, s1103096
*@Version 0.1
*/

import domainlayer.Beschaving;

public class BeschavingskaartZand implements IBeschavingskaartAchtergrond{


	private int factor;
	private Beschaving beschaving;
	public BeschavingskaartZand(int factor, Beschaving beschaving){
		this.factor = factor;
		this.beschaving = beschaving;

	}

	}
