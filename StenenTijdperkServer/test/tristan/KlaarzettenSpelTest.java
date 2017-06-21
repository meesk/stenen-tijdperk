package tristan;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domainlayer.Stamlid;
import domainlayer.Tableau;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;

/**
 * @author Tristan Caspers, s1102755
 * @version 0.1
 */

public class KlaarzettenSpelTest {

	private Tableau tableau;
	private List<Stamlid> stamleden;
	private List<ISpeler> spelers;

	@Before
	public void setUp() throws RemoteException {
		tableau = new Tableau(null);
		stamleden = new ArrayList<Stamlid>();
		spelers = new ArrayList<ISpeler>();
	}

	@Test
	public void testKlaarzettenSpelCorrect() throws RemoteException {
		for(int i = 0; i < spelers.size(); i++) {
			spelers.get(i).getTableau().ontvangMiddelen(Middel.VOEDSEL, 12);
	        for (int j = 0; j <= 4; j++) {
	        	spelers.get(i).getTableau().krijgStamlid();
	        }
		}
	}

	@Test
	public void testKlaarzettenSpelFout() throws RemoteException {
		fail("Not yet implemented");
	}
}
