import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Speler extends UnicastRemoteObject implements ISpeler {
	
	private static final long serialVersionUID = 1L;
	private String naam;
	private ISpeelbord speelbord;

	protected Speler(String naam, ISpeelbord speelbord) throws RemoteException {
		this.naam = naam;
		this.speelbord = speelbord;
		speelbord.registerSpeler(this);
	}

	public void retrieve(String message) throws RemoteException {
		System.out.println(message);
	}

}
