package domainlayer.skeleton.beschavingskaart;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.beschavingskaart.IBeschavingskaartAchtergrond;
import domainlayer.enums.BeschavingskaartStatus;
import domainlayer.skeleton.ISpeler;

public interface IBeschavingskaart extends Remote {

	public int getKosten() throws RemoteException;

	public void uitvoerenActie(ISpeler speler) throws RemoteException;

	public BeschavingskaartStatus getStatus() throws RemoteException;

	public void setStatus(BeschavingskaartStatus status) throws RemoteException;

	public String getAsset() throws RemoteException;

	public IBeschavingskaartAchtergrond getAchtergrond() throws RemoteException;
}
