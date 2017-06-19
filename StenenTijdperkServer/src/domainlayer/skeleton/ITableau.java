package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.Stamlid;
import domainlayer.enums.Middel;
import presentationlayer.skeleton.ITableauObserver;

/**
 * @author Erwin Olie, s1103026
 * @version 0.3
 */

public interface ITableau extends Remote {
	public void registerObserver(ITableauObserver observer) throws RemoteException;

	public int[] getGereedschap() throws RemoteException;
	public boolean[] getGereedschapGebruikt() throws RemoteException;

	public List<IStamlid> getStamleden() throws RemoteException;

	public void ontvangMiddelen(Middel voedsel, int i) throws RemoteException;

	public void krijgStamlid() throws RemoteException;

	public void ontvangStamleden(List<IStamlid> stamleden) throws RemoteException;

	public void verhoogGereedschap() throws RemoteException;

	public void ontvangMiddel(Middel middel) throws RemoteException;

	public void notifyObservers() throws RemoteException;

	public int getTotaalGereedschap() throws RemoteException;

	public void geefGereedschapFiche() throws RemoteException;

	public void gebruikStamlid(Stamlid stamlid)  throws RemoteException;

	public ISpeler getSpeler() throws RemoteException;
}

