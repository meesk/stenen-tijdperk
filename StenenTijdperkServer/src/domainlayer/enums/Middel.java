package domainlayer.enums;

/**
 * Deze enumerator bezit de verschillende soorten middelen die spelers kunnen
 * bezitten.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public enum Middel {
	VOEDSEL(2), HOUT(3), LEEM(4), STEEN(5), GOUD(6);

	private int waarde;

	private Middel(int waarde) {
		this.waarde = waarde;
	}

	public int getWaarde() {
		return waarde;
	}
}
