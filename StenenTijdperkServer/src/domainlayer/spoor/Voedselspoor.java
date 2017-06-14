package domainlayer.spoor;

/*	author Alex de Bruin, s1103096
 * 	Version 0.1
 */

import java.rmi.RemoteException;

import domainlayer.skeleton.spoor.ISpoor;

public class Voedselspoor implements ISpoor{

	private int markeersteen;


	public Voedselspoor(int markeersteen) throws RemoteException {
		this.markeersteen = markeersteen;
	}

	public int getMarkeersteen() {
		return markeersteen;
	}

	public void setMarkeersteen(int markeersteen) {
		this.markeersteen = markeersteen;
	}

}
