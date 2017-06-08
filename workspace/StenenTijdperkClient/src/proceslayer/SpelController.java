package proceslayer;

import presentationlayer.HandleidingPane;

/**
 * SpelController.java
 * Een controller klasse voor het spel.
 * 
 * @author Enzo Campfens s1102421
 * @version 0.1
 */

public class SpelController {
	
	private HandleidingPane handleiding;
	
	public SpelController(HandleidingPane HandleidingPane) {
		handleiding = HandleidingPane;
	}
	
	public void onButtonClick() {
		handleiding.show();
	}

}
