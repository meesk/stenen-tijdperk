package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domainlayer.skeleton.ISpeler;

/**
 * Speler.java
 * Een klasse waar de spelers worden aangemaakt.
 *
 * @author	Erwin Olie, s1103026
 * Enzo Campfens, s1102421
 * Mees Kluivers s1102358
 * @version	0.2
 */
public class Speler extends UnicastRemoteObject implements ISpeler {

	private Spel spel;
	private List<Stamlid> stamleden;
	private Map<Middel, Integer> middelen;
	private String naam;
	private LocalDate geboorteDatum;
	private boolean isSpastisch;
	private Tableau tableau;

	public Speler(Spel spel, String naam, LocalDate geboorteDatum, boolean isSpastisch) throws RemoteException {
		this.naam = naam;
		this.geboorteDatum = geboorteDatum;
		this.isSpastisch = isSpastisch;

		this.spel = spel;
		stamleden = new ArrayList<>();
		middelen = new HashMap<>();
		middelen.put(Middel.VOEDSEL, 0);
		middelen.put(Middel.HOUT, 0);
		middelen.put(Middel.LEEM, 0);
		middelen.put(Middel.STEEN, 0);
		middelen.put(Middel.GOUD, 0);
	}

	public void getNaam() {
		System.out.println(naam);
	}

	public void getGeboorteDatum() {
		System.out.println(geboorteDatum);
	}

	public void getSpasme() {
		System.out.println(isSpastisch);
	}


	public void ontvangMiddel(Middel middel) {
		ontvangMiddelen(middel, 1);
	}

	public void ontvangMiddelen(Middel middel, int aantal) {
		middelen.put(middel, middelen.get(middel) + aantal);
	}

	public void ontvangStamlid(Stamlid stamlid) {
		stamleden.add(stamlid);
	}

	public void gebruikStamlid(Stamlid stamlid) {
		stamleden.remove(stamlid);
	}

	public Spel getSpel() {
		return spel;
	}

	@Override
	public Tableau getTableau() {
		return tableau;
	}


}