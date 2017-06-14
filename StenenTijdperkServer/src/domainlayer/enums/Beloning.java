package domainlayer.enums;

/**
 * @author Erwin Olie s1103026
 * @version 0.1
 */
public enum Beloning {
	HOUT(1), LEEM(2), STEEN(3), GOUD(4), GEREEDSCHAP(5), VOEDSELS(6);

	private int waarde;

	private Beloning(int waarde) {
		this.waarde = waarde;
	}

	public int getWaarde(){
		return waarde;
	}
}

