package domainlayer.dobbelstenen;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import domainlayer.skeleton.IDobbelsteen;
import domainlayer.skeleton.IDobbelsteenWorp;
import presentationlayer.skeleton.IDobbelsteenWorpObserver;

/**
 * DobbelsteenWorp.java<br>
 * Het model van de DobbelsteenWorp.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */
public class DobbelsteenWorp extends UnicastRemoteObject implements IDobbelsteenWorp {
	private static final long serialVersionUID = 1L;

	private int totaal = 0;
	/** De dobbelstenen die deze worp bezit. */
	private IDobbelsteen[] dobbelstenen;
	/** De views die dit model observeren. */
	private List<IDobbelsteenWorpObserver> views;

	/** Het initializeren van dit model. */
	public DobbelsteenWorp() throws RemoteException {
		// Aanmaken van 10 dobbelstenen
		dobbelstenen = new IDobbelsteen[10];
		for (int i = 0; i < 10; i++) {
			dobbelstenen[i] = new Dobbelsteen();
		}

		// Aanmaken van de views-list
		views = new ArrayList<>();
	}


	/** {@inheritDoc} */
	@Override
	public void werp(int aantal) throws RemoteException {
		// Het werpen van het aantal dobbelstenen.
		for (int i = 0; i < aantal; i++) {
			dobbelstenen[i].werp();
		}
		// Het resetten van de overgebleven dobbelstenen
		for (int i = aantal; i < 10; i++) {
			dobbelstenen[i].reset();
		}
		// Model is veranderd, meld dit aan de observers.
		notifyObservers();
	}

	/** {@inheritDoc} */
	@Override
	public void addObserver(IDobbelsteenWorpObserver view) throws RemoteException {
		views.add(view);
	}

	/** {@inheritDoc} */
	@Override
	public void notifyObservers() throws RemoteException {
		for (IDobbelsteenWorpObserver view : views) {
			view.modelChanged(this);
		}
	}

	/** {@inheritDoc} */
	@Override
	public IDobbelsteen[] getDobbelstenen() {
		return dobbelstenen;
	}

	@Override
	public int getTotaal() throws RemoteException {
		totaal = 0;
		for (IDobbelsteen dobbelsteen : dobbelstenen) {
			totaal += dobbelsteen.getOgen();
		}
		return totaal;
	}

	public void setTotaal(int gereedschapGebruikt) {
		totaal += gereedschapGebruikt;
	}


}
