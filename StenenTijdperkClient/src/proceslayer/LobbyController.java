package proceslayer;

import java.rmi.RemoteException;
import java.util.regex.Pattern;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

	public void OnButtonClick() throws RemoteException {

		int klikCounter = 0;
		ISpeler s = null;

		if(klikCounter == 0) {
			if(view.getNaam() != "" && view.getGeboorteDatum() != null && spel.getSpelerLijst().size() < 4) {

				view.changeButton();
				
				// check voor correcte formaat
				s = spel.maakSpeler(view.getNaam(), view.getGeboorteDatum(), view.getIsSpastisch());
			} else {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("invul fout");
				alert.setContentText("Alle gegevens moeten ingevult zijn!");
				alert.showAndWait();
			}
		} else if (klikCounter == 1) {
			s.klaarVoorSpeler();
			view.disableButton();
		}

		klikCounter++;
	}

}
