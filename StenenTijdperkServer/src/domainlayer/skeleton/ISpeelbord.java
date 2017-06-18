package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.skeleton.locaties.ILocatie;

public interface ISpeelbord extends Remote {
	public List<ILocatie> getLocaties() throws RemoteException;
}
