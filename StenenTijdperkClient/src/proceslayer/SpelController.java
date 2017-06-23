package proceslayer;

import java.io.IOException;

import domainlayer.skeleton.ISpel;
import presentationlayer.EindView;
import presentationlayer.HandleidingView;
import stenentijdperk.StenenTijdperk;

/**
 * Een controller klasse voor het spel.
 *
 * @author Enzo Campfens, s1102421
 * @author Tristan Caspers, s102755
 * @version 3.0
 */
public class SpelController {

	private HandleidingView handleiding;
	private EindView view;
	private ISpel model;
	
	/**
	 * Het initialiseren van de controller
	 * @param handleidingPane  De pane om te tonen in het spelview
	 * @param spel  het model van het spel (ISpel)
	 */
	public SpelController(HandleidingView handleidingPane, ISpel spel) {
		handleiding = handleidingPane;
		model = spel;
	}

	/**
	 * Het registreren van een nieuwe view.
	 * @param view  De view die geregistreerd word.
	 */
	public void registerView(EindView view) {
		this.view = view;
	}

	/** Toont de handleiding als er op de knop is gedrukt. */
	public void onHandleidingButtonClick() {
		handleiding.show();
	}

	/** Slaat het spel in zijn huidige situatie op */
	public void onOpslaanButtonClick() {
		// TODO
		//model.opslaan();
	}
}
