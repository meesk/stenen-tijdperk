package proceslayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.ISpel;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import presentationlayer.LobbyView;
import presentationlayer.SpelView;
import stenentijdperk.StenenTijdperk;

/**
 * De controller voor de LobbyView.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @author Mees Kluivers, s1102358
 * @version 3.0
 */

public class LobbyController {

	private ISpel spel;
	private LobbyView view;
	private int klikCounter = 0;
	private SpelView spelview;

	/**
	 * Registreerd het spel in de controller
	 * @param spel  Het model van het spel
	 */
	public LobbyController(ISpel spel) {
		this.spel = spel;
	}

	/**
	 * Registreerd de lobby view in de controller
	 * @param view  De view die geregistreerd wordt.
	 */
	public void registerView(LobbyView view) {
		this.view = view;
	}

	/** Dit voert alle acties uit in de lobbyView de achter de knop hangen zoals "Maak Speler!" en "Beginnen!" */
	public void OnButtonClick() throws RemoteException {

		if(!view.getNaam().trim().isEmpty() && view.getGeboorteDatum() != null && view.getKleur() != null && spel.getSpelerLijst().size() < 4 && klikCounter == 0) {
			// Het aanmaken van een speler-instantie voor deze client.
			view.veranderKnopTextBeginnen();
			StenenTijdperk.setSpeler(spel.maakSpeler(view, view.getNaam(), view.getGeboorteDatum(), view.getIsSpastisch(), view.getKleur()));
			view.disableSpelerInfo();
			klikCounter++;
		} else if(klikCounter == 1) {
			// Het doorgeven dat de speler klaar is om te beginnen.
			StenenTijdperk.getSpeler().setSpelerKlaar();
			view.veranderKnopTextWachten();
			view.disableButton();
			spel.checkSpelers();
		} else if(view.getNaam().trim().isEmpty() || view.getGeboorteDatum() == null || view.getKleur() != null) {
			// Niet alle gegevens zijn ingevuld
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("invul fout");
            alert.setContentText("Alle gegevens moeten ingevult zijn!");
            alert.showAndWait();
        } else {
        	// Er zijn minder dan 2 spelers
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Speler fout");
            alert.setContentText("Er zijn minder dan 2 spelers!");
            alert.showAndWait();
        }
	}
}

