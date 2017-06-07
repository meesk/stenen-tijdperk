package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;


public interface ISpel extends Remote {
	
	public ISpeler maakSpeler(String naam, LocalDate geboorteDatum, boolean isSpastisch) throws RemoteException;

}
