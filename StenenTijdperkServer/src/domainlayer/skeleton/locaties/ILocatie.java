package domainlayer.skeleton.locaties;

import java.awt.Point;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.Speelbord;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import presentationlayer.skeleton.ILocatieObserver;

/**
 * Deze interface kan door de RMI worden gebruikt om locatie-gegevens
 * op te halen.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface ILocatie extends Remote {

	/** @return De X-positie van de locatie. */
	public int getX() throws RemoteException;

	/** @return De Y-positie van de locatie. */
	public int getY() throws RemoteException;

	/** @return De breedte van de locatie. */
	public int getWidth() throws RemoteException;

	/** @return De hoogte van de locatie. */
	public int getHeight() throws RemoteException;

	/** @return Alle punten waar de cirkels zich bevinden. */
	public List<Point> getCirkels() throws RemoteException;

	/** @return Een lijst van alle stamleden op de locatie. */
	public List<IStamlid> getStamleden() throws RemoteException;

	/**
	 * @param speler  De speler die zijn stamleden opvraagt.
	 * @return Een lijst van alle stamleden van de speler op de locatie.
	 */
	public List<IStamlid> getStamleden(ISpeler speler) throws RemoteException;

	/**
	 * Het registreren van de observer.
	 * @param observer  De observer die geregistreerd moet worden.
	 */
	public void registerObserver(ILocatieObserver observer) throws RemoteException;
	
	/**
	 * Het uitvoeren van een speciale actie die hoort bij de locatie.
	 * @param speler  De speler wiens actie word uitgevoerd.
	 */
	public void uitvoerenActie(ISpeler speler) throws RemoteException;

	/**
	 * Het plaatsen van stamleden op deze locatie.
	 * @param speler  De speler wiens stamleden worden geplaatst.
	 * @param aantal  Het aantal stamleden dat word geplaatst.
	 */
	public void plaatsStamleden(ISpeler speler, int aantal) throws RemoteException;

	/**
	 * Het verwijderen van een stamlid van de locatie.
	 * @param stamlid  Het stamlid dat moet worden verwijderd.
	 */
	public void verwijderStamlid(IStamlid stamlid) throws RemoteException;

	/** Het melden aan de observers dat het model veranderd is. */
	public void notifyObservers() throws RemoteException;

	/** @return Een boolean die aangeeft of er met dobbelstenen
	 * moet worden geworpen. */
	public boolean isWorpNodig() throws RemoteException;

	/**
	 * Reset de beschavingskaarten op het speelbord.
	 * @param speelbord  Het relevante speelbord.
	 */
	public void resetBeschavingskaarten(Speelbord speelbord) throws RemoteException;
}
