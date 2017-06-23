package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;
import domainlayer.enums.Middel;
import domainlayer.enums.SpelerStatus;
import presentationlayer.skeleton.ISpelObserver;

/**
 * Een klasse waar de spelers worden aangemaakt.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @version	3.0
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

	/**
	 * Het initialiseren van een speler.
	 * @param spel  het model (Spel)
	 * @param view  De observer van de view
	 * @param naam  De naam van de speler
	 * @param geboorteDatum  De geboortedatum van de speler
	 * @param isSpastisch  wel of niet spastisch
	 * @param kleur  de kleur van de speler
	 */
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
	/**{@inheritDoc}*/
	public ILocatie getLaatsteLocatie() {
		return laatsteLocatie;
	}

	@Override
	/**{@inheritDoc}*/
	public void setLaatsteLocatie(ILocatie laatsteLocatie) {
		this.laatsteLocatie = laatsteLocatie;
	}

	@Override
	/**{@inheritDoc}*/
	public int ophalenGegevens() throws RemoteException {
		// Alles wordt opgehaald wat nodig is voor de eerste telling.

		int stamleden = 0;
		int puntenSpoor = 0;

		stamleden = tableau.getStamleden().size(); // Hier is stamleden ook nodig inverband met de beschavingskaart.
		Map<Middel, Integer> middelen = tableau.getMiddelen();
		puntenSpoor = this.getSpel().getSpeelbord().getPuntenspoor().getMarkeerSteen(this);

		System.out.println("punten spoor : " + puntenSpoor);

		int telling = middelen.get(Middel.HOUT) +
				middelen.get(Middel.LEEM) +
				middelen.get(Middel.STEEN) +
				middelen.get(Middel.GOUD) +
				puntenSpoor;

		return telling;
	}

	@Override
	/**{@inheritDoc}*/
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

	@Override
	/**{@inheritDoc}*/
	public String getKleur() throws RemoteException {
		return kleur;
	}

	@Override
	/**{@inheritDoc}*/
	public String getNaam() {
		return naam;
	}

	@Override
	/**{@inheritDoc}*/
	public LocalDate getGeboorteDatum() {
		return geboorteDatum;
	}

	@Override
	/**{@inheritDoc}*/
	public boolean getSpasme() {
		return isSpastisch;
	}

	@Override
	/**{@inheritDoc}*/
	public ISpel getSpel() {
		return spel;
	}

	@Override
	/**{@inheritDoc}*/
	public boolean isKlaar() {
		return klaar;
	}

	@Override
	/**{@inheritDoc}*/
	public ITableau getTableau() throws RemoteException {
		return tableau;
	}

	@Override
	/**{@inheritDoc}*/
	public void setSpelerKlaar() throws RemoteException {
		this.klaar = true;
	}

	@Override
	/**{@inheritDoc}*/
	public void setStatus(SpelerStatus status) {
		this.status = status;
	}

	@Override
	/**{@inheritDoc}*/
	public SpelerStatus getStatus() {
		return status;
	}
}

