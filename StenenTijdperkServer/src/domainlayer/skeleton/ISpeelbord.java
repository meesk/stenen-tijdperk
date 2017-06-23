package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.huttegels.IHuttegel;
import domainlayer.skeleton.locaties.ILocatie;
import domainlayer.skeleton.spoor.ISpoor;

/**
 * 
 * @author Mees Kluivers, s1102358
 * @version 3.0
 *
 */

public interface ISpeelbord extends Remote {
	/**
	 *  Ophalen van locaties
	 * @return  List<ILocatie>  een lijst met locaties
	 * @throws RemoteException
	 */
	public List<ILocatie> getLocaties() throws RemoteException;
	/**
	 * Ophalen van voedselspoor
	 * @return  ISpoor  het voedselspoor
	 * @throws RemoteException
	 */
	public ISpoor getVoedselspoor() throws RemoteException;
	/**
	 * Ophalen van sporen
	 * @return ISpoor[]  een array van sporen
	 * @throws RemoteException
	 */
	public ISpoor[] getSporen() throws RemoteException;
	/**
	 * Ophalen van puntenspoor
	 * @return ISpoor het puntenspoor
	 * @throws RemoteException
	 */
	public ISpoor getPuntenspoor() throws RemoteException;
	/**
	 * Ophalen van een lijst van huttegels.
	 * @return List<IHuttegel>[]  lijst van huttegels
	 * @throws RemoteException
	 */
	public List<IHuttegel>[] getHuttegels() throws RemoteException;
	/**
	 * Ophalen van een lijst van beschavingskaarten
	 * @return IBeschavingskaart[]  lijst van beschavingskaarten
	 * @throws RemoteException
	 */
	public IBeschavingskaart[] getBeschavingskaarten() throws RemoteException;
	/**
	 * Het verwijderen van de huttegel op de index
	 * @param index  index van de huttegel
	 * @return IHuttegel  huttegel
	 * @throws RemoteException
	 */
	public IHuttegel popHuttegel(int index) throws RemoteException;
	/**
	 * Het verwijderen van de beschavingskaart op de index
	 * @param index  index van de beschavingskaart
	 * @return IBeschavingskaart  beschavingskaart
	 * @throws RemoteException
	 */
	public IBeschavingskaart popBeschavingskaart(int index) throws RemoteException;
	/**
	 * Het ophalen van een huttegel uit een lijst.
	 * @param index  index van de huttegel
	 * @return IHuttegel  de huttegel die is opgehaald
	 * @throws RemoteException
	 */
	public IHuttegel getHuttegel(int index) throws RemoteException;

}
