package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.ISpel;
import proceslayer.DobbelsteenWorpController;
import proceslayer.skeleton.IDobbelsteenWorpController;

public class Spel extends UnicastRemoteObject implements ISpel {

	private static final long serialVersionUID = 1L;

	private DobbelsteenWorpController dobbelsteenWorpController;
	
	public Spel() throws RemoteException {
		super();
		dobbelsteenWorpController = new DobbelsteenWorpController();
	}
	
	public IDobbelsteenWorpController getDobbelsteenWorpController() {
		return dobbelsteenWorpController;
	}

}
