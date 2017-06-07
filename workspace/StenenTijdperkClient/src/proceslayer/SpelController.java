package proceslayer;

import presentationlayer.HandleidingPane;

public class SpelController {
	
	private HandleidingPane handleiding;
	
	public SpelController(HandleidingPane HandleidingPane) {
		handleiding = HandleidingPane;
	}
	
	public void onButtonClick() {
		handleiding.show();
	}

}
