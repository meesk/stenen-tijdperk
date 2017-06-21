package proceslayer;

import java.io.IOException;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.spoor.ISpoor;
import presentationlayer.EindView;
import presentationlayer.HandleidingView;
import stenentijdperk.StenenTijdperk;

/**
 * SpelController.java<br>
 * Een controller klasse voor het spel.
 *
 * @author Enzo Campfens, s1102421
 * @author Tristan Caspers, s102755
 * @version 1.0
 *
 */

public class SpelController {

	// Views hier aangemaakt
	private HandleidingView handleiding;
	private EindView view;
	private ISpel model;

	public SpelController(HandleidingView handleidingPane, ISpel spel) {
		handleiding = handleidingPane;
		model = spel;
	}

	public void registerView(EindView view) {
		this.view = view;
	}

	// Toont de handleiding als er op de knop is gedrukt.
	public void onHandleidingButtonClick() {
		handleiding.show();
	}

	public void onOpslaanButtonClick() throws IOException {
		// model.opslaan();
		for (ISpoor spoor : model.getSpeelbord().getSporen()) {
			spoor.verhoogPunten(StenenTijdperk.getSpeler(), 1);
			spoor.notifyObservers();
		}

		model.eindeSpel();
		// alleen afsluitene van de applicatie nog.
	}
}
