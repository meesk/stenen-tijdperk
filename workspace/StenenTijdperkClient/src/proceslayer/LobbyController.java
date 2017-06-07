package proceslayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import presentationlayer.LobbyView;

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
