package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import javafx.scene.paint.Color;

/**
 * Speler.java
 * Een klasse waar de spelers worden aangemaakt.
 *
 * @author	Erwin Olie, s1103026
 * Enzo Campfens, s1102421
 * Mees Kluivers, s1102358
 * Tristan Caspers, s1102755
 * @version	0.4
 */
public class Speler extends UnicastRemoteObject implements ISpeler {

	private Spel spel;
	private String naam;
	//private Color kleur;
	private LocalDate geboorteDatum;
	private boolean isSpastisch;
	private Tableau tableau;

	public Speler(Spel spel, String naam, LocalDate geboorteDatum, boolean isSpastisch/*, Color kleur*/) throws RemoteException {
		this.naam = naam;
		this.geboorteDatum = geboorteDatum;
		this.isSpastisch = isSpastisch;
		this.spel = spel;
		//this.kleur = kleur;
		tableau = new Tableau(this);
	}

	public String getNaam() {
		return naam;
	}

	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	public boolean getSpasme() {
		return isSpastisch;
	}

	public Spel getSpel() {
		return spel;
	}

	public Tableau getTableau() throws RemoteException {
		return tableau;
	}
}
