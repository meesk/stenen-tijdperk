package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

import domainlayer.skeleton.ISpeler;
import domainlayer.enums.Kleur;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ISpeler;
import javafx.scene.paint.Color;
import presentationlayer.LobbyView;
import presentationlayer.skeleton.ISpelObserver;

/**
 * Speler.java<br>
 * Een klasse waar de spelers worden aangemaakt.
 *
 * @author	Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @version	1.0
 */
public class Speler extends UnicastRemoteObject implements ISpeler {

	private Spel spel;
	private String naam;
	private String kleur;
	private LocalDate geboorteDatum;
	private boolean isSpastisch;
	private Tableau tableau;
	private boolean beurt = false;
	private boolean klaar;

	public Speler(Spel spel, ISpelObserver view, String naam, LocalDate geboorteDatum, boolean isSpastisch, String kleur) throws RemoteException {
		this.naam = naam;
		this.geboorteDatum = geboorteDatum;
		this.isSpastisch = isSpastisch;
		this.spel = spel;
		this.klaar = false;
		this.kleur = kleur;
		tableau = new Tableau(this);
	}

	public void ophalenGegevens() {
		//Beschavingskaart + huttegels
		//Alle grondstoffen [geen voedsel]
		//Het puntenspoor.

		//alles optellen en dan een list terug sturen?
	}

	public void extraTelling() {
		//Stamleden
		//Gereedschap
		//Granenspoor
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

	public boolean getKlaar() {
		return klaar;
	}

	public Tableau getTableau() throws RemoteException {
		return tableau;
	}

	@Override
	public void klaarVoorSpeler() throws RemoteException {
		this.klaar = true;
	}

	public boolean isBeurt() {
		return beurt;
	}

	public void setBeurt(boolean beurt) {
		this.beurt = beurt;
	}
}
