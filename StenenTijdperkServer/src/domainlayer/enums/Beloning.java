package domainlayer.enums;

/**
 * Deze enumerator bezit de soorten beloningen die de beschavingskaart
 * (dobbelen) kan bezitten
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public enum Beloning {
	HOUT(1), LEEM(2), STEEN(3), GOUD(4), GEREEDSCHAP(5), VOEDSELS(6);

	private int waarde;

	private Beloning(int waarde) {
		this.waarde = waarde;
	}

	public int getWaarde() {
		return waarde;
	}
}
