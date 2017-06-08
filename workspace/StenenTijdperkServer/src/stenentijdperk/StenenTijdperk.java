package stenentijdperk;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import domainlayer.Spel;
import domainlayer.Speler;

/**
 * StenenTijdperk.java
 * Een simpele Main-klasse waar de RMI server word opgezet.
 * 
 * @author Erwin Olie, s1103026
 * Enzo Campfens s1102421
 * Mees Kluivers s1102358
 * @version 0.4
 */
public class StenenTijdperk  {

	/** De main method die de controllers registreert in het register. */
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// Het initialiseren van een nieuw spel.
		Spel spel = new Spel();
		// Het opzetten van het RMI register
		LocateRegistry.createRegistry(1099);
		// Het registreren van het dobbelsteenworp-model in het register.
		Naming.rebind("DobbelsteenWorp", spel.getDobbelsteenWorp());
		// Het registreren van het spel.
		Naming.rebind("Spel", spel);
	}
	
}
