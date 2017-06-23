package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *  De interface voor RMI over de Dobbelsteen.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface IDobbelsteen extends Remote {
	/** Wis de waarde van de dobbelsteen. */
	public void reset() throws RemoteException;

	/** Werp de dobbelsteen */
	public void werp() throws RemoteException;

	/** @return Het geworpen aantal ogen. */
	public int getOgen() throws RemoteException;
}
