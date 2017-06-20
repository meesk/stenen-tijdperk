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
import java.util.List;

import domainlayer.beschavingskaart.Beschavingskaart;
import domainlayer.dobbelstenen.DobbelsteenWorp;
import domainlayer.enums.Middel;
import domainlayer.enums.SpelStatus;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.huttegels.IHuttegel;
import domainlayer.skeleton.locaties.ILocatie;
import presentationlayer.skeleton.ISpelObserver;
import presentationlayer.skeleton.IView;

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

	private List<ISpelObserver> lobbyObservers;
	private List<ISpelObserver> spelViewObservers;

	public Spel() throws RemoteException {
		spelers = new ArrayList<ISpeler>();
		speelbord = new Speelbord(this);
		dobbelsteenWorp = new DobbelsteenWorp();

		lobbyObservers = new ArrayList<ISpelObserver>();
		spelViewObservers = new ArrayList<ISpelObserver>();
	}

	public void eindeSpel() { // Wordt gedaan als het spel is afgelopen.

		try {

			for(int i = 0; i < spelers.size(); i++) {
				//spelers.get(i).ophalenGegevens();
			}

			bepaalWinnaar();

			int i = 0;
			if(i > 1) {

				for(int k = 0; k < spelers.size(); k++) {
					//spelers.get(i).extraTelling();
				}

				bepaalWinnaar();
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void bepaalWinnaar() {
		// vergelijk telling, en pak het hoogste cijfer
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
	public ISpeler maakSpeler(ISpelObserver view, String naam, LocalDate geboorteDatum, boolean b, String kleur) throws RemoteException {

		Speler speler = new Speler(this, view, naam, geboorteDatum, b, kleur);

		synchronized(spelers) {
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

		if(this.spelers.size() > 1 ) {
			for(int i = 0; i < this.spelers.size(); i++) { // zolang i kleiner is dan het aantal spelers.
				if(this.spelers.get(i).getKlaar()) {
					ready++;
				}
			}
			// Deel van Sequentie Diagram 7: Klaarzetten Spel
			if(ready == this.spelers.size()) {
				for(int i = 0; i < spelers.size(); i++) {
					spelers.get(i).getTableau().ontvangMiddelen(Middel.VOEDSEL, 12); // 12 voedsel krijgen
					for (int j = 0; j <= 4; j++) {
						spelers.get(i).getTableau().krijgStamlid(); // 5 stamleden krijgen
					}
				}

				LocalDate jongsteSpeler = LocalDate.MAX;
				for(int i = 0; i <= spelers.size(); i++) {
					if (spelers.get(i).getGeboorteDatum().isBefore(jongsteSpeler)) {
						beurtSpeler = spelers.get(i);
					}
				}
				this.klaarVoorStart = true;
			}
			notifyObservers();
		}
	}



	private void notifyObservers() throws RemoteException {
		for(ISpelObserver observer : lobbyObservers) {
			observer.modelChanged(this);
		}

		for(ISpelObserver observer : spelViewObservers) {
			observer.modelChanged(this);
		}
	}

	/** Het beheren van de spel fases
	 *fase 1 is het lobby gedeelte
	 *fase 2 is het spelen van het spel
	 *fase 3 is het eind view
	 * */

	private ISpeler beurtSpeler;

	public void fases() throws RemoteException {

		beurtSpeler = spelers.get((spelers.indexOf(beurtSpeler) + 1) % spelers.size());

		if(status.equals(status.PLAATSEN_STAMLEDEN)) {
			int stamledenOpTableau = 0;
			for( int i = 0; i <= spelers.size(); i++) {
				stamledenOpTableau += this.spelers.get(i).getTableau().getStamleden().size();
			}
			if( stamledenOpTableau > 0) {
/*uitwerken*/				if ( LocatiePressedBy().equals(beurtSpeler)) {
					if (spelers.get(spelers.indexOf(beurtSpeler)).getTableau().getStamleden().size() > 0) {
			//			voer plaatsen stamleden uit
				}
				} else {
					System.out.println("Niet aan de beurt. Wachten op beurt!");
				}
				beurtSpeler = spelers.get((spelers.indexOf(beurtSpeler) + 1) % spelers.size());

			} else {
				status = status.UITVOEREN_ACTIE;
			}
		} else if (status.equals(status.UITVOEREN_ACTIE)) {
			int stamledenOpSpeelbord = 0;
			for(int j = 0; j <= spelers.size(); j++) {
				stamledenOpSpeelbord += this.speelbord.getLocaties().get(j).getStamleden().size();
			}
			if(stamledenOpSpeelbord > 0) {
/*uitwerken*/				if(LocatiePressedBy().equals(beurtSpeler)) {
					int stamledenOpLocatieSpeler = 0;
					for(int k = 0; k <= speelbord.getLocaties().size(); k++) {
						stamledenOpLocatieSpeler += speelbord.getLaatstGekozenLocatie().getStamleden(beurtSpeler).size();
					}
					if(stamledenOpLocatieSpeler > 0) {
						//uitvoeren actie
					}
				}
			}

		} else if(status.equals(status.VOEDEN_STAMLEDEN)) {
			//voedenStamleden

			// resetten gereedschap
			for(int i = 0; i <= spelers.size(); i++){
				spelers.get(i).getTableau().resetGereedschapStatus();
			}

			// ophalen beschavingskaarten en huttegels
			int aantalKaarten = 0;
			int aantalHutten = 0;
			for(int i = 0; i <= speelbord.getLocaties().size(); i++) {
				if (speelbord.getLocaties().get(i)  instanceof Beschavingskaart) {
					aantalKaarten =+ 1;
				}
				if (speelbord.getLocaties().get(i) instanceof IHuttegel) {
					aantalHutten += 1;
				}
			}

			//kaarten doorschuiven als niet vier instanties van beschavingskaart liggen
			if(aantalKaarten < 4){



				aantalKaarten = 0;
				for (int i = 0; 1<= speelbord.getLocaties().size(); i++) {
					if(speelbord.getLocaties().get(i) instanceof Beschavingskaart){
						aantalKaarten += 1;
					}
				}
				if(aantalKaarten < 4) {
					status = status.BEPALEN_WINNAAR;
				}
			}


			// als niet alle huttegel plekken vol liggen kijken of spel gestopt moet worden deze ronde of volgende ronde
			if(aantalHutten < 4 ) {
				if(laatsteRonde == true){
					status = status.BEPALEN_WINNAAR;
				} else {
					laatsteRonde = true;
				}
			}





		}

	}

	private ISpeler LocatiePressedBy() {

		return null;
	}


	public void registerLobbyView(IView observer) throws RemoteException {

	}

	public void registerLobbyView(ISpelObserver observer) throws RemoteException {
		lobbyObservers.add(observer);
	}

	public void registerSpelView(ISpelObserver observer) throws RemoteException {
		spelViewObservers.add(observer);
	}
}
