package proceslayer;

import presentationlayer.EindView;
import presentationlayer.HandleidingView;
import presentationlayer.LocatieView;
import presentationlayer.SpelView;

/**
 * SpelController.java
 * Een controller klasse voor het spel.
 *
 * @author Enzo Campfens s1102421,
 * Tristan Caspers s102755
 * @version 0.2
 *
 */

public class SpelController {

	// Views hier aangemaakt
	private HandleidingView handleiding;
	private EindView view;

	public SpelController(HandleidingView handleidingPane) {
		handleiding = handleidingPane;
	}

	// Toont de handleiding als er op de knop is gedrukt.
	public void onHandleidingButtonClick() {
		handleiding.show();
	}

	public void registerView(EindView view) {
		this.view = view;
	}
}
