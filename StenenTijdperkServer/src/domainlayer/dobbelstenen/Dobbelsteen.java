package domainlayer.dobbelstenen;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IDobbelsteen;

/**
 * Dobbelsteen.java<br>
 * Het model van de Dobbelsteen.
 *
 * @author Erwin Olie, s1103026
 * @version 1.0
 */
public class Dobbelsteen extends UnicastRemoteObject implements IDobbelsteen {
	private static final long serialVersionUID = 1L;

	/** De waarde van de dobbelsteen */
	private int ogen;

	/** Maak een lege dobbelsteen aan. */
	public Dobbelsteen() throws RemoteException {
		reset();
	}

	/** {@inheritDoc} */
	public void reset() {
		ogen = 0;
	}

	/** Werp de dobbelsteen naar een willekeurig getal tussen 1 en 6. */
	public void werp() {
		ogen = (int) (Math.random() * 6) + 1;
	}

	/** {@inheritDoc} */
	public int getOgen() {
		return ogen;
	}
}
