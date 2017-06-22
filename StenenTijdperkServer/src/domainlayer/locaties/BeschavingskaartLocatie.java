package domainlayer.locaties;

import java.awt.Point;
import java.rmi.RemoteException;
import java.util.List;

import domainlayer.skeleton.ISpeler;


public class BeschavingskaartLocatie extends Locatie{
	
	
	public BeschavingskaartLocatie(int x, int y, int width, int height, List<Point> cirkels) throws RemoteException {
		super(x, y, width, height, cirkels);
	}

	@Override
	public void uitvoerenActie(ISpeler speler) throws RemoteException {
		// TODO Auto-generated method stub
	}

}
