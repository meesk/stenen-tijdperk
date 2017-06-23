package domainlayer.dobbelstenen;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IDobbelsteen;

/**
 * Het model van een losse dobbelsteen.
 *
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public class Dobbelsteen extends UnicastRemoteObject implements IDobbelsteen {
	
	private int ogen;

	/** Maak een lege dobbelsteen aan. */
	public Dobbelsteen() throws RemoteException {
		reset();
	}

	@Override
	/** {@inheritDoc} */
	public void reset() {
		ogen = 0;
	}

	@Override
	/** Werp de dobbelsteen naar een willekeurig getal tussen 1 en 6. */
	public void werp() {
		ogen = (int) (Math.random() * 6) + 1;
	}

	@Override
	/** {@inheritDoc} */
	public int getOgen() {
		return ogen;
	}
}
