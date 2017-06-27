package proceslayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import domainlayer.skeleton.ISpeler;
import domainlayer.skeleton.IStamlid;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.locaties.ILocatie;
import javafx.application.Platform;
import presentationlayer.BetaalView;
import presentationlayer.GereedschapView;
import presentationlayer.LocatieView;
import proceslayer.skeleton.ILocatieController;
import stenentijdperk.StenenTijdperk;


/**
 * De controller voor de locatie.
 *
 * @author Tristan Caspers, s1102755
 * @version 3.0
 */
public class LocatieController extends UnicastRemoteObject implements ILocatieController {

	private ILocatie model;
	private LocatieView view;
	private LocatieController lController = this;
	boolean betaald = false;
	int aantal = 0;

	/**
	 * Het setten van het model.
	 * @param model  Het model ILocatie
	 */
	public LocatieController(ILocatie model) throws RemoteException{
		this.model = model;
	}

	/**
	 * Het registreren van een nieuwe view.
	 * @param view  De view die geregistreerd word.
	 */
	public void registerView(LocatieView view) {
		this.view = view;
	}

	/**
	 * De functie waarin plaatsen stamleden wordt uitgevoerd.
	 * @param spel  Het model Spel
	 * @param speler  Het model Speler
	 */
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
			BetaalView betaalView = new BetaalView(speler.getTableau(), "Selecteer een aantal stamleden om te plaatsen", false, false, true, false);
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


	public boolean betaalKaart(ISpeler speler, int kosten) throws RemoteException {
//		System.out.println("Ik kom hier");
//
//
//					System.out.println("1 BetalenBeschavingskaart");
//					System.out.println(aantal);
//					Platform.runLater(() -> {
//					try {
//						aantal = -1;
//						while (aantal == -1) {
//						BetaalView betaalview = new BetaalView(speler.getTableau(), "De kosten voor de kaart is: " + kosten, false, true, false, false);
//						betaalview.showAndWait();
//						aantal += betaalview.getHout() + betaalview.getLeem() + betaalview.getSteen() + betaalview.getGoud();
//						}
//						if (aantal > kosten){
//							System.out.println("te veel grondstoffen ingevuld");
//							betaald = false;
//						}
//						if (aantal < kosten) {
//							System.out.println("Te weinig Grondstoffen ingevuld");
//							betaald = false;
//						}
//					} catch (RemoteException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					betaald = true;
//					});
//					System.out.println("show and wait bereikt");
//
//
//
			return betaald;
	}


	/**
	 * De functie om een actie uit te voeren op het spel
	 * @param spel  Het model Spel
	 * @param speler  Het model Speler
	 * @param controller  de controller van de locatie die mee wordt gegeven
	 * @throws RemoteException
	 */
	private void uitvoerenActie(ISpel spel, ISpeler speler, ILocatieController controller) throws RemoteException {
		List<IStamlid> stamleden = new ArrayList<>();
		for (IStamlid stamlid : model.getStamleden()) {
			if (stamlid.getSpeler().equals(StenenTijdperk.getSpeler())) {
				stamleden.add(stamlid);
			}
		}
		if (stamleden.size() == 0) {
			return; // speler heeft geen stamleden op locatie
		}
		if (model.isWorpNodig()) {
			spel.getDobbelsteenWorp().werp(stamleden.size());
			if (StenenTijdperk.getSpeler().getTableau().getTotaalGereedschap() > 0) {
				GereedschapView gereedschapView = new GereedschapView(speler.getTableau());
				gereedschapView.showAndWait();
			}
		}


		model.uitvoerenActie(speler, lController);
		for (IStamlid stamlid : stamleden) {
			model.verwijderStamlid(stamlid);
		}
		speler.getTableau().ontvangStamleden(stamleden);
		StenenTijdperk.getSpeler().getTableau().notifyObservers();
		spel.fases();
	}

	/** De functie voor het afhandelen van een locatie */
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
				uitvoerenActie(spel, speler, lController);
				break;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
