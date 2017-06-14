package proceslayer;

import domainlayer.skeleton.locaties.ILocatie;
import presentationlayer.LocatieView;

/**
 * LocatieController.java
 * De controller voor de locatie.
 *
 * @author Tristan Caspers, s1102755
 * @version 0.1
 */
public class LocatieController {

	private ILocatie model;
	private LocatieView view;

	/** Het setten van het model. */
	public LocatieController(ILocatie model) {
		this.model = model;
	}


	public void registerView(LocatieView view) {
		this.view = view;
	}
}
