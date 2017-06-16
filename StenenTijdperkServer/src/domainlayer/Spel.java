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
import java.util.Optional;
import domainlayer.dobbelstenen.DobbelsteenWorp;
import domainlayer.enums.Kleur;
import domainlayer.enums.SpelStatus;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;

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
	public ISpeler maakSpeler(String naam, LocalDate geboorteDatum, boolean isSpastisch, String kleur) throws RemoteException {

		Speler speler = new Speler(this, naam, geboorteDatum, isSpastisch, kleur);

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

		// het aantal spelers, het aantal spelers dat klaar is.

		for(int i = 0; i < this.spelers.size(); i++) { // zolang i kleiner is dan het aantal spelers.
			if(this.spelers.get(i).getKlaar()) {
				ready++;
			}
		}

		if(ready == this.spelers.size()) {
			// Toevoegen 12 voedsel
			// Toevoegen 5 stamleden
		}
	}

	public int getFase(){
		return fase;
	}

	public void setFase(int fase){
		this.fase = fase;
	}

	public void fases() {

		while( status != SpelStatus.KLAARZETTEN && status != SpelStatus.BEPALEN_WINNAAR){
			switch(status){
				case PLAATSEN_STAMLEDEN : {

		//			while(s.

				}

				case UITVOEREN_ACTIE : {

				}

				case VOEDEN_STAMLEDEN : {

				}
			}
		}
	}
}
