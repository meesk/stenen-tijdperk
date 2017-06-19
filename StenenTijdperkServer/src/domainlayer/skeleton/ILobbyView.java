package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

import domainlayer.Spel;

public interface ILobbyView extends Remote {

	public String getNaam() throws RemoteException;

	public LocalDate getGeboorteDatum() throws RemoteException;

	public boolean getIsSpastisch() throws RemoteException;

	public String getKleur() throws RemoteException;

	public void disableButton() throws RemoteException;

	public void disableSpelerInfo() throws RemoteException;

	public void veranderKnopTextBeginnen() throws RemoteException;

	public void veranderKnopTextWachten() throws RemoteException;

	public void modelChanged(ISpel spel) throws RemoteException;
}
