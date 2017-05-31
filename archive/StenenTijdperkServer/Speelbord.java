import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Speelbord extends UnicastRemoteObject implements ISpeelbord {

	private static final long serialVersionUID = 1L;
	private List<ISpeler> spelers;

	protected Speelbord() throws RemoteException {
		spelers = new ArrayList<>();
	}

	public void registerSpeler(ISpeler speler) throws RemoteException {
		synchronized (spelers) {
			spelers.add(speler);
		}
	}

	public void broadcast(String message) throws RemoteException {
		synchronized (spelers) {
			for (ISpeler speler : spelers) {
				speler.retrieve(message);
			}
		}
	}

}
