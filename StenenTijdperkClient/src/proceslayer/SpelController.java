package proceslayer;

import java.io.IOException;
import java.rmi.RemoteException;

import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.beschavingskaart.IBeschavingskaart;
import presentationlayer.BetaalView;
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
	 * @throws RemoteException
	 */
	public SpelController(HandleidingView handleidingPane, ISpel spel) throws RemoteException {
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

	public void openEindView() {
		try {
			view = new EindView(model, model.getWinnaar());
			view.setResizable(false);
			view.show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void betalenBeschavingskaart(ISpeler speler) throws RemoteException {
		int i = speler.getTableau().getKaarten().size() - 1;
		IBeschavingskaart beschavingskaart = null;
		while (i > -1) {
			if (speler.getTableau().getKaarten().get(i) != null) {
				beschavingskaart = speler.getTableau().getKaarten().get(i);
			}
		}
		if (beschavingskaart != null) {
			int Kosten = beschavingskaart.getKosten();
		}

		BetaalView bv = new BetaalView(speler.getTableau(), "Betalen voor de beschavingskaart", false, true, false, false);
		bv.showAndWait();
	}
}
