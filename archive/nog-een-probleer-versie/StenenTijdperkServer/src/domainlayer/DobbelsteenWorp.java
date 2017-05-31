package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IDobbelsteen;
import domainlayer.skeleton.IDobbelsteenWorp;

public class DobbelsteenWorp extends UnicastRemoteObject implements IDobbelsteenWorp {
	private static final long serialVersionUID = 1L;
	
	private IDobbelsteen[] dobbelstenen;
	
	public DobbelsteenWorp() throws RemoteException {
		dobbelstenen = new IDobbelsteen[10];
		for (int i = 0; i < 10; i++) {
			dobbelstenen[i] = new Dobbelsteen();
		}
	}
	
	@Override
	public void werp(int aantal) throws RemoteException {
		for (int i = 0; i < aantal; i++) {
			dobbelstenen[i].werp();
		}
		for (int i = aantal; i < 10; i++) {
			dobbelstenen[i].reset();
		}
	}
	
	public IDobbelsteen[] getDobbelstenen() {
		return dobbelstenen;
	}

}
