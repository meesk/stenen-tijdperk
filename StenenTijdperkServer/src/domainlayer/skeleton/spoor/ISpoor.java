package domainlayer.skeleton.spoor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import domainlayer.skeleton.ISpeler;

/**
 * @author Erwin Olie s1103026
 * @version 0.2
 */
public interface ISpoor extends Remote {
	public Map<ISpeler, Integer> getMarkeerstenen() throws RemoteException;
}
