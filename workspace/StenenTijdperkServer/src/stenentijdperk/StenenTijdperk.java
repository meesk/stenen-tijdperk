package stenentijdperk;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import domainlayer.DobbelsteenWorp;

/**
 * StenenTijdperk.java
 * Een simpele Main-klasse waar de RMI server word opgezet.
 * 
 * @author	Erwin Olie, s1103026
 * @version	0.3
 */
public class StenenTijdperk {

	/** De main method die de controllers registreert in het register. */
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099);
		Naming.rebind("DobbelsteenWorp", new DobbelsteenWorp());
	}

}
