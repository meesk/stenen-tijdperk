package proceslayer;

import java.rmi.RemoteException;

import domainlayer.skeleton.ISpeler;
import domainlayer.enums.SpelStatus;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.locaties.ILocatie;
import presentationlayer.BetaalView;
import presentationlayer.LocatieView;
import stenentijdperk.StenenTijdperk;

/**
 * LocatieController.java De controller voor de locatie.
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

	public void onKiesLocatie() {

		try {
			ISpel spel = StenenTijdperk.getSpel();
			ISpeler speler = StenenTijdperk.getSpeler();
			if (!speler.equals(spel.getBeurtSpeler())) {
				return; // deze speler heeft geen beurt
			}

			switch (spel.getStatus()) {
			case PLAATSEN_STAMLEDEN:
				int plaats = model.getCirkels().size() - model.getStamleden().size();
				if (plaats == 0) {
					return; // deze plek is vol
				}
				int aantal = -1;
				while (aantal == -1 || aantal > plaats) {
					BetaalView betaalView = new BetaalView(false, true, new BetaalController(speler.getTableau()));
					betaalView.showAndWait();
					aantal = betaalView.getStamleden();
				}
				if (aantal <= 0) {
					return; // stamleden plaatsen geannuleerd
				}
				model.plaatsStamleden(speler, aantal);
					
				break;
			case UITVOEREN_ACTIE:
				model.uitvoerenActie(speler);
				break;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
