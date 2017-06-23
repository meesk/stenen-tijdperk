package domainlayer.skeleton;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import domainlayer.enums.SpelStatus;
import presentationlayer.skeleton.ISpelObserver;

/**
 * Een interface voor het spel aan de server kant.
 *
 * @author Enzo Campfens s1102421
 * @author Mees Kluivers s1102358
 * @author Tristan Caspers s1102755
 * @version 3.0
 */
public interface ISpel extends Remote {

	/**
	 * Maak een nieuwe speler aan om deel te nemen aan het spel.
	 * @param view  De observer van de speler.
	 * @param string  De naam van de speler.
	 * @param localDate  De geboortedatum van de speler.
	 * @param isSpastisch  Of de speler spastisch is.
	 * @param kleur  De gekozen kleur.
	 * @return De aangemaakte speler.
	 */
	public ISpeler maakSpeler(ISpelObserver view, String string, LocalDate localDate, boolean isSpastisch, String kleur) throws RemoteException;

	/** @return Een lijst van alle deelnemende spelers. */
	public List<ISpeler> getSpelerLijst() throws RemoteException;

	/** @return Het aantal spelers dat klaar is om te beginnen. */
	public int getAangegevenSpelers() throws RemoteException;

	/** Het opslaan van het huidige spel en zijn objecten. */
	public void opslaan() throws IOException;

	/** Het controleren of het spel moet worden begonnen. */
	public void checkSpelers() throws RemoteException;

	/** @return Het speelbord waarop gespeeld word. */
	public ISpeelbord getSpeelbord() throws RemoteException;

	/** @return Of dat het spel begonnen is. */
	public boolean getStart() throws RemoteException;

	/**
	 * Het registreren van een observer bij het model.
	 * @param observer  De observer
	 */
	public void registerObserver(ISpelObserver observer) throws RemoteException;

	/** @return De dobbelsteenworp. */
	public IDobbelsteenWorp getDobbelsteenWorp() throws RemoteException;

	/** @return De speler die aan de beurt is. */
	public ISpeler getBeurtSpeler() throws RemoteException;

	/** Het updaten van de fase van het spel. */
	public void fases() throws RemoteException;

	/** @return Of dat de spelers hun stamleden moeten gaan voeden. */
	public boolean getVoeden() throws RemoteException;

	/** @return De status van het huidige spel. */
	public SpelStatus getStatus() throws RemoteException;

	/** Breng het spel tot een einde. */
	public void eindeSpel() throws RemoteException;

	/** Update elke observer van elk onderdeel van het spel. */
	public void notifyEverything() throws RemoteException;

	/** @return De behaalde punten geschiedenis, hoeveelheid per ronde per speler. */
	public Map<String, List<Integer>> getPuntenGeschiedenis() throws RemoteException;
}
