package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import domainlayer.Spel;
import domainlayer.skeleton.ISpel;

public interface IView extends Remote {

	// De eerste 4 hieronder moeten worden gepushed.

	public String getNaam() throws RemoteException;

	public LocalDate getGeboorteDatum() throws RemoteException;

	public boolean getIsSpastisch() throws RemoteException;

	public String getKleur() throws RemoteException;

	public void modelChanged(ISpel spel) throws RemoteException;
}
