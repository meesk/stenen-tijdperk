package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import domainlayer.Spel;
import domainlayer.skeleton.ISpel;

public interface ISpelObserver extends Remote {
	
	public void modelChanged(ISpel spel) throws RemoteException;
}
