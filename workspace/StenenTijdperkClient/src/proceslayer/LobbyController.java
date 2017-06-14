package proceslayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import presentationlayer.LobbyView;

/**
 * LobbyController.java
 * De controller voor de lobby.
 * 
 * @author Erwin Olie, s1103026
 * Enzo Campfens, s1102421
 * Mees Kluivers, s1102358
 * @version 0.1
 */

public class LobbyController {
	
	private ISpel spel;
	private LobbyView view;

	public LobbyController(ISpel spel) {
		this.spel = spel;
	}
	
	public void registerView(LobbyView view) {
		this.view = view;
	}

	public void OnButtonClick() {
		ISpeler s;
		
		try {	
			s = spel.maakSpeler(view.getNaam(), view.getGeboorteDatum(), view.getIsSpastisch());
			s.getNaam();
			s.getGeboorteDatum();
			s.getSpasme();
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
