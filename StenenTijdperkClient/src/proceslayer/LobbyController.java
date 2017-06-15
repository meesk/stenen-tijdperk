package proceslayer;

import java.rmi.RemoteException;
import java.util.regex.Pattern;

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

		int klikCounter = 0;

		if(klikCounter == 0) {
			if(view.getNaam() != "" && view.getGeboorteDatum() != null) {
				
				view.changeButton();
				
				ISpeler s;

				try {	
					// check voor correcte formaat
					spel.maakSpeler(view.getNaam(), view.getGeboorteDatum(), view.getIsSpastisch());

				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		} else if (klikCounter == 1) {
			System.out.println("Ben er klaar voor !");
		}
		
		klikCounter++;
	}

}
