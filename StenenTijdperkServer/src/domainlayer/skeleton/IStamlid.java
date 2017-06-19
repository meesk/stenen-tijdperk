package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * IStamlid.java
 * De interface voor stamlid op de server
 * @author Mees Kluivers, s1102358
 * @version 0.1
 *
 */

public interface IStamlid extends Remote {

	public ISpeler getSpeler() throws RemoteException;

}
