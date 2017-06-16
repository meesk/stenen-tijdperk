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
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @version 0.3
 */

public class LobbyController {

	private ISpel spel;
	private LobbyView view;
	private ISpeler s = null;
	private int klikCounter = 0;

	public LobbyController(ISpel spel) {
		this.spel = spel;
	}

	public void registerView(LobbyView view) {
		this.view = view;
	}

	public void OnButtonClick() throws RemoteException {

		view.getKleur();

		if(view.getNaam() != "" && view.getGeboorteDatum() != null && spel.getSpelerLijst().size() > 1 && spel.getSpelerLijst().size() < 4 && klikCounter == 0) {
			view.veranderKnopTextBeginnen();
			s = spel.maakSpeler(view.getNaam(), view.getGeboorteDatum(), view.getIsSpastisch(), view.getKleur());
			view.disableSpelerInfo();
		} else if(klikCounter == 1) {
			s.klaarVoorSpeler();
			view.veranderKnopTextBeginnen();
			view.disableButton();
			spel.checkSpelers();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("invul fout");
			alert.setContentText("Alle gegevens moeten ingevult zijn!");
			alert.showAndWait();
		}

		klikCounter++;
	}
}
