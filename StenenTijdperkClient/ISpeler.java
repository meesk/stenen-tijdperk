import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISpeler extends Remote {
	void retrieve(String message) throws RemoteException;
}
