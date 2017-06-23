package domainlayer.skeleton.beschavingskaart;

/**
 * IBeschavingskaart.java
 * De klasse waarmee over rmi gecomuniceert wordt
 * @author Mees Kluivers
 * @version 3.0
 * */
import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.beschavingskaart.IBeschavingskaartAchtergrond;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;

public interface IBeschavingskaart extends Remote {


	public int getKosten() throws RemoteException;

	/**
	 * De actie die afhankelijk is van de soort kaart.
	 * @param speler  Dit is de speler die de actie gaat uitvoeren.
	 */
	public void uitvoerenActie(ISpeler speler) throws RemoteException;


	/**
	 * De methode die de status van de beschavingskaart opvraagd
	 * @return  de status die de beschavingskaart op dit moment heeft
	 *
	 */
	public BeschavingskaartStatus getStatus() throws RemoteException;


	public void setStatus(BeschavingskaartStatus status) throws RemoteException;

	public String getAsset() throws RemoteException;

	public IBeschavingskaartAchtergrond getAchtergrond() throws RemoteException;
}
