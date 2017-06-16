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
import domainlayer.dobbelstenen.DobbelsteenWorp;
import domainlayer.enums.Middel;
import domainlayer.enums.SpelStatus;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import presentationlayer.LobbyView;

/**
 * Spel.java
 * De klasse waar alle elementen tot 1 spel worden gevoegd.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @author Tristan Caspers, s1102755
 * @author Alex de Bruin, s1103096
 * @version 0.75
 */
public class Spel extends UnicastRemoteObject implements ISpel {

	private Speelbord speelbord;
	private DobbelsteenWorp dobbelsteenWorp;
	private List<ISpeler> spelers;
	private int aangegevenSpelers;
	private int fase;
	private SpelStatus status;
	private ISpeler speler;
	private int stamledenListTotaal;

	public Spel() throws RemoteException {
		spelers = new ArrayList<ISpeler>();
		speelbord = new Speelbord(this);
		dobbelsteenWorp = new DobbelsteenWorp();
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
	public ISpeler maakSpeler(LobbyView view) throws RemoteException {

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

			if(ready == this.spelers.size()) {
				for(int i = 0; i < spelers.size(); i++) {
					spelers.get(i).getTableau().ontvangMiddelen(Middel.VOEDSEL, 12);
					for (int j = 0; j <= 4; j++) {
						spelers.get(i).getTableau().krijgStamlid();
					}
				}
			}
		}
	}

	public int getFase(){
		return fase;
	}

	public void setFase(int fase){
		this.fase = fase;
	}

	// Het beheren van de spel fases
	//fase 1 is het lobby gedeelte
	//fase 2 is het spelen van het spel
	//fase 3 is het eind view

	public void fases() throws RemoteException {

		while( status != SpelStatus.KLAARZETTEN && status != SpelStatus.BEPALEN_WINNAAR){
			switch(status){
				case PLAATSEN_STAMLEDEN : {
					for(int i = 0; i <= spelers.size(); i++){
						if (this.spelers.get(i).getTableau().getStamleden().size() != 0){
							//plaatsen stamleden



					} else {
						for(int j = 0; j <= spelers.size(); j ++) {
							stamledenListTotaal += this.spelers.get(j).getTableau().getStamleden().size();
						}

						if (stamledenListTotaal == 0){
							break;
						}
					}
				}

			}

			case UITVOEREN_ACTIE : {

			}

			case VOEDEN_STAMLEDEN : {

			}
			}
		}
	}
}
