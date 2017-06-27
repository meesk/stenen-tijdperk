package presentationlayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domainlayer.enums.Middel;
import domainlayer.enums.SpelStatus;
import domainlayer.skeleton.IDobbelsteenWorp;
import domainlayer.skeleton.ISpeelbord;
import domainlayer.skeleton.ISpel;
import domainlayer.skeleton.ISpeler;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentationlayer.skeleton.ISpelObserver;
import proceslayer.DobbelsteenWorpController;
import proceslayer.SpelController;
import stenentijdperk.StenenTijdperk;

/**
 * Het bestand met alle informatie om het spelbord te tekenen.
 *
 * @author Erwin Olie, s1103026
 * @author Enzo Campfens, s1102421
 * @version 3.0
 */

public class SpelView extends Stage implements ISpelObserver {

	private GridPane grid;
	private SpelController controller;

	/**
	 * Het initaliseren van de view van het spel<br>
	 * Deze view bevat alle elementen die op het scherm staan met het spele van het spel.
	 * @param speelbord  Het model van het speelbord
	 * @param spelController De controller van de view
	 * @param dobbelsteenWorpController De controller voor het afhandelen van de worp
	 * @param dobbelsteenWorp Het model voor het werpen van dobbelstenen
	 * @param model  Het model van de view (ISpel)
	 */
	public SpelView(ISpeelbord speelbord, SpelController spelController,
			DobbelsteenWorpController dobbelsteenWorpController, IDobbelsteenWorp dobbelsteenWorp, ISpel model)
			throws Exception {

		UnicastRemoteObject.exportObject(this, 0);
		model.registerObserver(this);
		controller = spelController;

		Pane pane = new Pane();

		// De grid waarop de visuele objecten geplaatst worden.
		grid = new GridPane();
		grid.setStyle("-fx-background-color: #6a5b34");

		// Het plaatsen van de views voor het speelbord en spelerstableau.
		grid.add(new SpeelbordView(speelbord), 0, 0, 4, 1);

		// Het plaatsen van de view voor de dobbelstenen & worp.
		// grid.add(new BeschavingskaartView(), 1, 2);
		grid.add(new DobbelsteenWorpView(dobbelsteenWorp, dobbelsteenWorpController), 2, 2, 2, 1);

		// Het plaatsen van de buttons.
		// grid.add(new Button("Vorige Beurt"), 1, 3);

		// De knop en de knop action voor de handleiding.
		Button handleidingButton = new Button("Handleiding");
		handleidingButton.setPrefSize(128, 145);
		handleidingButton.setOnAction(e -> spelController.onHandleidingButtonClick());
		grid.add(handleidingButton, 2, 3);

		Button opslaan = new Button("Opslaan");
		opslaan.setPrefSize(128, 145);
		opslaan.setOnAction(e -> {
			spelController.onOpslaanButtonClick();
		});
		grid.add(opslaan, 3, 3);

		pane.getChildren().add(grid);
		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	/**
	 * Deze functie weergeeft alle TableauViews
	 * @param spel Het model van de view
	 */
	private void toonSpelView(ISpel spel) throws RemoteException {
		grid.add(new TableauView(1.0, StenenTijdperk.getSpeler().getTableau()), 0, 1, 1, 3);
		List<ISpeler> spelers = spel.getSpelerLijst();
		spelers.remove(StenenTijdperk.getSpeler());
		for (int i = 1; i <= spelers.size(); i++) {
			grid.add(new TableauView(0.26, spelers.get(i - 1).getTableau()), i, 1);
		}
		for (int i = 3; i > spelers.size(); i--) {
			grid.add(new TableauView(0.26, null), i, 1);
		}
		this.setResizable(false);
		this.show();
		this.sizeToScene();
	}

	/**
	 * Deze functie toont de BetaalView voor het voeden van stamleden
	 * @param spel Het model van de view
	 */
	private void toonBetaalView(ISpel spel) throws RemoteException {

		BetaalView bv = null;
		int betalen = StenenTijdperk.getSpeler().getTableau().getStamleden().size() - StenenTijdperk.getSpel().getSpeelbord().getVoedselspoor().getMarkeerSteen(StenenTijdperk.getSpeler());

		if(StenenTijdperk.getSpeler().getTableau().getMiddelen().get(Middel.VOEDSEL) >= StenenTijdperk.getSpeler().getTableau().getStamleden().size()){
			// View opstarten zonder grondstoffen
			bv = new BetaalView(StenenTijdperk.getSpeler().getTableau(), "Aantal middelen om te betalen : " + betalen, true, false, false, true);

		} else if (betalen <= 0){
			// Verander betalen in een positive int en voeg het aantal toe aan het voedsel van de speler
			StenenTijdperk.getSpeler().getTableau().ontvangMiddelen(Middel.VOEDSEL, Math.abs(betalen));
			StenenTijdperk.getSpel().notifyEverything();
			return;
		} else {
			// View opstarten met grondstoffen
			bv = new BetaalView(StenenTijdperk.getSpeler().getTableau(), "Aantal middelen om te betalen : " + betalen, true, true, false, true);
		}
		Map<Middel, Integer> middelen;
		boolean min;
		do {
			min = false;
			middelen = new HashMap<Middel, Integer>();
			middelen.clear();

			bv.showAndWait();


			int aantalVoedsel = bv.getVoedsel();
			int aantalHout = bv.getHout();
			int aantalLeem = bv.getLeem();
			int aantalSteen = bv.getSteen();
			int aantalGoud = bv.getGoud();

			 middelen = new HashMap<Middel, Integer>();
			 middelen.put(Middel.VOEDSEL, aantalVoedsel);
			 middelen.put(Middel.HOUT, aantalHout);
			 middelen.put(Middel.LEEM, aantalLeem);
			 middelen.put(Middel.STEEN, aantalSteen);
			 middelen.put(Middel.GOUD, aantalGoud);

			 if(bv.isMinPunten()){
				 min = StenenTijdperk.getSpeler().getTableau().verliesPunten();
			 }

		}while((min == false) && (StenenTijdperk.getSpeler().getTableau().voedenStamleden(middelen) == false));
		StenenTijdperk.getSpeler().getTableau().registerObserver(bv);
		StenenTijdperk.getSpel().notifyEverything();
	}

	@Override
	/** {@inheritDoc} */
	public void modelChanged(ISpel spel) throws RemoteException {
		Platform.runLater(() -> {
			try {
				if (spel.getStart() && !this.isShowing()) {
					toonSpelView(spel);
//					String message = String.format("Je moet in totaal %d middelen betalen.", StenenTijdperk.getsp);
//					BetaalView betaal = new BetaalView(StenenTijdperk.getSpeler().getTableau(), message, true, true, false, true);
//					betaal.showAndWait();
				}
				if (spel.getVoeden()) {
					toonBetaalView(spel);
				}
				if(spel.getStatus() == SpelStatus.BEPALEN_WINNAAR) {
					controller.openEindView();
				}

			} catch (RemoteException e) {
				e.printStackTrace();
			}
		});
	}
}
