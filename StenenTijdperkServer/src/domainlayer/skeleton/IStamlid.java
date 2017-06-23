package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * De interface voor stamlid op de server
 * 
 * @author Mees Kluivers, s1102358
 * @version 3.0
 */
public interface IStamlid extends Remote {

	/** @return De eigenaar van het stamlid. */
	public ISpeler getSpeler() throws RemoteException;

}
