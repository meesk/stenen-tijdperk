package tristan;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domainlayer.Stamlid;
import domainlayer.Tableau;

/**
 * @author Tristan Caspers, s1102755
 * @version 0.1
 */

public class VerzamelenMiddelenTest {

	public Tableau tableau;
	public List<Stamlid> stamleden;

	@Before
	public void setUp() throws RemoteException {
		tableau = new Tableau(null);
		stamleden = new ArrayList<Stamlid>();
	}

	@Test
	public void testVerzamelenMiddelenCorrect() throws RemoteException {
		fail("Not yet implemented");
	}

	@Test
	public void testVerzamelenMiddelenFout() throws RemoteException {
		fail("Not yet implemented");
	}
}
