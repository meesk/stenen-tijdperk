package domainlayer;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.huttegels.IHuttegel;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;
import domainlayer.beschavingskaart.Beschavingskaart;
import domainlayer.enums.Kleur;
import domainlayer.enums.Middel;
import domainlayer.enums.SpelerStatus;
import domainlayer.skeleton.ISpeler;
import javafx.scene.paint.Color;
import presentationlayer.LobbyView;
import presentationlayer.skeleton.ISpelObserver;

/**
 * Speler.java<br>
 * Een klasse waar de spelers worden aangemaakt.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @version	1.1
 */
public class Speler extends UnicastRemoteObject implements ISpeler {

	private Spel spel;
	private String naam;
	private String kleur;
	private LocalDate geboorteDatum;
	private boolean isSpastisch;
	private Tableau tableau;
	private boolean klaar;
	private SpelerStatus status;
	private boolean voeden;
	private ILocatie laatsteLocatie;

	public Speler(Spel spel, ISpelObserver view, String naam, LocalDate geboorteDatum, boolean isSpastisch, String kleur) throws RemoteException {
		this.naam = naam;
		this.geboorteDatum = geboorteDatum;
		this.isSpastisch = isSpastisch;
		this.spel = spel;
		this.klaar = false;
		this.kleur = kleur;
		tableau = new Tableau(this);
		this.status = status.GEEN_BEURT;
		this.voeden = false;
		for (ISpoor spoor : spel.getSpeelbord().getSporen()) {
			spoor.addSpeler(this);
		}
	}

	public ILocatie getLaatsteLocatie() {
		return laatsteLocatie;
	}

	public void setLaatsteLocatie(ILocatie laatsteLocatie) {
		this.laatsteLocatie = laatsteLocatie;
	}

	public int ophalenGegevens() throws RemoteException {
		// Alles wordt opgehaald wat nodig is voor de eerste telling.
		int stamleden = tableau.getStamleden().size(); // Hier is stamleden ook nodig inverband met de beschavingskaart.

		//		List<Beschavingskaart> spelerBeschavingsKaarten = tableau.getKaarten();
		Map<Middel, Integer> middelen = tableau.getMiddelen();
		int puntenSpoor = this.getSpel().getSpeelbord().getPuntenspoor().getMarkeerSteen(this);

		int telling = middelen.get(Middel.HOUT) +
				middelen.get(Middel.LEEM) +
				middelen.get(Middel.STEEN) +
				middelen.get(Middel.GOUD) +
				puntenSpoor;
		// puntenspoor + berekening van beschavingskaarten nog.

		return telling;
	}

	public int extraGegevens() throws RemoteException {
		List<ILocatie> locaties = this.getSpel().getSpeelbord().getLocaties();
		List<IStamlid> spelBordStamleden = new ArrayList<IStamlid>();
		int totaalStamleden = 0;

		for(ILocatie locatie : locaties){
			spelBordStamleden.addAll(locatie.getStamleden());
		}

		for(IStamlid stamlid : spelBordStamleden){
			if(stamlid.getSpeler().getKleur().equals(this.getKleur())){
				totaalStamleden++;
			}
		}

		totaalStamleden += tableau.getStamleden().size();

		int totaalGereedschap = tableau.getTotaalGereedschap();
		int granenspoor = this.getSpel().getSpeelbord().getVoedselspoor().getMarkeerSteen(this);


		int telling = totaalStamleden +
				totaalGereedschap +
				granenspoor;

		return telling;
	}

	public String getKleur() throws RemoteException {
		return kleur;
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

	public boolean isKlaar() {
		return klaar;
	}

	public ITableau getTableau() throws RemoteException {
		return tableau;
	}

	@Override
	public void klaarVoorSpeler() throws RemoteException {
		this.klaar = true;
	}

	public void setStatus(SpelerStatus status) {
		this.status = status;
	}

	public SpelerStatus getStatus() {
		return status;
	}

}
