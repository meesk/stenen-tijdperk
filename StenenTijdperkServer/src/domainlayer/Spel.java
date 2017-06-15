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
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;

/**
 * Spel.java
 * De klasse waar alle elementen tot 1 spel worden gevoegd.
 *
 * @author Erwin Olie, s1103026
 * Enzo Campfens, s1102421
 * Mees Kluivers, s1102358
 * Tristan Caspers, s1102755
 * @version 0.6
 */
public class Spel extends UnicastRemoteObject implements ISpel {

	private Speelbord speelbord;
	private DobbelsteenWorp dobbelsteenWorp;
	private List<ISpeler> spelers;
	private int aangegevenSpelers;

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
	public ISpeler maakSpeler(String naam, LocalDate geboorteDatum, boolean isSpastisch) throws RemoteException {

		if(this.spelers.size() < 4) {
			Speler speler = new Speler(this, naam, geboorteDatum, isSpastisch);
		}
		return speler;
	}

	@Override
	public int getAangegevenSpelers() {
		return aangegevenSpelers;
	}

	public void initAantalSpelSpelers() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Server");
		dialog.setHeaderText("Aantal speel personen, 2 tot 4");
		dialog.setContentText("Aantal personen :");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			aangegevenSpelers = Integer.parseInt(result.get());
			synchronized(spelers) {
				spelers.add(speler);
			}
		}
	}

	public boolean checkSpelers() {
		return true;
	}

	@Override
	public List<ISpeler> getSpelerLijst() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
