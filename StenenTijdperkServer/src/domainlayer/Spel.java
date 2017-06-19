package domainlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
import presentationlayer.skeleton.IView;

/**
 * Spel.java<br>
 * De klasse waar alle elementen tot één spel worden gevoegd.
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
	private int stamledenNietGeplaatst;
	private int stamleden = 0;
	private boolean laatsteRonde = false;
	private boolean klaarVoorStart = false;

	private List<IView> lobbyObservers;

	public Spel() throws RemoteException {
		spelers = new ArrayList<ISpeler>();
		speelbord = new Speelbord(this);
		dobbelsteenWorp = new DobbelsteenWorp();

		lobbyObservers = new ArrayList<IView>();
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
	public ISpeler maakSpeler(IView view) throws RemoteException {

		Speler speler = new Speler(this, view);

		synchronized(spelers) {
			spelers.add(speler);
		}

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
				this.klaarVoorStart = true;
				notifyObservers();
			}
		}
	}



	private void notifyObservers() throws RemoteException {
		for(IView observer : lobbyObservers) {
			observer.modelChanged(this);
		}
	}

	/** Het beheren van de spel fases
	 *fase 1 is het lobby gedeelte
	 *fase 2 is het spelen van het spel
	 *fase 3 is het eind view
	 * */

	public void fases() throws RemoteException {

		// fase 2.1
		//Alleen de fases waar in de speler echt het spel kan spelen staan hier in
		while( status != SpelStatus.KLAARZETTEN && status != SpelStatus.BEPALEN_WINNAAR) {
			//De switch zorgt ervoor de de juiste acties bij de juiste staat van het spel horen

			switch(status){

			// dit is het plaatsen van de stamleden gedeelte
			case PLAATSEN_STAMLEDEN : {
				// zolang i kleiner is dan de lijst met spelers
				for(int i = 0; i < spelers.size(); i++) {
					//als Tableau van een spler niet leeg is
					if (this.spelers.get(i).getTableau().getStamleden().size() != 0){
						// kijk hoeveel spelers er zijn
						switch(spelers.size()) {
						//als er twee spelers zijn
						case '2' : {
							//stamleden plaatsen
						}
						//als er drie spelers zijn
						case '3' : {
							//stamleden plaatsen
						}
						//als er vier spelers zijn
						case '4' : {
							//stamleden plaatsen
						}
						}
						// als er geen stamleden meer zijn bij een speler
					} else {
						//zolanf j kleiner is dan de lijst met spelers
						for(int j = 0; j < spelers.size(); j ++) {
							//de teller stamleden wordt gevuld met stamleden die er wel nog staan
							stamledenNietGeplaatst += this.spelers.get(j).getTableau().getStamleden().size();
						}
						//als de teller met stamleden leeg is gaat het spel naar de volgende fase
						if (stamledenNietGeplaatst == 0) {
							break;
						}
					}
				}
				//volgende spelfase
				status = status.UITVOEREN_ACTIE;
			}
			//fase 2.2
			case UITVOEREN_ACTIE : {

				// ga langs alle locaties en haal daar op hoeveel stamleden geplaatst zijn
				for(ILocatie locatie : speelbord.getLocaties()) {
					stamleden += locatie.getStamleden();
				}
				//
				while(stamleden != 0){
					for(ILocatie locatie : speelbord.getLocaties()) {
						stamleden += locatie.getStamleden();
					}
					switch(spelers.size()) {

					case '2' : {
						//twee spelers krijgen een beurt
					}

					case '3' : {
						//drie spelers krijgen een beurt
					}

					case '4' : {
						//vier speler krijgen een beurt
					}
					}
				}
				status = status.VOEDEN_STAMLEDEN;
			}
			//fase 2.3
			case VOEDEN_STAMLEDEN : {
				{// voedenstamleden
				}

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

					//schuif kaarten door

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




			}	// hier binnen blijven
			}
		}
	}

	public void registerLobbyView(IView observer) throws RemoteException {
		lobbyObservers.add(observer);
	}
}
