package proceslayer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
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
	
	/**
	 * Het initialiseren van de controller
	 * @param handleidingPane  De pane om te tonen in het spelview
	 * @param spel  het model van het spel (ISpel)
	 */
	public SpelController(HandleidingView handleidingPane, ISpel spel) {
		handleiding = handleidingPane;
		model = spel;
	}

	public void registerView(EindView view) {
		this.view = view;
	}

	/**
	 * Toont de handleiding als er op de knop is gedrukt.
	 */
	public void onHandleidingButtonClick() {
		handleiding.show();
	}

	/**
	 * Slaat het spel als huidige situatie op
	 * @throws IOException
	 */
	public void onOpslaanButtonClick() throws IOException {
		//view = new EindView(this, model);
		//this.view.show();
		
		StenenTijdperk.getSpeler().getTableau().geefGereedschapFiche();
		//model.opslaan();
//		for (ISpoor spoor : model.getSpeelbord().getSporen()) {
//			spoor.verhoogPunten(StenenTijdperk.getSpeler(), 1);
//			spoor.notifyObservers();
//		}
		// alleen afsluitene van de applicatie nog.
	}
}
