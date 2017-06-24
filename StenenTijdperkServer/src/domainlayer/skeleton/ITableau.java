package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import domainlayer.Stamlid;
import domainlayer.enums.Middel;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import domainlayer.skeleton.huttegels.IHuttegel;
import presentationlayer.skeleton.ITableauObserver;

/**
 * De interface voor het persoonlijke tableau.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface ITableau extends Remote {
	/**
	 * Het registreren van een tableau bij het model.
	 * @param observer De observer om te registreren.
	 */
	public void registerObserver(ITableauObserver observer) throws RemoteException;

	/** @return De hoeveelheid gereedschap op elk fiche. */
	public int[] getGereedschap() throws RemoteException;

	/** @return Voor elk fiche of dat deze ingezet is of niet. */
	public boolean[] getGereedschapGebruikt() throws RemoteException;

	/** @return De stamleden die inactief op het tableau staan. */
	public List<IStamlid> getStamleden() throws RemoteException;

	/**
	 * Het ontvangen van een gekozen aantal middelen.
	 * @param middel  Het type middel dat ontvangen word.
	 * @param aantal  De hoeveelheid die ontvangen word.
	 */
	public void ontvangMiddelen(Middel middel, int aantal) throws RemoteException;

	/** Het ontvangen van een nieuwe stamlid. */
	public void krijgStamlid() throws RemoteException;

	/**
	 * Het terugkrijgen van stamleden uit het speelbord.
	 * @param stamleden  De lijst met stamleden die teruggeplaatst worden.
	 */
	public void ontvangStamleden(List<IStamlid> stamleden) throws RemoteException;

	/** Het verhogen van een bestaand gereedschapsfiche. */
	public void verhoogGereedschap() throws RemoteException;

	/**
	 * Het ontvangen van een gekozen middel.
	 * @param middel  Het type middel dat ontvangen word.
	 */
	public void ontvangMiddel(Middel middel) throws RemoteException;

	/**
	 * Het ontvangen van een beschavingskaart.
	 * @param kaart  De beschavingskaart die ontvangen word.
	 */
	public void ontvangenBeschavingskaarten(IBeschavingskaart kaart) throws RemoteException;

	/** Vertel aan alle observers dat het model veranderd is. */
	public void notifyObservers() throws RemoteException;

	/** @return  Het totale aantal gereedschap. */
	public int getTotaalGereedschap() throws RemoteException;

	/** Ontvang 1 gereedschap. */
	public void geefGereedschapFiche() throws RemoteException;

	/**
	 * Verwijder een stamlid van het tableau.
	 * @param stamlid  De stamled die word ingezet.
	 */
	public void gebruikStamlid(Stamlid stamlid) throws RemoteException;

	/** @return  De eigenaar van het tableau. */
	public ISpeler getSpeler() throws RemoteException;

	/** Reset de status van al het gereedschap naar ongebruikt. */
	public void resetGereedschapStatus() throws RemoteException;

	/**
	 * Voed alle stamleden.
	 * @param middelen  De gekozen middelen om mee te voeden.
	 * @return Of het voeden succesvol verlopen is.
	 */
	public boolean voedenStamleden(Map<Middel, Integer> middelen) throws RemoteException;

	// public boolean betalenBeschavingskaart(Map<Middel, Integer> middelen, ISpeler speler) throws RemoteException;

	/** @return Een lijst van alle huttegels in bezit. */
	public List<IHuttegel> getHuttegels() throws RemoteException;

	/**
	 * Verlies 10 punten.
	 * @return Of het verliezen succesvol verlopen is.
	 */
	public boolean verliesPunten() throws RemoteException;

	/** @return Een map van alle type middelen en het aantal in bezit. */
	public Map<Middel, Integer> getMiddelen() throws RemoteException;

	/** @return Een stamlid die van het tableau gehaalt is. */
	public IStamlid popStamlid() throws RemoteException;

	/** @return Of de speler al betaald heeft. */
	public boolean getBetaalt() throws RemoteException;

	/**
	 * Verander of er al betaald is of niet.
	 * @param betaalt Of er al betaald is of nog niet.
	 */
	public void setBetaalt(boolean betaalt) throws RemoteException;

	/**
	 * Het toevoegen van een nieuwe huttegel aan het tableau.
	 * @param huttegel  De huttegel die gegeven word.
	 */
	public void geefHuttegel(IHuttegel huttegel) throws RemoteException;

	/**
	 * Het toevoegen van een nieuwe beschavingskaart aan het tableau.
	 * @param beschavingskaart  De beschavingskaart die gegeven word.
	 */
	public void geefBeschavingskaart(IBeschavingskaart beschavingskaart) throws RemoteException;

	/** @return Alle beschavingskaarten op het tableau. */
	public List<IBeschavingskaart> getKaarten() throws RemoteException;

	/**
	 * Het toevoegen van een nieuwe beschavingskaart aan het tableau.
	 * @param kaart  De beschavingskaart die gegeven word.
	 */
	public void geefBeschavingskaarten(IBeschavingskaart kaart) throws RemoteException;

	/**
	 * Het inzetten van gereedschap om de dobbelsteenworp te verhogen.
	 * @param index  De index van de stapel van het gereedschap.
	 */
	public void gebruikGereedschap(int index) throws RemoteException;

	/**
	 * Het verwijderen van een hoeveelheid verschillende middelen.
	 * @param cost  Een map met de type middelen en de hoeveelheid.
	 */
	public void verwijderMiddelen(Map<Middel, Integer> cost) throws RemoteException;
}

