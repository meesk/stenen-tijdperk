package proceslayer;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
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
	
	private void plaatsenStamleden(ISpel spel, ISpeler speler) throws RemoteException {
		if (speler.getLaatsteLocatie() != null && speler.getLaatsteLocatie().equals(model)) {
			return; // deze locatie is vorige ronde gekozen
		}
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
		if (aantal > speler.getTableau().getStamleden().size()) {
			return; // @@TODO: remove
		}
		if (aantal <= 0) {
			return; // stamleden plaatsen geannuleerd
		}
		model.plaatsStamleden(speler, aantal);
		speler.setLaatsteLocatie(model);
		spel.fases();
	}

	private void uitvoerenActie(ISpel spel, ISpeler speler) throws RemoteException {
		List<IStamlid> stamleden = new ArrayList<>();
		for (IStamlid stamlid : model.getStamleden()) {
			if (stamlid.getSpeler().equals(StenenTijdperk.getSpeler())) {
				stamleden.add(stamlid);
			}
		}
		spel.getDobbelsteenWorp().werp(stamleden.size());
		for (IStamlid stamlid : stamleden) {
			model.verwijderStamlid(stamlid);
		}
		speler.getTableau().ontvangStamleden(stamleden);
		StenenTijdperk.getSpeler().getTableau().notifyObservers();
		model.uitvoerenActie(speler);
		spel.fases();
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
				plaatsenStamleden(spel, speler);
				break;
			case UITVOEREN_ACTIE:
				uitvoerenActie(spel, speler);
				break;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
