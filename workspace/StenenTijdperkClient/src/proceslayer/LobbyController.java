package proceslayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import presentationlayer.LobbyView;

public class LobbyController {
	
	private ISpel spel;

	public LobbyController(ISpel spel) {
		this.spel = spel;
	}

	public void OnButtonClick() {
		ISpeler s;
		try {
			s = spel.maakSpeler("Mees");
			s.getNaam();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
