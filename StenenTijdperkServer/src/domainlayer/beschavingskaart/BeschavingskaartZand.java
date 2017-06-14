package domainlayer.beschavingskaart;

import domainlayer.enums.Beschaving;

public class BeschavingskaartZand implements IBeschavingskaartAchtergrond{


	private int factor;
	private Beschaving beschaving;
	public BeschavingskaartZand(int factor, Beschaving beschaving){
		this.factor = factor;
		this.beschaving = beschaving;

	}

	}
