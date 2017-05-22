import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISpeelbord extends Remote {
	void registerSpeler(ISpeler speler) throws RemoteException;

	void broadcast(String message) throws RemoteException;
}
