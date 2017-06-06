package domainlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.rmi.RemoteException;

import domainlayer.dobbelstenen.DobbelsteenWorp;

/**
 * @author Erwin Olie, s1103026
 * @version 0.2
 */
public class Spel implements Serializable {

	private Speelbord speelbord;
	private DobbelsteenWorp dobbelsteenWorp;

	public Spel() throws RemoteException {
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

}
