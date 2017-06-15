package domainlayer.skeleton.spoor;

<<<<<<< HEAD
/**
* @Author Alex de Bruin, s1103096
* @Version 0.1
*
* <br>
* <br>
* Dit is de interface waar de sporen van overerven
*/

import java.rmi.Remote;
import java.util.Map;

import domainlayer.skeleton.ISpeler;
public interface ISpoor extends Remote{

	public void verwijderPunten(ISpeler speler, int aantal);
	public void verhoogPunten(ISpeler speler, int aantal);
	public Map<ISpeler, Integer> getMarkeerstenen();
}
=======
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import domainlayer.skeleton.ISpeler;
>>>>>>> 0a63da35e292d3a187c815cc361fe9be01eff438

/**
 * @author Erwin Olie s1103026
 * @version 0.2
 */
public interface ISpoor extends Remote {
	public Map<ISpeler, Integer> getMarkeerstenen() throws RemoteException;
}
