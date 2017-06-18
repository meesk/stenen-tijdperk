package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domainlayer.enums.Kleur;
import domainlayer.enums.Middel;
import domainlayer.skeleton.ILobbyView;
import domainlayer.skeleton.ISpeler;
import javafx.scene.paint.Color;
import presentationlayer.LobbyView;

/**
 * Speler.java
 * Een klasse waar de spelers worden aangemaakt.
 *
 * @author	Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @version	0.5
 */
public class Speler extends UnicastRemoteObject implements ISpeler {

	private Spel spel;
	private String naam;
	private String kleur;
	private LocalDate geboorteDatum;
	private boolean isSpastisch;
	private Tableau tableau;

	private boolean klaar;

	public Speler(Spel spel, ILobbyView view) throws RemoteException {
		this.naam = view.getNaam();
		this.geboorteDatum = view.getGeboorteDatum();
		this.isSpastisch = view.getIsSpastisch();
		this.spel = spel;
		this.klaar = false;
		this.kleur = view.getKleur();
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
}
