package domainlayer.skeleton.locaties;

import java.awt.Point;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;

/**
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public interface ILocatie extends Remote {
	public int getX() throws RemoteException;
	public int getY() throws RemoteException;
	public int getWidth() throws RemoteException;
	public int getHeight() throws RemoteException;
	public List<Point> getCirkels() throws RemoteException;
	public List<IStamlid> getStamleden() throws RemoteException;
	public List<IStamlid> getStamleden(ISpeler beurtSpeler) throws RemoteException;
}
