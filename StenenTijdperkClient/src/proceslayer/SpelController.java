package proceslayer;

import presentationlayer.HandleidingView;

/**
 * SpelController.java
 * Een controller klasse voor het spel.
 * 
 * @author Enzo Campfens s1102421
 * @version 0.1
 * 
 */

public class SpelController {
	
	// Handleiding View aangemaakt hier.
	private HandleidingView handleiding;
	
	public SpelController(HandleidingView handleidingPane) {
		handleiding = handleidingPane;
	}
	
	// Toont de handleiding als er op de knop is gedrukt.
	public void onHandleidingButtonClick() {
		handleiding.show();
	}

}
