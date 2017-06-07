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

import domainlayer.dobbelstenen.DobbelsteenWorp;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;

/**
 * @author Erwin Olie, s1103026
 * @version 0.2
 */
public class Spel extends UnicastRemoteObject implements ISpel {

	private Speelbord speelbord;
	private DobbelsteenWorp dobbelsteenWorp;
	private List<ISpeler> spelers;

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
		//
	}
	
	@Override
	public ISpeler maakSpeler(String naam) throws RemoteException {
		Speler speler = new Speler(this, naam);
		
		synchronized(spelers) {
			spelers.add(speler);
		}
		
		return speler;
	}

}
