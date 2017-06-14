package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * ISpeler.java
 * Een interface voor de klasse Speler.java aan de server kant
 * 
 * @author Erwin Olie, s1103026
 * Enzo Campfens s1102421
 * Mees Kluivers s1102358
 * @version 0.1
 */

public interface ISpeler extends Remote {
	
	public void getNaam() throws RemoteException;
	
	public void getGeboorteDatum() throws RemoteException;
	
	public void getSpasme() throws RemoteException;

}
