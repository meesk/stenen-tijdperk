package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Map;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;
import domainlayer.enums.Middel;
import domainlayer.enums.SpelerStatus;
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
		this.status = SpelerStatus.GEEN_BEURT;
		this.voeden = false;
		for (ISpoor spoor : spel.getSpeelbord().getSporen()) {
			spoor.addSpeler(this);
		}
	}

	@Override
	public ILocatie getLaatsteLocatie() {
		return laatsteLocatie;
	}

	@Override
	public void setLaatsteLocatie(ILocatie laatsteLocatie) {
		this.laatsteLocatie = laatsteLocatie;
	}

	@Override
	public int ophalenGegevens() throws RemoteException {
		// Alles wordt opgehaald wat nodig is voor de eerste telling.
		int stamleden = tableau.getStamleden().size(); // Hier is stamleden ook nodig inverband met de beschavingskaart.

//		List<Beschavingskaart> spelerBeschavingsKaarten = tableau.getKaarten();
		Map<Middel, Integer> middelen = tableau.getMiddelen();
		int puntenSpoor = this.getSpel().getSpeelbord().getPuntenspoor().getMarkeerSteen(this);

		int telling = middelen.get(Middel.HOUT) +
				middelen.get(Middel.LEEM) +
				middelen.get(Middel.STEEN) +
				middelen.get(Middel.GOUD);
		// puntenspoor + berekening van beschavingskaarten nog.

		return telling;
	}

	@Override
	public int extraGegevens() throws RemoteException {
		int stamleden = tableau.getStamleden().size();
		int totaalGereedschap = tableau.getTotaalGereedschap();
		int granenspoor = this.getSpel().getSpeelbord().getVoedselspoor().getMarkeerSteen(this);


		int telling = stamleden +
				totaalGereedschap +
				granenspoor;

		return telling;
	}

	@Override
	public String getKleur() throws RemoteException {
		return kleur;
	}

	@Override
	public String getNaam() {
		return naam;
	}

	@Override
	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	@Override
	public boolean getSpasme() {
		return isSpastisch;
	}

	@Override
	public Spel getSpel() {
		return spel;
	}

	@Override
	public boolean isKlaar() {
		return klaar;
	}

	@Override
	public ITableau getTableau() throws RemoteException {
		return tableau;
	}

	@Override
	public void klaarVoorSpeler() throws RemoteException {
		this.klaar = true;
	}

	@Override
	public void setStatus(SpelerStatus status) {
		this.status = status;
	}

	@Override
	public SpelerStatus getStatus() {
		return status;
	}

}
