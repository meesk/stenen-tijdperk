package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import domainlayer.enums.SpelerStatus;
import domainlayer.skeleton.locaties.ILocatie;

/**
 * Een interface voor de klasse Speler.java aan de server kant
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens s1102421
 * @author Mees Kluivers s1102358
 * @version 3.0
 */
public interface ISpeler extends Remote {

	/** @return  De naam van de speler. */
	public String getNaam() throws RemoteException;

	/** @return  De geboortedatum van de speler. */
	public LocalDate getGeboorteDatum() throws RemoteException;

	/** @return  Of dat de speler spastisch is. */
	public boolean getSpasme() throws RemoteException;

	/** @return  Of de speler klaar is om te beginnen. */
	public boolean isKlaar() throws RemoteException;

	/** @return  Het tableau van de speler. */
	public ITableau getTableau() throws RemoteException;

	/** @return  Het spel waaraan de speler deelneemt. */
	public ISpel getSpel() throws RemoteException;

	/** Het aangeven dat de speler klaar is om te beginnen. */
	public void setSpelerKlaar() throws RemoteException;

	/** @return  De hoeveelheid punten van de speler. */
	public int ophalenGegevens() throws RemoteException;

	/** @return  De hoeveelheid punten bij een extra telling van de speler. */
	public int extraGegevens() throws RemoteException;

	/** @return  De gekozen kleur van de speler. */
	public String getKleur() throws RemoteException;

	/**
	 * Het veranderen van de status van de speler.
	 * @param status  De nieuwe status.
	 */
	public void setStatus(SpelerStatus status) throws RemoteException;

	/** @return  De huidige status van de speler. */
	public SpelerStatus getStatus() throws RemoteException;

	/** @return  De laatst gekozen locatie van de speler. */
	public ILocatie getLaatsteLocatie() throws RemoteException;

	/**
	 * Het veranderen van de laatst gekozen locatie.
	 * @param model  De nieuwe laatst gekozen locatie.
	 */
	public void setLaatsteLocatie(ILocatie model) throws RemoteException;
}

