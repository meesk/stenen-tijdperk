package domainlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domainlayer.beschavingskaart.Beschavingskaart;
import domainlayer.dobbelstenen.DobbelsteenWorp;
import domainlayer.enums.Middel;
import domainlayer.enums.SpelStatus;
import domainlayer.enums.SpelerStatus;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.ITableau;
import domainlayer.skeleton.huttegels.IHuttegel;
import domainlayer.skeleton.locaties.ILocatie;
import presentationlayer.skeleton.ISpelObserver;

/**
 * Spel.java<br>
 * De klasse waar alle elementen tot 1 spel worden gevoegd.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @author Alex de Bruin, s1103096
 * @version 1.0
 */
public class Spel extends UnicastRemoteObject implements ISpel {

	private ISpeler beurtSpeler;
	private Speelbord speelbord;

	public Speelbord getSpeelbord() {
		return speelbord;
	}

	private DobbelsteenWorp dobbelsteenWorp;
	private List<ISpeler> spelers;
	private int aangegevenSpelers;
	private SpelStatus status;
	private boolean laatsteRonde = false;
	private boolean klaarVoorStart = false;
	private boolean voeden;

	private List<ISpelObserver> observers;

	public Spel() throws RemoteException {
		spelers = new ArrayList<ISpeler>();
		speelbord = new Speelbord(this);
		dobbelsteenWorp = new DobbelsteenWorp();

		observers = new ArrayList<>();
	}

	public void eindeSpel() { // Wordt gedaan als het spel is afgelopen.

		Map<String, Integer> spelerPuntenTotaal = new HashMap(); // hier worden
																	// de
																	// waardes
																	// in
																	// opgeslagen.

		try {
			for (int i = 0; i < spelers.size(); i++) {
				// per speler het totaal aantal punten eerste telling, weg
				// gestopt onder naam.
				spelerPuntenTotaal.put(spelers.get(i).getNaam(), spelers.get(i).ophalenGegevens());
			}

			// Als bepaalWinnaar false is dan wordt hieronder de 2de telling
			// gedaan.
			if (!bepaalWinnaar(spelerPuntenTotaal)) {
				for (int k = 0; k < spelers.size(); k++) {
					spelerPuntenTotaal.put(spelers.get(k).getNaam(),
							spelerPuntenTotaal.get(spelers.get(k).getNaam() + spelers.get(k).extraGegevens()));
				}
			}

			// open eindview met spelerPuntenTotaal.

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean bepaalWinnaar(Map<String, Integer> spelerPuntenTotaal) throws RemoteException {

		boolean winnaarBepaald = false;

		int highest = Integer.MIN_VALUE; // int mag geen null zijn en aangezien
											// je min kan hebben in het spel,
											// vandaar.
		int secondHighest = Integer.MIN_VALUE;

		for (int i = 0; i < spelers.size(); i++) {
			if (spelerPuntenTotaal.get(spelers.get(i).getNaam()) > highest || highest == -9999) {
				secondHighest = highest;
				highest = spelerPuntenTotaal.get(spelers.get(i).getNaam());
			}
		}

		if (highest > secondHighest) {
			winnaarBepaald = true;
		}

		return winnaarBepaald;
	}

	public DobbelsteenWorp getDobbelsteenWorp() {
		return dobbelsteenWorp;
	}

	public void opslaan() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("spel.ser")));
		oos.writeObject(this);
		oos.close();
	}

	public void laden() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("spel.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Spel spel = (Spel) ois.readObject();
		ois.close();
	}

	@Override
	public ISpeler maakSpeler(ISpelObserver view, String naam, LocalDate geboorteDatum, boolean b, String kleur)
			throws RemoteException {

		Speler speler = new Speler(this, view, naam, geboorteDatum, b, kleur);

		synchronized (spelers) {
			spelers.add(speler);
		}
		notifyObservers();
		return speler;
	}

	@Override
	public int getAangegevenSpelers() {
		return aangegevenSpelers;
	}

	public boolean getStart() {
		return this.klaarVoorStart;
	}

	public List<ISpeler> getSpelerLijst() {
		return this.spelers;
	}

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
			// Deel van Sequentie Diagram 7: Klaarzetten Spel
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

				LocalDate jongsteSpeler = LocalDate.MAX;
				for (int i = 0; i < spelers.size(); i++) {
					if (spelers.get(i).getGeboorteDatum().isBefore(jongsteSpeler)) {
						jongsteSpeler = spelers.get(i).getGeboorteDatum();
						beurtSpeler = spelers.get(i);
						System.out.println("beurtspeler = " + beurtSpeler.getNaam());
					}
				}
				this.klaarVoorStart = true;
				status = SpelStatus.PLAATSEN_STAMLEDEN;
			}
			notifyObservers();
		}
	}

	private void notifyObservers() throws RemoteException {
		for (ISpelObserver observer : observers) {
			observer.modelChanged(this);
		}
	}
	private void volgendeBeurt() {
		beurtSpeler = spelers.get((spelers.indexOf(beurtSpeler) + 1) % spelers.size());
	}

	private void fasePlaatsenStamleden() throws RemoteException {
		int aantalStamleden = 0;
		for (ISpeler speler : spelers) {
			aantalStamleden += speler.getTableau().getStamleden().size();
		}
		if (aantalStamleden == 0) {
			status = SpelStatus.UITVOEREN_ACTIE;
			return;
		}
		
		volgendeBeurt();
		while (beurtSpeler.getTableau().getStamleden().size() == 0) {
			volgendeBeurt();
		}

	}

	private void faseUitvoerenActie() throws RemoteException {
		int aantalStamleden = 0;
		for (ILocatie locatie : speelbord.getLocaties()) {
			aantalStamleden += locatie.getStamleden().size();
		}
		System.out.println(aantalStamleden);
		if (aantalStamleden == 0) {
			status = SpelStatus.VOEDEN_STAMLEDEN;
			return;
		}
		
		while (!speelbord.heeftStamleden(beurtSpeler)) {
			volgendeBeurt();
		}
	}
	
	private boolean checkBetaalt() throws RemoteException{
		int i = 0;
		for (ISpeler s  : spelers){
			if(s.getTableau().getBetaalt() == true){
			i++;
			}
		}
		if(i == spelers.size()){
			return true;
		}
		return false;
	}

	private void faseVoedenStamleden() throws RemoteException {
		setVoeden(true);
		notifyObservers();
		status = SpelStatus.PLAATSEN_STAMLEDEN;
		volgendeBeurt();
		fases();
	}

	private void notifyEverything() throws RemoteException {
		// notify alle locaties
		for (ILocatie locatie : speelbord.getLocaties()) {
			locatie.notifyObservers();
		}
		// notify alle tableaus
		for (ISpeler speler : spelers) {
			speler.getTableau().notifyObservers();
		}
	}

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

	// public void fases() throws RemoteException {
	//
	// geefVolgendeBeurt();
	// for (ISpeler speler : spelers) {
	// speler.getTableau().notifyObservers();
	// }
	//
	// if (status.equals(SpelStatus.PLAATSEN_STAMLEDEN)) {
	// int stamledenOpTableau = 0;
	// for(ISpeler speler : spelers) {
	// stamledenOpTableau += speler.getTableau().getStamleden().size();
	// }
	// if( stamledenOpTableau > 0) {
	//
	// while (beurtSpeler.getTableau().getStamleden().size() == 0) {
	// geefVolgendeBeurt();
	// }
	//
	//
	// /*if
	// (spelers.get(spelers.indexOf(beurtSpeler)).getTableau().getStamleden().size()
	// > 0) {
	// // voer plaatsen stamleden uit
	//
	// } else {
	//
	// beurtSpeler = spelers.get((spelers.indexOf(beurtSpeler) + 1) %
	// spelers.size());
	// for(int j = 0; j <= spelers.size(); j++){
	// if(spelers.get(j) != spelers.get(spelers.indexOf(beurtSpeler))) {
	// spelers.get(j).setStatus(SpelerStatus.GEEN_BEURT);
	// }
	// }
	// }*/
	//
	// } else {
	// status = status.UITVOEREN_ACTIE;
	// }
	// } else if (status.equals(status.UITVOEREN_ACTIE)) {
	// int stamledenOpSpeelbord = 0;
	// for(int j = 0; j < spelers.size(); j++) {
	// stamledenOpSpeelbord +=
	// this.speelbord.getLocaties().get(j).getStamleden().size();
	// }
	// if(stamledenOpSpeelbord > 0) {
	//
	//
	// //checken of de speler die stamleden wil plaatsen aan de beurt is
	// /*int stamledenOpLocatieSpeler = 0;
	// for(int k = 0; k < speelbord.getLocaties().size(); k++) {
	// stamledenOpLocatieSpeler +=
	// speelbord.getLaatstGekozenLocatie().getStamleden(beurtSpeler).size();
	// }
	// if(stamledenOpLocatieSpeler > 0) {
	// //uitvoeren actie
	// }*/
	// } else {
	// /*beurtSpeler = spelers.get((spelers.indexOf(beurtSpeler)) + 1 %
	// spelers.size());
	// for(int j = 0; j < spelers.size(); j++){
	// if(spelers.get(j) != spelers.get(spelers.indexOf(beurtSpeler))) {
	// spelers.get(j).setStatus(SpelerStatus.GEEN_BEURT);
	// }
	// }*/
	// }
	// } else if(status.equals(status.VOEDEN_STAMLEDEN)) {
	// //voedenStamleden
	// setVoeden(true);
	// notifyObservers();
	//
	// // resetten gereedschap
	// for(int i = 0; i < spelers.size(); i++){
	// spelers.get(i).getTableau().resetGereedschapStatus();
	// }
	// // ophalen beschavingskaarten en huttegels
	// int aantalKaarten = 0;
	// int aantalHutten = 0;
	// for(int i = 0; i < speelbord.getLocaties().size(); i++) {
	// if (speelbord.getLocaties().get(i) instanceof Beschavingskaart) {
	// aantalKaarten =+ 1;
	// }
	// if (speelbord.getLocaties().get(i) instanceof IHuttegel) {
	// aantalHutten += 1;
	// }
	// }
	// //kaarten doorschuiven als niet vier instanties van beschavingskaart
	// liggen
	// if(aantalKaarten < 4) {
	// aantalKaarten = 0;
	// for (int i = 0; 1 < speelbord.getLocaties().size(); i++) {
	// if(speelbord.getLocaties().get(i) instanceof Beschavingskaart){
	// aantalKaarten += 1;
	// }
	// }
	// if(aantalKaarten < 4) {
	// status = status.BEPALEN_WINNAAR;
	// }
	// }
	// // als niet alle huttegel plekken vol liggen kijken of spel gestopt moet
	// worden deze ronde of volgende ronde
	// if(aantalHutten < 4 ) {
	// if(laatsteRonde == true){
	// status = status.BEPALEN_WINNAAR;
	// } else {
	// laatsteRonde = true;
	// }
	// }
	// }
	//
	// for (ILocatie locatie : speelbord.getLocaties()) {
	// locatie.notifyObservers();
	// }
	// for (ISpeler speler : spelers) {
	// speler.getTableau().notifyObservers();
	// }
	// }

	public void setVoeden(boolean b) {
		voeden = b;
	}

	public boolean getVoeden() {
		return voeden;
	}

	public void registerObserver(ISpelObserver observer) throws RemoteException {
		observers.add(observer);
		notifyObservers();
	}

	@Override
	public ISpeler getBeurtSpeler() {
		return beurtSpeler;
	}

	@Override
	public SpelStatus getStatus() throws RemoteException {
		return status;
	}
}
