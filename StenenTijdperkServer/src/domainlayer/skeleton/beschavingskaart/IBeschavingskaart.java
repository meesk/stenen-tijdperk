package domainlayer.skeleton.beschavingskaart;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;

/**
 * De interface voor alle beschavingskaarten in het spel.
 * @author Mees Kluivers
 * @version 3.0
 */
public interface IBeschavingskaart extends Remote {

	/** @return De prijs die de kaart kost. */
	public int getKosten() throws RemoteException;

	/**
	 * De actie die afhankelijk is van de soort kaart.
	 * @param speler  Dit is de speler die de actie gaat uitvoeren.
	 */
	public void uitvoerenActie(ISpeler speler) throws RemoteException;


	/** @return De status waar de kaart zich in bevind. */
	public BeschavingskaartStatus getStatus() throws RemoteException;

	/**
	 * Verander de status waar de kaart zich in bevind.
	 * @param status  De status waar de kaart zich in moet bevinden.
	 */
	public void setStatus(BeschavingskaartStatus status) throws RemoteException;

	/** @return De url van de asset van de kaart. */
	public String getAsset() throws RemoteException;

	/** @return De achtergrondstype van de kaart. */
	public IBeschavingskaartAchtergrond getAchtergrond() throws RemoteException;
}
