package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import domainlayer.Stamlid;
import domainlayer.beschavingskaart.Beschavingskaart;
import domainlayer.enums.Middel;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.huttegels.IHuttegel;
import presentationlayer.skeleton.ITableauObserver;

/**
 * @author Erwin Olie, s1103026
 * @version 1.0
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

	public void ontvangenBeschavingskaarten(IBeschavingskaart kaart) throws RemoteException;

	public void notifyObservers() throws RemoteException;

	public int getTotaalGereedschap() throws RemoteException;

	public void geefGereedschapFiche() throws RemoteException;

	public void gebruikStamlid(Stamlid stamlid)  throws RemoteException;

	public ISpeler getSpeler() throws RemoteException;

	public void resetGereedschapStatus() throws RemoteException;

	public boolean voedenStamleden(Map<Middel, Integer> middelen) throws RemoteException;

	public List<IHuttegel> getHuttegels() throws RemoteException;

	public boolean verliesPunten() throws RemoteException;

	public Map<Middel, Integer> getMiddelen() throws RemoteException;

	public IStamlid popStamlid() throws RemoteException;

	public boolean getBetaalt() throws RemoteException;

	public void setBetaalt(boolean betaalt) throws RemoteException;

	public void geefHuttegel(IHuttegel huttegel) throws RemoteException;

	public void geefBeschavingskaart(IBeschavingskaart beschavingskaart) throws RemoteException;

	public List<IBeschavingskaart> getKaarten() throws RemoteException;

	void geefBeschavingskaarten(IBeschavingskaart kaart) throws RemoteException;

	public void gebruikGereedschap(int i) throws RemoteException;

	public void verwijderMiddelen(Map<Middel, Integer> cost) throws RemoteException;

}

