import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domainlayer.Spel;
import domainlayer.Speler;
import domainlayer.Stamlid;
import domainlayer.Tableau;
import domainlayer.enums.Middel;


public class VoedenStamledenTest {
	
	public Tableau tableau;
	public Tableau tableauFout;
	public Map<Middel, Integer> middelen;
	public List<Stamlid> stamleden;
	
	@Before
	public void setUp() throws RemoteException{
		tableau = new Tableau(null);
		stamleden = new ArrayList<Stamlid>();
		// voeg 5 stamleden toe
		for(int i = 0; i < 5; i++){
			Stamlid s = new Stamlid(new Speler(new Spel(), "hoi", LocalDate.now(), false));
			stamleden.add(s);
		}
		tableau.ontvangStamleden(stamleden);
		
		// voeg 5 hout toe
		tableau.ontvangMiddelen(Middel.HOUT, 5);
	}
	
	@Test
	public void testVoedenStamledenCorrect() throws RemoteException {
		middelen = new HashMap<Middel, Integer>();
		middelen.put(Middel.VOEDSEL, 0);
		middelen.put(Middel.HOUT, 5);
		middelen.put(Middel.LEEM, 0);
		middelen.put(Middel.STEEN, 0);
		middelen.put(Middel.GOUD, 0);
		boolean b = tableau.voedenStamleden(middelen);
		Assert.assertTrue(b);
	}
	
	@Test
	public void testVoedenStamledenFout() throws RemoteException {
		middelen = new HashMap<Middel, Integer>();
		middelen.put(Middel.VOEDSEL, 0);
		middelen.put(Middel.HOUT, 10);
		middelen.put(Middel.LEEM, 0);
		middelen.put(Middel.STEEN, 0);
		middelen.put(Middel.GOUD, 0);
		boolean b = tableau.voedenStamleden(middelen);
		Assert.assertFalse(b);
	}

}
