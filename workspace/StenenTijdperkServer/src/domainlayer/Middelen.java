package domainlayer;

/**
 * MiddelEnum.java
 * De enumerable die gaat over de verschillende type middelen.
 * 
 * @author Erwin Olie, s1103026
 * @version 0.1
 */
public enum Middelen {
	// De soorten middelen met hun waarde
	VOEDSEL(2), HOUT(3), LEEM(4), STEEN(5), GOUD(6);

	private int waarde;

	private Middelen(int waarde) {
		this.waarde = waarde;
	}

	public int getWaarde() {
		return waarde;
	}
}
