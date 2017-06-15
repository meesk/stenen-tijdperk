package proceslayer;

import java.io.IOException;

import domainlayer.skeleton.ISpel;
import presentationlayer.EindView;
import presentationlayer.HandleidingView;

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
		model.opslaan();
		// alleen afsluitene van de applicatie nog.
	}
}
