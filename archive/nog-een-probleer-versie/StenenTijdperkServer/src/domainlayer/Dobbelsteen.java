package domainlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import domainlayer.skeleton.IDobbelsteen;

public class Dobbelsteen extends UnicastRemoteObject implements IDobbelsteen {
	private static final long serialVersionUID = 1L;
	
	private int ogen;

	public Dobbelsteen() throws RemoteException {
		reset();
	}
	
	public void reset() {
		ogen = 0;
	}

	public void werp() {
		ogen = (int) (Math.random() * 6) + 1;
	}

	public int getOgen() {
		return ogen;
	}

}
