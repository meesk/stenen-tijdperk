package domainlayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import domainlayer.dobbelstenen.DobbelsteenWorp;
import domainlayer.enums.Middel;
import domainlayer.enums.SpelStatus;
import domainlayer.enums.SpelerStatus;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;
import presentationlayer.skeleton.ISpelObserver;

/**
 * De klasse waar alle elementen tot 1 spel worden gevoegd.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @author Alex de Bruin, s1103096
 * @version 3.0
 */
public class Spel extends UnicastRemoteObject implements ISpel {

	private ISpeler beurtSpeler;
	private Speelbord speelbord;

	private DobbelsteenWorp dobbelsteenWorp;
	private List<ISpeler> spelers;
	private int aangegevenSpelers;
	private SpelStatus status;
	private boolean laatsteRonde = false;
	private boolean klaarVoorStart = false;
	private boolean voeden;

	private Map<String, List<Integer>> puntenGeschiedenis;

	private List<ISpelObserver> observers;

	/** Het initialiseren van het model Spel. */
	public Spel() throws RemoteException {
		spelers = new ArrayList<ISpeler>();
		speelbord = new Speelbord(this);
		dobbelsteenWorp = new DobbelsteenWorp();

		puntenGeschiedenis = new HashMap<String, List<Integer>>();
		observers = new ArrayList<>();
	}

	@Override
	/** {@inheritDoc} */
	public void eindeSpel() {

		Map<String, Integer> spelerPuntenTotaal = new HashMap();

		try {
			for (int i = 0; i < spelers.size(); i++) {
				// per speler het totaal aantal punten eerste telling, weg gestopt onder naam.
				spelerPuntenTotaal.put(spelers.get(i).getKleur(), spelers.get(i).ophalenGegevens());
			}

			// Als bepaalWinnaar false is dan wordt hieronder de 2de telling gedaan.
			if (!bepaalWinnaar(spelerPuntenTotaal)) {
				for (int k = 0; k < spelers.size(); k++) {
					int temp = spelerPuntenTotaal.get(spelers.get(k).getKleur()) + spelers.get(k).extraGegevens();
					spelerPuntenTotaal.put(spelers.get(k).getKleur(), temp);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	/**{@inheritDoc}*/
	public Speelbord getSpeelbord() {
		return speelbord;
	}

	/**
	 * Punten geschiedenis bijhouden.
	 * @throws RemoteException
	 */
	public void vulPuntenGeschiedenis() throws RemoteException {

		for(int i = 0; i < spelers.size(); i++) {
			System.out.println("spelers gegevens : " + spelers.get(i).ophalenGegevens());
			System.out.println("Spelers naam : " + spelers.get(i).getKleur());
			puntenGeschiedenis.get(spelers.get(i).getKleur()).add(spelers.get(i).ophalenGegevens());
		}
	}

	public Map<String, List<Integer>> getPuntenGeschiedenis() {
		return this.puntenGeschiedenis;
	}

	/**
	 * Bepalen van de winnaar
	 * @param spelerPuntenTotaal
	 * @return boolean  winnaar wel of niet bepaald.
	 */
	public boolean bepaalWinnaar(Map<String, Integer> spelerPuntenTotaal) throws RemoteException {

		boolean winnaarBepaald 	= false;

		int highest 			= Integer.MIN_VALUE;
		int secondHighest		= Integer.MIN_VALUE;

		for (int i = 0; i < spelers.size(); i++) {
			if (spelerPuntenTotaal.get(spelers.get(i).getKleur()) > highest || spelerPuntenTotaal.get(spelers.get(i).getKleur()) == highest) {
				secondHighest = highest;
				highest = spelerPuntenTotaal.get(spelers.get(i).getKleur());
			}
		}

		if(highest != secondHighest && highest > secondHighest) {
			winnaarBepaald = true;
		}

		return winnaarBepaald;
	}

	@Override
	/** {@inheritDoc} */
	public DobbelsteenWorp getDobbelsteenWorp() {
		return dobbelsteenWorp;
	}

	@Override
	/** {@inheritDoc} */
	public void opslaan() throws IOException {
		// TODO
		//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("spel.ser")));
		//		oos.writeObject(this);
		//		oos.close();

		for(int k = 0; k < this.spelers.size(); k++ ) {
			System.out.println(spelers.get(k).getTableau().getMiddelen());
		}
	}

	/** Het inladen van een opgeslagen spelbestand. */
	public void laden() throws IOException, ClassNotFoundException {
		// TODO
		FileInputStream fis = new FileInputStream("spel.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Spel spel = (Spel) ois.readObject();
		ois.close();
	}

	@Override
	/** {@inheritDoc} */
	public ISpeler maakSpeler(ISpelObserver view, String naam, LocalDate geboorteDatum, boolean isSpastisch, String kleur)
			throws RemoteException {

		Speler speler = new Speler(this, view, naam, geboorteDatum, isSpastisch, kleur);

		synchronized (spelers) {
			spelers.add(speler);
		}
		notifyObservers();

		puntenGeschiedenis.put(speler.getKleur(), new ArrayList<Integer>());
		return speler;
	}

	@Override
	/** {@inheritDoc} */
	public int getAangegevenSpelers() {
		return aangegevenSpelers;
	}

	@Override
	/** {@inheritDoc} */
	public boolean getStart() {
		return this.klaarVoorStart;
	}

	@Override
	/** {@inheritDoc} */
	public List<ISpeler> getSpelerLijst() {
		return this.spelers;
	}

	@Override
	/** {@inheritDoc} */
	public void checkSpelers() throws RemoteException {
		int ready = 0;

		if (this.spelers.size() > 1) {
			for (int i = 0; i < this.spelers.size(); i++) { // zolang i kleiner
				// is dan het aantal
				// spelers.
				if (this.spelers.get(i).isKlaar()) {
					ready++;
				}
			}

			if (ready == this.spelers.size()) {
				for (int i = 0; i < spelers.size(); i++) {
					spelers.get(i).getTableau().ontvangMiddelen(Middel.VOEDSEL, 12); // 12
					// voedsel
					// krijgen
					for (int j = 0; j <= 4; j++) {
						spelers.get(i).getTableau().krijgStamlid(); // 5
						// stamleden
						// krijgen
					}
				}

				LocalDate jongsteSpeler = LocalDate.MIN;
				for (int i = 0; i < spelers.size(); i++) {
					if (spelers.get(i).getGeboorteDatum().isAfter(jongsteSpeler)) {
						jongsteSpeler = spelers.get(i).getGeboorteDatum();
						beurtSpeler = spelers.get(i);
						System.out.println("beurtspeler = " + beurtSpeler.getNaam());
					}
				}
				this.klaarVoorStart = true;
				status = SpelStatus.PLAATSEN_STAMLEDEN;
				notifyEverything();
			}
			notifyObservers();
		}
	}

	/** Update het model bij alle observers. */
	private void notifyObservers() throws RemoteException {
		for (ISpelObserver observer : observers) {
			observer.modelChanged(this);
		}
	}

	/** Geef de beurt voor naar de volgende speler. */
	private void volgendeBeurt() {
		beurtSpeler = spelers.get((spelers.indexOf(beurtSpeler) + 1) % spelers.size());
	}

	/** Het uitvoeren van de fase plaatsenstamleden. */
	private void fasePlaatsenStamleden() throws RemoteException {
		int aantalStamleden = 0;
		for (ISpeler speler : spelers) {
			aantalStamleden += speler.getTableau().getStamleden().size();
		}
		if (aantalStamleden == 0) {
			status = SpelStatus.UITVOEREN_ACTIE;
			volgendeBeurt();
			return;
		}

		volgendeBeurt();
		while (beurtSpeler.getTableau().getStamleden().size() == 0) {
			volgendeBeurt();
		}
	}

	/** Het uitvoeren van een actie op een locatie. */
	private void faseUitvoerenActie() throws RemoteException {
		int aantalStamleden = 0;

		for (ILocatie locatie : speelbord.getLocaties()) {
			aantalStamleden += locatie.getStamleden().size();
		}
		if (aantalStamleden == 0) {
			status = SpelStatus.VOEDEN_STAMLEDEN;
			volgendeBeurt();
			faseVoedenStamleden();
			return;
		} else {

		}

		while (!speelbord.heeftStamleden(beurtSpeler)) {
			volgendeBeurt();
		}
	}

	/** Het uitvoeren van de fase voeden stameden. */
	private void faseVoedenStamleden() throws RemoteException {

		for(ISpeler speler : spelers) {
			speler.setLaatsteLocatie(null);
		}

		setVoeden(true);
		vulPuntenGeschiedenis();

		for(ISpeler speler : spelers) {
			System.out.println(speler.getTableau().getKaarten().size());
		}

		if (this.getSpeelbord().getKaarten().size() >= 4) {
			this.getSpeelbord().resetBeschavingskaarten();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getSpeelbord().doorschuiven();
			System.out.println(this.getSpeelbord().getKaarten().size());
			status = status.PLAATSEN_STAMLEDEN;

		} else {
			status = status.BEPALEN_WINNAAR;
		}

		// reset de status van het gereedschap
		for (ISpeler speler : spelers) {
			speler.getTableau().resetGereedschapStatus();
		}
		notifyObservers();
		volgendeBeurt();
		System.out.println(status);
		fases();
	}

	public void notifyEverything() throws RemoteException {
		// notify alle locaties
		for (ILocatie locatie : speelbord.getLocaties()) {
			locatie.notifyObservers();
		}
		// notify alle tableaus
		for (ISpeler speler : spelers) {
			speler.getTableau().notifyObservers();
		}
		// notify alle sporen
		for (ISpoor spoor : speelbord.getSporen()) {
			spoor.notifyObservers();
		}
	}

	/** Verander de statussen van heeftbeurt of geenbeurt. */
	private void updateStatussen() throws RemoteException {
		// update de status van de spelers
		for (ISpeler speler : spelers) {
			if (beurtSpeler.equals(speler)) {
				speler.setStatus(SpelerStatus.HEEFT_BEURT);
			} else {
				speler.setStatus(SpelerStatus.GEEN_BEURT);
			}
		}
	}

	@Override
	/** {@inheritDoc} */
	public void fases() throws RemoteException {
		switch (status) {
		case PLAATSEN_STAMLEDEN:
			fasePlaatsenStamleden();
			break;
		case UITVOEREN_ACTIE:
			faseUitvoerenActie();
			break;
		case VOEDEN_STAMLEDEN:
			faseVoedenStamleden();
			break;
		}

		updateStatussen();
		notifyEverything();

	}

	/**
	 * Update of dat de er nog gevoed moet worden of niet.
	 * @param b  Of dat de stamleden gevoed moeten worden.
	 */
	public void setVoeden(boolean b) {
		voeden = b;
	}

	@Override
	/** {@inheritDoc} */
	public boolean getVoeden() {
		return voeden;
	}

	@Override
	/** {@inheritDoc} */
	public void registerObserver(ISpelObserver observer) throws RemoteException {
		observers.add(observer);
		notifyObservers();
	}

	@Override
	/** {@inheritDoc} */
	public ISpeler getBeurtSpeler() {
		return beurtSpeler;
	}

	@Override
	/** {@inheritDoc} */
	public SpelStatus getStatus() throws RemoteException {
		return status;
	}
}

