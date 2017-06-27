package proceslayer.skeleton;

import java.rmi.RemoteException;
import java.rmi.Remote;

import domainlayer.skeleton.ISpeler;

public interface ILocatieController extends Remote {

	public boolean betaalKaart(ISpeler speler, int kosten) throws RemoteException;

	public void onKiesLocatie() throws RemoteException;

}
