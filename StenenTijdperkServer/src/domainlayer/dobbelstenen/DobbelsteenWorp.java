package domainlayer.dobbelstenen;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import domainlayer.skeleton.IDobbelsteen;
import domainlayer.skeleton.IDobbelsteenWorp;
import presentationlayer.skeleton.IDobbelsteenWorpObserver;

/**
 * Het model van de dobbelsteenworp.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public class DobbelsteenWorp extends UnicastRemoteObject implements IDobbelsteenWorp {

	private int totaal = 0;
	private IDobbelsteen[] dobbelstenen;
	private List<IDobbelsteenWorpObserver> views;

	/** Het initializeren van dit model. */
	public DobbelsteenWorp() throws RemoteException {
		
		// Aanmaken van 10 dobbelstenen
		dobbelstenen = new IDobbelsteen[10];
		for (int i = 0; i < 10; i++) {
			dobbelstenen[i] = new Dobbelsteen();
		}
		
		views = new ArrayList<>();
	}

	@Override
	/** {@inheritDoc} */
	public void werp(int aantal) throws RemoteException {
		
		// Het werpen van het aantal dobbelstenen.
		for (int i = 0; i < aantal; i++) {
			dobbelstenen[i].werp();
		}
		
		// Het resetten van de overgebleven dobbelstenen
		for (int i = aantal; i < 10; i++) {
			dobbelstenen[i].reset();
		}
		
		berekenTotaal();
		notifyObservers();
	}

	@Override
	/** {@inheritDoc} */
	public void addObserver(IDobbelsteenWorpObserver view) throws RemoteException {
		views.add(view);
	}

	@Override
	/** {@inheritDoc} */
	public void notifyObservers() throws RemoteException {
		for (IDobbelsteenWorpObserver view : views) {
			view.modelChanged(this);
		}
	}

	@Override
	/** {@inheritDoc} */
	public IDobbelsteen[] getDobbelstenen() {
		return dobbelstenen;
	}
	
	@Override
	/** {@inheritDoc} */
	public int getTotaal() throws RemoteException {
		return totaal;
	}

	@Override
	/** {@inheritDoc} */
	public void addTotaal(int gereedschapGebruikt) throws RemoteException {
		totaal += gereedschapGebruikt;
		notifyObservers();
	}

	@Override
	/** {@inheritDoc} */
	public void berekenTotaal() throws RemoteException {
		totaal = 0;
		for (IDobbelsteen dobbelsteen : dobbelstenen) {
			totaal += dobbelsteen.getOgen();
		}
		notifyObservers();
	}


}
