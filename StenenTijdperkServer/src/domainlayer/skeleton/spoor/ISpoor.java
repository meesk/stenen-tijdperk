package domainlayer.skeleton.spoor;

/**
* @author Alex de Bruin, s1103096
* @author Erwin olie. s1103026
* @Version 0.1
*
* <br>
* <br>
* Dit is de interface waar de sporen van overerven
*/

import java.rmi.Remote;
import java.util.Map;
import java.rmi.RemoteException;
import domainlayer.skeleton.ISpeler;
public interface ISpoor extends Remote {

	public abstract Map<ISpeler, Integer> getMarkeerstenen() throws RemoteException;
	public void verwijderPunten(ISpeler speler, int aantal) throws RemoteException;
	public void verhoogPunten(ISpeler speler, int aantal) throws RemoteException;
	public int getProductie(ISpeler speler) throws RemoteException;
	public int getMarkeerSteen(ISpeler speler) throws RemoteException;
}

