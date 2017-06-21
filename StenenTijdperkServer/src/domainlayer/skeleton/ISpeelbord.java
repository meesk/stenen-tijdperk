package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.skeleton.huttegels.IHuttegel;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;

public interface ISpeelbord extends Remote {
	public List<ILocatie> getLocaties() throws RemoteException;
	public ISpoor getVoedselspoor() throws RemoteException;
	public ISpoor[] getSporen() throws RemoteException;
	public ISpoor getPuntenspoor() throws RemoteException;
	public List<IHuttegel>[] getHuttegels() throws RemoteException;
	public IHuttegel popHuttegel(int index) throws RemoteException;
}
