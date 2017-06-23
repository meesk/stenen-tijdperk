package domainlayer.skeleton.beschavingskaart;

/**
 * IBeschavingskaart.java
 * De klasse waarmee over rmi gecomuniceert wordt
 * @author Mees Kluivers, s1102358
 * @version 3.0
 * */
import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;

public interface IBeschavingskaart extends Remote {

	/**
	 * 
	 * @return int  kosten ophalen van de beschavingskaart
	 * @throws RemoteException
	 */
	public int getKosten() throws RemoteException;

	/**
	 * De actie die afhankelijk is van de soort kaart.
	 * @param speler  Dit is de speler die de actie gaat uitvoeren.
	 */
	public void uitvoerenActie(ISpeler speler) throws RemoteException;


	public BeschavingskaartStatus getStatus() throws RemoteException;


	public void setStatus(BeschavingskaartStatus status) throws RemoteException;

	public String getAsset() throws RemoteException;

	public IBeschavingskaartAchtergrond getAchtergrond() throws RemoteException;
}
